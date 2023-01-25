package com.sebastianttr.room.dao

import androidx.room.*
import com.sebastianttr.room.entites.Options

@Dao
interface OptionsDao {
    @Query("SELECT * FROM options")
    fun getAll(): List<Options>

    @Query("SELECT * FROM options WHERE tag = :tag")
    suspend fun findAllByTag(tag: String): List<Options>

    @Query("SELECT * FROM options WHERE ref_key = :key")
    suspend fun findAllByKey(key: String): List<Options>

    @Query("DELETE FROM options WHERE ref_key = :key")
    suspend fun deleteByKey(key: String);

    @Query("DELETE FROM options")
    suspend fun deleteAll();

    @Update
    suspend fun updateOption(vararg options: Options)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOption(option: Options)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOptions(options: List<Options>)
}