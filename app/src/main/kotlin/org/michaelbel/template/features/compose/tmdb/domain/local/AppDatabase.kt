package org.michaelbel.template.features.compose.tmdb.domain.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.michaelbel.core.room.CalendarConverter
import org.michaelbel.core.room.ListStringConverter
import org.michaelbel.core.room.SizeConverter
import org.michaelbel.template.features.compose.tmdb.data.local.MovieDb

@Database(
    entities = [MovieDb::class],
    exportSchema = false,
    version = DATABASE_VERSION
)
@TypeConverters(
    CalendarConverter::class,
    ListStringConverter::class,
    SizeConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun instance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}

private const val DATABASE_NAME = "app_database"
private const val DATABASE_VERSION = 1