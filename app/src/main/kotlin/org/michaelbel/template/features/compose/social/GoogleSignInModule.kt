package org.michaelbel.template.features.compose.social

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GoogleSignInModule {

    //const val CLIENT_SECRET = "rmQ3Ri3-B0ewWESSkhHYY4TG"

    @Provides
    @GoogleClientId
    fun provideGoogleClientId(): String = "33042426453-pd3k32g9ns2c73v9npvm6ni82q9kgl3u.apps.googleusercontent.com"

    @Provides
    fun provideGoogleSignInOptions(
        @GoogleClientId clientId: String
    ): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(clientId)
            .requestEmail()
            .requestProfile()
            .build()
    }

    @Provides
    fun provideGoogleSignInClient(
        @ApplicationContext context: Context,
        options: GoogleSignInOptions
    ): GoogleSignInClient = GoogleSignIn.getClient(context, options)
}