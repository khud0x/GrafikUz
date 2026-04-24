package com.example.grafikuz.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grafikuz.data.Category
import com.example.grafikuz.data.Course
import com.example.grafikuz.data.LessonRepository

@Composable
fun CourseListScreen(
    category: Category,
    onBack: () -> Unit,
    onCourseClick: (Course) -> Unit
) {
    val courses = LessonRepository.getCoursesByCategory(category.id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(20.dp)
    ) {

        Button(onClick = onBack) {
            Text("Orqaga")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "${category.icon} ${category.title}",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(courses) { course ->
                CourseCard(course, onClick = { onCourseClick(course) })
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.10f)
        )
    ) {
        Column(modifier = Modifier.padding(18.dp)) {

            Text(
                text = course.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = course.description,
                color = Color(0xFFE0E7FF),
                fontSize = 14.sp
            )
        }
    }
}