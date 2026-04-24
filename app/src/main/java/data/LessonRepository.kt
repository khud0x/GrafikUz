package com.example.grafikuz.data

import com.example.grafikuz.data.lessons.FigmaLessons
import com.example.grafikuz.data.lessons.PhotoshopLessons
import com.example.grafikuz.data.lessons.GraphicDesignLessons

object LessonRepository {

    fun getCoursesByCategory(categoryId: String): List<Course> {
        return when (categoryId) {
            "photoshop" -> PhotoshopLessons.courses
            "figma" -> FigmaLessons.courses
            "design" -> GraphicDesignLessons.courses
            else -> emptyList()
        }
    }

    fun getLessonsByCourse(courseId: String): List<Lesson> {
        val allCourses =
            PhotoshopLessons.courses +
                    FigmaLessons.courses +
                    GraphicDesignLessons.courses

        return allCourses
            .find { it.id == courseId }
            ?.lessons
            ?: emptyList()
    }
}