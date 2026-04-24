package com.example.grafikuz.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grafikuz.data.Category

@Composable
fun HomeScreen(
    onCategoryClick: (Category) -> Unit
) {
    val categories = listOf(
        Category("design", "Grafik dizayn", "Dizayn asoslarini o‘rganing", "🎨"),
        Category("photoshop", "Adobe Photoshop", "Rasm tahrirlashni o‘rganing", "🖼️"),
        Category("figma", "Figma", "UI/UX dizaynni o‘rganing", "🧩"),
        Category("about", "Dastur haqida", "GrafikUz platformasi haqida", "📘")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF020617),
                        Color(0xFF0F172A),
                        Color(0xFF1E293B)
                    )
                )
            )
            .padding(16.dp)
    ) {
        Text(
            text = "GrafikUz",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Grafik dizaynni mobil ilova orqali o‘rganing",
            color = Color(0xFFCBD5E1),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(95.dp)
                        .clickable { onCategoryClick(category) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.07f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = category.icon,
                            fontSize = 26.sp
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = category.title,
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = category.description,
                                color = Color(0xFFCBD5E1),
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }
    }
}