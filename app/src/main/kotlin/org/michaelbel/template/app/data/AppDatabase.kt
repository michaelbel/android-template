package org.michaelbel.template.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.michaelbel.template.app.data.AppDatabase.Companion.DATABASE_VERSION
import org.michaelbel.template.app.data.dao.MovieDao
import org.michaelbel.template.app.data.entity.MovieDb

@Database(entities = [MovieDb::class], exportSchema = false, version = DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        private const val DATABASE_NAME = "app_database"
        const val DATABASE_VERSION = 1

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