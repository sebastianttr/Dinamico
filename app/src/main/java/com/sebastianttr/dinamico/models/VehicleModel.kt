package com.sebastianttr.dinamico.models

data class VehicleModel(
    val id: Int,
    val brand: String,
    val name: String,
    val imgResId: Int,
    val vehicleQuizzes: List<VehicleQuiz> = listOf()
)
