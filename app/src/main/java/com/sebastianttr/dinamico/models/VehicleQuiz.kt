package com.sebastianttr.dinamico.models

data class VehicleQuiz(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int          // is the index of the answer
)
