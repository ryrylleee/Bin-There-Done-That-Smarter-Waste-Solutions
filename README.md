# 🌱 Bin There, Done That!♻️
**Smart Waste Management System**
---

## 🚀 About the Project  
**Bin There, Done That!** is a fun and interactive Java console application designed to promote sustainable waste management practices. Whether you’re sorting recyclables, logging your eco-friendly habits, or learning cool green tips, this app has got your back!  

This project aligns with **SDG 12 - Responsible Consumption and Production** by encouraging responsible waste disposal and raising awareness about environmental impact.

---
## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Folder Structure](#folder-structure)
- [How to Use](#how-to-use)
- [Classes Overview](#classes-overview)
- [Future Improvements](#future-improvements)

---
## Overview  
*Bin There, Done That* is a Java-based console application designed to educate users about proper waste disposal and promote eco-friendly practices. Users can categorize waste items, receive eco-friendly tips, and track their disposal history for environmental impact.

---
## Features  
1. **User Registration & Login**:
   - Users can register, log in, and securely access features.
2. **Admin Panel**:
   - Admins can view the disposal log and registered users.
3. **Waste Categorization**:
   - Disposes of items as *Compostable*, *Recyclable*, or *Hazardous*.
4. **Eco-Friendly Tips**:
   - Receive suggestions for reducing waste and environmental impact.
5. **Logging Disposals**:
   - Tracks disposals for impact analysis.
6. **User-Friendly Interface**:
   - ASCII art headers and structured menus for an engaging experience.

---
## Folder Structure  
```
BIN-THERE-DONE-THAT
│
├── Main
│   ├── Main.java                   // Entry point of the application
│   ├── WasteManagementSystem.java  // Core waste categorization and logging
│
├── Users
│   ├── Admin.java                  // Admin-specific functionalities
│   ├── User.java                   // User-specific functionalities
│
├── Waste
│   ├── Waste.java                  // Base waste class
│   ├── CompostableWaste.java       // Handles compostable items
│   ├── RecyclableWaste.java        // Handles recyclable items
│   ├── HazardousWaste.java         // Handles hazardous items
│
```
---
## How to Use  

### 1. Setup  
- **Requirements**:  
  - Java Development Kit (JDK 8 or above).  
  - A terminal or IDE (e.g., IntelliJ, Eclipse).  

- **Run Instructions**:  
  - Compile the project:  
    ```bash
    javac Main/Main.java
    ```  
  - Execute the program:  
    ```bash
    java Main.Main
    ```

---
### 2. Menu Options  
---
#### **Main Menu**
- **Register (User)**: Create a new user account.  
- **Login (User)**: Access waste management functionalities.  
- **Admin Login**: Access the admin menu for system insights.  
- **Exit**: Exit the application.

#### **User Menu**
- Dispose of items, categorize them, and receive eco-friendly tips.
- Optionally log waste disposal for tracking.

#### **Admin Menu**
- **View Disposal Log**: See logged waste disposals.  
- **View Registered Users**: See a list of all registered users.  
- **Logout**: Return to the main menu.

---
## Classes Overview  
--- 
### 1. **Main.java**  
Handles the core application flow, displaying menus, and managing user interaction.

### 2. **WasteManagementSystem.java**  
- Categorizes items into **Compostable**, **Recyclable**, or **Hazardous**.  
- Logs waste disposals for later review.  

### 3. **User.java**  
- Implements registration and login for regular users.  
- Allows users to interact with the waste management system.  

### 4. **Admin.java**  
- Provides admin login and access to management tools like disposal logs and user data.  

### 5. **Waste Package**  
- **Waste.java**: Base class for waste items.  
- **CompostableWaste.java**: Handles compostable waste logic.  
- **RecyclableWaste.java**: Handles recyclable waste logic.  
- **HazardousWaste.java**: Handles hazardous waste logic.  

---
## Future Improvements  
---
- **Graphical User Interface (GUI)** for enhanced user experience.  
- Integration with a database for persistent storage of users and logs.  
- Machine learning to improve waste categorization.  
- Gamification to reward users for eco-friendly practices.  

---
## Authors  
---
- [Your Name or Team Name]
 