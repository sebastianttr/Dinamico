package com.sebastianttr.room.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options")
data class Options(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "ref_key") val key: String?,
    @ColumnInfo(name = "ref_value") var value: String?,
    @ColumnInfo(name = "tag") val tag: String?
)
