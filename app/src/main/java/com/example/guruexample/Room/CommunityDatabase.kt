package com.example.guruexample.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Community::class), version = 1, exportSchema = false)

abstract class CommunityDatabase : RoomDatabase() {

    abstract fun communityDao(): CommunityDao

    companion object {
        private var INSTANCE: CommunityDatabase? = null

        fun getInstance(context: Context): CommunityDatabase? {
            if (INSTANCE == null) {
                synchronized(CommunityDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CommunityDatabase::class.java,
                        "dbname.db"
                    ).build()
                }
            }
            return INSTANCE
        }
        fun destoryInstance() {
            INSTANCE = null
        }
    }
}