package org.michaelbel.template

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.michaelbel.core.dispatchers.di.dispatchersKoinModule
import org.michaelbel.template.datastore.AppPreferences
import org.michaelbel.template.interactor.AppInteractor
import org.michaelbel.template.ktor.AppService
import org.michaelbel.template.repository.AppRepository
import org.michaelbel.template.room.AppDao
import org.michaelbel.template.room.AppDatabase
import org.michaelbel.template.ui.list.ListViewModel
import org.michaelbel.template.ui.details2.DetailsViewModel2

val appModule = module {
    includes(dispatchersKoinModule)
    single<AppPreferences> {
        val dataStore = PreferenceDataStoreFactory.createWithPath(
            migrations = emptyList(),
            produceFile = { androidContext().filesDir.resolve(AppPreferences.DATA_STORE_NAME).absolutePath.toPath() }
        )
        AppPreferences(dataStore)
    }
    single<AppDao> {
        val appDatabase = AppDatabase.getInstance(androidContext())
        appDatabase.appDao()
    }
    single<AppService> {
        val chuckerInterceptor = ChuckerInterceptor.Builder(androidContext())
            .collector(
                collector = ChuckerCollector(
                    context = androidContext(),
                    showNotification = true,
                    retentionPeriod = RetentionManager.Period.ONE_HOUR
                )
            )
            .maxContentLength(
                length = 250_000L
            )
            .alwaysReadResponseBody(true)
            .build()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val ktorHttpClient = HttpClient(OkHttp) {
            defaultRequest {
                contentType(ContentType.Application.Json)
                url("https://api.example.com/")
            }
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = AppService.REQUEST_TIMEOUT_MILLIS
                connectTimeoutMillis = AppService.CONNECT_TIMEOUT_MILLIS
                socketTimeoutMillis = AppService.SOCKET_TIMEOUT_SECONDS
            }
            engine {
                clientCacheSize = AppService.HTTP_CACHE_SIZE_BYTES
                config {
                    addInterceptor(chuckerInterceptor)
                    addInterceptor(httpLoggingInterceptor)
                }
            }
        }
        AppService(ktorHttpClient)
    }
    single<AppRepository> { AppRepository(get(), get(), get()) }
    single<AppInteractor> { AppInteractor(get(), get()) }
    viewModelOf(::MainViewModel)
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel2)
}