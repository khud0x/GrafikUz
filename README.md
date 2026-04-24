# 📱 GrafikUz

GrafikUz — bu grafik dizaynni (Photoshop, Figma va boshqa yo‘nalishlar) mobil ilova orqali o‘rganish uchun yaratilgan zamonaviy ta’lim platformasi.

---

## 🚀 Xususiyatlar

* 📚 Grafik dizayn kurslari
* 🎥 Video darslar (YouTube integratsiya)
* 📖 Matnli tushuntirishlar
* 📱 Jetpack Compose UI
* 🌙 Dark theme (premium dizayn)

---

## 🛠 Texnologiyalar

* Kotlin
* Jetpack Compose
* Android Studio
* YouTube Player API

---

## 📥 O‘rnatish (Android Studio orqali)

1. Repo’ni clone qiling:

```bash
git clone https://github.com/khud0x/GrafikUz.git
```

2. Android Studio’da oching

3. Gradle sync qiling

4. ▶️ Run tugmasini bosing

---

## 📱 Termux orqali yuklash

### 1. Termux’ni oching

### 2. Paketlarni o‘rnating:

```bash
pkg update && pkg upgrade
pkg install git
```

### 3. Repo’ni yuklab oling:

```bash
git clone https://github.com/khud0x/GrafikUz.git
cd GrafikUz
```

---

## ⚙️ APK build qilish (Termux)

> ⚠️ Tavsiya: Android Studio orqali build qilish

Agar Termux’da sinamoqchi bo‘lsangiz:

```bash
pkg install openjdk-17
chmod +x gradlew
./gradlew assembleDebug
```

APK joylashuvi:

```bash
app/build/outputs/apk/debug/app-debug.apk
```

---

## ▶️ Ilovadan foydalanish

1. Ilovani ishga tushiring
2. Kerakli bo‘limni tanlang:

   * Grafik dizayn
   * Photoshop
   * Figma
3. Kursni oching
4. Darsni tanlang
5. 🎥 Videoni tomosha qiling

---

## 📂 Loyihaning tuzilishi

```
data/
 ├── Course.kt
 ├── Lesson.kt
 ├── LessonRepository.kt
 └── lessons/

screens/
 ├── HomeScreen.kt
 ├── CourseListScreen.kt
 ├── LessonListScreen.kt
 ├── LessonDetailScreen.kt
 └── AboutScreen.kt
```

---

## ⚠️ Eslatma

Ba’zi YouTube videolar:

* app ichida ochilmasligi mumkin
* YouTube tomonidan cheklangan bo‘ladi

Bunday holatda video avtomatik YouTube’da ochiladi.

---

## 👨‍💻 Muallif

👤 **khud0x**
🚀 UzHack kanali asoschisi
🎓 Colibri Academy platformasining yaratuvchisi va egasi

---

## 📌 Kelajak rejalar

* 🧠 Test / quiz tizimi
* 🏆 Sertifikatlar
* 👤 Profil tizimi
* ☁️ Online database
* 🤖 Colibri AI integratsiyasi

---

## ⭐ Qo‘llab-quvvatlash

Agar loyiha sizga yoqsa:

* ⭐ Star bosishni unutmang
* 🤝 Hissa qo‘shishingiz mumkin
* 📢 Loyihani boshqalarga ulashing

---
