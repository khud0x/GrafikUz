package com.example.grafikuz.data.lessons

import com.example.grafikuz.data.Course
import com.example.grafikuz.data.Lesson

object GraphicDesignLessons {

    val courses = listOf(
        Course(
            id = "design",
            title = "Grafik dizayn asoslari",
            description = "Grafik dizaynni 0 dan o‘rganing",
            lessons = listOf(
                Lesson(
                    id = "gd1",
                    courseId = "design",
                    title = "Grafik dizayn haqida tushuncha",
                    subtitle = "Grafik dizayn nima?",
                    youtubeVideoId = "https://youtu.be/N5qV8o77TvQ?si=Z4atYvfg5db7Vt8X",
                    content = "Grafik dizayn — vizual aloqa vositasi bo‘lib, rang, shakl va tipografiya orqali fikr yetkazadi."
                )
            )
        )
    )
}