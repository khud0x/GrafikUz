package com.example.grafikuz.data

data class Course(
    val id: String,
    val title: String,
    val description: String,
    val lessons: List<Lesson>
)