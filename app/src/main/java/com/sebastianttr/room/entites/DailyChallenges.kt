package com.sebastianttr.room.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DailyChallenges(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "achieved") val achieved: Int?,
    @ColumnInfo(name = "toAchieve") val toAchieve: Int?,
    @ColumnInfo(name = "imgId") val imgId: Int?,
)
