# 📱 MyHomeApp – Simple Android Home Launcher

## 🔧 Project Overview

MyHomeApp is a custom-built Android Home Launcher that replaces the default launcher screen.
It shows a static wallpaper as the home screen and reveals a scrollable app menu when you swipe up.
The design is minimal — hiding the status and navigation bars for a clean, distraction-free view.


---

## 🧩 Features

✅ Full-screen static home wallpaper
✅ Swipe Up → Show installed apps (4 apps per row)
✅ Swipe Down → Hide app menu (return to home image)
✅ Status bar and navigation bar hidden on home
✅ Lightweight and fast (uses RecyclerView for app list)
✅ Ready to set as the default Home Launcher


---

## 🗂️ Project Structure

MyHomeApp/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/myhomeapp/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── AppAdapter.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── item_app.xml
│   │   │   │   ├── drawable/home_background.png
│   │   │   │   ├── values/colors.xml, strings.xml, styles.xml
│   │   │   ├── AndroidManifest.xml
│   ├── build.gradle
│
├── build.gradle
├── settings.gradle
├── README.txt


---

## ⚙️ Technical Details

Component	Description

Language	Java
Minimum SDK	21 (Android 5.0 Lollipop)
Compile SDK	33
Main Class	MainActivity.java
Adapter Class	AppAdapter.java
UI Design	activity_main.xml and item_app.xml
Background	home_background.png (custom wallpaper)



---

## 🚀 How to Run the Project

Step 1: Open in Android Studio

1. Download and unzip the folder MyHomeApp_project.zip.


2. Open Android Studio → File > Open → select the unzipped folder.


3. Let Gradle sync and install missing SDK components if prompted.



Step 2: Build the APK

Go to Build > Build Bundle(s)/APK(s) > Build APK(s)

After build completion → click “Locate” to open the APK folder.


Step 3: Install on Device

Copy the generated .apk to your Android phone.

Install and open it.

When prompted, select “MyHomeApp” as your default Home launcher.



---

## 📘 File Summary

File	Purpose

MainActivity.java	Handles gesture (swipe up/down), loads apps
AppAdapter.java	RecyclerView adapter to list installed apps
activity_main.xml	Main layout containing ImageView + RecyclerView
item_app.xml	Layout for individual app icons and labels
AndroidManifest.xml	Declares launcher intent filters
home_background.png	Static wallpaper image



---

## 🧑‍💻 Developer

Name: Sudarshan Ganwani
App Name: MyHomeApp
Language: Java
IDE: Android Studio