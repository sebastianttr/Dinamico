package com.sebastianttr.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sebastianttr.room.dao.OptionsDao
import com.sebastianttr.room.entites.Options

@Database(entities = [Options::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun optionsDao(): OptionsDao
}