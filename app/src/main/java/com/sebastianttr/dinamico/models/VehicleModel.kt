package com.sebastianttr.dinamico.models

import com.sebastianttr.dinamico.R
import java.io.Serializable

data class VehicleStat(
    val stat: String,
    val description: String
): Serializable

data class VehicleInfo(
    val category: String,
    val stat: List<VehicleStat> = listOf()
): Serializable

data class VehicleDescription(
    val title: String,
    val text: String
): Serializable

data class VehicleQuiz(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int          // is the index of the answer
): Serializable


data class VehicleModel(
    val id: Int,
    val brand: String,
    val name: String,
    val imgResId: Int,
    val imgResIdOwn: Int,
    val coverImgResId: Int = R.drawable.laferrari,
    val vehicleKeyInfo: List<VehicleInfo> = listOf(),
    val vehicleDescription: List<VehicleDescription> = listOf(),
    val vehicleQuizzes: List<VehicleQuiz> = listOf()
) : Serializable
