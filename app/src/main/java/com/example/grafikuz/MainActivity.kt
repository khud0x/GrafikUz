package com.example.grafikuz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.grafikuz.data.Category
import com.example.grafikuz.data.Course
import com.example.grafikuz.data.Lesson
import com.example.grafikuz.screens.AboutScreen
import com.example.grafikuz.screens.CourseListScreen
import com.example.grafikuz.screens.HomeScreen
import com.example.grafikuz.screens.LessonDetailScreen
import com.example.grafikuz.screens.LessonListScreen
import com.example.grafikuz.ui.theme.GrafikUzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GrafikUzTheme {
                GrafikUzApp()
            }
        }
    }
}

@Composable
fun GrafikUzApp() {
    var selectedCategory: Category? by remember { mutableStateOf(null) }
    var selectedCourse: Course? by remember { mutableStateOf(null) }
    var selectedLesson: Lesson? by remember { mutableStateOf(null) }

    val category = selectedCategory
    val course = selectedCourse
    val lesson = selectedLesson

    when {
        category?.id == "about" -> {
            AboutScreen(
                onBack = {
                    selectedCategory = null
                    selectedCourse = null
                    selectedLesson = null
                }
            )
        }

        lesson != null -> {
            LessonDetailScreen(
                lesson = lesson,
                onBack = { selectedLesson = null }
            )
        }

        course != null -> {
            LessonListScreen(
                course = course,
                onBack = {
                    selectedCourse = null
                    selectedLesson = null
                },
                onLessonClick = { selectedLesson = it }
            )
        }

        category != null -> {
            CourseListScreen(
                category = category,
                onBack = {
                    selectedCategory = null
                    selectedCourse = null
                    selectedLesson = null
                },
                onCourseClick = {
                    selectedCourse = it
                    selectedLesson = null
                }
            )
        }

        else -> {
            HomeScreen(
                onCategoryClick = {
                    selectedCategory = it
                    selectedCourse = null
                    selectedLesson = null
                }
            )
        }
    }
}