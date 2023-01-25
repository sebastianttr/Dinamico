package com.sebastianttr.room.database

import android.content.Context
import android.util.Log
import androidx.annotation.RestrictTo
import androidx.compose.ui.platform.LocalConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sebastianttr.room.dao.OptionsDao
import com.sebastianttr.room.entites.Options
import kotlinx.coroutines.CoroutineScope

/*

The options we need:

'UserProfile': String,
'Name': String,
'Email': String,
'Password': String,     -> HASHED!!!
'Notification': Boolean,
'Dark Theme': Boolean,
'Open Animation': Boolean,
'Receive friend requests': Boolean,
'Set profile to 'Public'': Boolean,
'Personalization and tracking for advertising': Boolean
 */

val dbOptions: List<Options> = listOf(
    Options(0,"Notification","false","General"),
    Options(1,"Open Animation","false","General"),
    Options(2,"Receive friend requests","false","General"),
    Options(3,"Set profile to 'Public'","false","General"),
    Options(4,"Personalization and tracking for advertising","false","Privacy"),
)

object Database {
    lateinit var db: AppDatabase;

    suspend fun getDb(ctx: Context): AppDatabase{
        if(!::db.isInitialized){
            db = Room.databaseBuilder(ctx,AppDatabase::class.java,"dinamico").build();
            runInitScript();
            return db;
        }
        else {
            return db;
        }
    }

    private suspend fun runInitScript(){
        //db.optionsDao().deleteAll()
        db.optionsDao().insertOptions(dbOptions)
    }

    fun getOptionsDb(): OptionsDao {
        if(!::db.isInitialized){
            Log.e("DB", "Database is not initialized.")
            throw Error("No database is initialized.")
        }
        else {
            return db.optionsDao();
        }
    }
}