package org.michaelbel.shared.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BoarEntity::class],
    version = AppDatabase.DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun appDao(): BoarDao

    companion object {
        private const val DATABASE_NAME = "boars.db"
        const val DATABASE_VERSION = 1

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}
