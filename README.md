Multithreaded GUI Note-Taking App
📌 Project Overview
The Multithreaded Note-Taking App is a desktop application built using Java Swing, designed to provide a seamless and interactive note-taking experience while ensuring user engagement.

It features a multithreaded background timer that detects inactivity and prompts the user with a reminder to take a break. Additionally, the app includes auto-save functionality, a dark mode toggle, and real-time word count tracking.

🎯 Project Goal
The primary goal of this project is to demonstrate multithreading in a GUI environment by implementing an automated inactivity timer while providing a modern, user-friendly note-taking experience. The app aims to:

Encourage productivity by reminding users to take breaks.
Automatically save notes to prevent data loss.
Provide a sleek, customizable UI with dark mode support.
🚀 Features
✅ Multithreaded Background Inactivity Timer

Detects when the user has not typed for 1 minute.
Prompts the user with a "Do you need a break?" message.
Allows the user to continue or save their note before taking a break.
✅ Auto-Save Functionality

Automatically saves the note every 30 seconds to prevent data loss.
✅ Real-Time Word Count Tracking

Displays a live word count, updating as the user types.
✅ Dark Mode Toggle

Easily switch between light mode and dark mode for a comfortable reading experience.
✅ Customizable Inactivity Timer

Users can adjust the inactivity time if needed.
✅ Modern UI Design

Uses Java Swing for a responsive and intuitive interface.
✅ File Saving Support

Saves notes to a user-specified filename.
🛠 Installation
Step 1: Clone the Repository
sh
Copy
Edit
git clone https://github.com/GrihmLord/multithreaded-GUI-application.git
cd multithreaded-GUI-application
Step 2: Compile the Java File
sh
Copy
Edit
javac EnhancedNoteApp.java
Step 3: Run the Application
sh
Copy
Edit
java EnhancedNoteApp
Step 4: Create a JAR File (Optional)
sh
Copy
Edit
jar cfm EnhancedNoteApp.jar manifest.txt EnhancedNoteApp.class
Step 5: Run the JAR File
sh
Copy
Edit
java -jar EnhancedNoteApp.jar
📸 Screenshots
1️⃣ Light Mode UI
(Insert a screenshot of the application in light mode)

2️⃣ Dark Mode UI
(Insert a screenshot of the application in dark mode)

3️⃣ Inactivity Timer Alert
(Insert a screenshot of the break prompt message)

📖 How to Use
Write Your Notes

Type directly into the note-taking text area.
Set a Filename & Save

Enter a filename in the text field and click "Save Note".
Break Reminder Feature

If inactive for 1 minute, the app prompts: "Do you need a break?"
If "Yes, break!" is selected, the note is saved.
If "No, continue." is selected, the timer resets.
Auto-Save Functionality

The app automatically saves the note every 30 seconds.
Dark Mode Toggle

Click "Dark Mode" to switch themes.
👨‍💻 Tech Stack
Programming Language: Java
GUI Framework: Swing
Multithreading: ExecutorService for timer handling
💡 Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch (feature-xyz).
Make your changes.
Commit and push.
Submit a Pull Request.
📜 License
This project is open-source under the MIT License.

📬 Contact
🔹 Author: GrihmLord
🔹 Repository: GitHub

This README provides a full overview, installation guide, usage details, and contribution steps. Let me know if you'd like any modifications! 🚀🔥


2/2

You said:
NO PRE TEXT READ ME ONLY
ChatGPT said:
markdown
Copy
Edit
# Multithreaded GUI Note-Taking App

## 📌 Project Overview
The **Multithreaded Note-Taking App** is a Java Swing-based desktop application designed for efficient note-taking with automated reminders. It detects user inactivity and prompts the user to take a break while ensuring data is automatically saved.

## 🎯 Project Goal
This application demonstrates the use of **multithreading in a GUI** environment by running an automated background timer. The goal is to enhance user experience through **inactivity detection, auto-saving, and UI customization** while promoting productivity.

## 🚀 Features
- **Multithreaded Inactivity Timer** – Alerts the user after **1 minute** of inactivity.
- **Auto-Save Functionality** – Saves notes **every 30 seconds** to prevent data loss.
- **Live Word Count Tracker** – Displays the current word count in real-time.
- **Dark Mode Toggle** – Switch between **light mode** and **dark mode**.
- **Customizable Inactivity Timer** – Users can adjust the inactivity duration.
- **Modern UI Design** – Clean, responsive, and easy to navigate.
- **File Saving Support** – Save notes to a user-specified filename.

## 🛠 Installation
### Step 1: Clone the Repository
```sh
git clone https://github.com/GrihmLord/multithreaded-GUI-application.git
cd multithreaded-GUI-application
Step 2: Compile the Java File
sh
Copy
Edit
javac EnhancedNoteApp.java
Step 3: Run the Application
sh
Copy
Edit
java EnhancedNoteApp
Step 4: Create a JAR File (Optional)
sh
Copy
Edit
jar cfm EnhancedNoteApp.jar manifest.txt EnhancedNoteApp.class
Step 5: Run the JAR File
sh
Copy
Edit
java -jar EnhancedNoteApp.jar
📸 Screenshots
(Insert screenshots of the app in light mode, dark mode, and inactivity timer alert.)

📖 How to Use
Write Your Notes – Type directly in the note-taking text area.
Set a Filename & Save – Enter a filename and click "Save Note".
Break Reminder Feature – If inactive for 1 minute, the app asks: "Do you need a break?".
Selecting "Yes, break!" saves the note.
Selecting "No, continue." resets the timer.
Auto-Save – Notes are saved every 30 seconds automatically.
Dark Mode – Click "Dark Mode" to toggle between light and dark themes.
👨‍💻 Tech Stack
Programming Language: Java
GUI Framework: Swing
Multithreading: ExecutorService for timer handling
💡 Contributing
Contributions are welcome! Follow these steps to contribute:

Fork the repository.
Create a new branch (feature-xyz).
Make your changes.
Commit and push.
Submit a Pull Request.
📜 License
This project is licensed under the MIT License.

📬 Contact
🔹 Author: GrihmLord
🔹 Repository: GitHub