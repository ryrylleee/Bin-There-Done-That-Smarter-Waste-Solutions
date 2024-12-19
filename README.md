# ♻️ Bin There, Done That ♻️

## I. Project Overview
🎉 Welcome to **"Bin There, Done That!"** – a fun and interactive waste management system! This project is designed to educate users about proper waste disposal while promoting eco-friendly habits. By integrating user and admin features, it lets you categorize, log, and track waste disposal activities. Think of it as your digital buddy for making the planet greener, one waste item at a time! 🌍

## II. Application of OOP Principles
This project embodies the magic of Object-Oriented Programming (OOP) to create a clean, reusable, and scalable codebase. Here's how:

### Encapsulation:

- User and admin functionalities are neatly packed into the `User` and `Admin` classes. Each class shows only what’s necessary, keeping things secure and tidy. ✨
- The `WasteManagementSystem` class handles the heavy lifting of waste categorization and logging.

### Inheritance:

- Meet the `Waste` family! The parent class `Waste` gives life to its children: `RecyclableWaste`, `CompostableWaste`, and `HazardousWaste`, each tailored for a specific type of waste. ♻️

### Polymorphism:

- Methods like `processWaste()` and `getEcoFriendlyTip()` adapt to the waste type, showcasing different behaviors for recyclable, compostable, and hazardous items. Dynamic and smart! 💡

### Abstraction:

- Behind-the-scenes magic! Complex implementations are hidden so users can focus on what matters – disposing waste responsibly without worrying about the technicalities. 🎩

## III. Database Integration
The system uses a **MySQL database** to enhance functionality by securely storing and retrieving user and disposal data. Features include:

- **User Management**: Registered users' information is saved in the `users` table.
- **Disposal Logs**: Every waste disposal activity is logged in the `disposal_logs` table.
- **Admin Control**: Admins can view all registered users and waste disposal logs for system management.

### Database Schema

1. **`users` Table:**
   ```sql
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(50) NOT NULL,
       date_registered TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

2. **`disposal_logs` Table:**
   ```sql
   CREATE TABLE disposal_logs (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL,
       waste_item VARCHAR(255) NOT NULL,
       waste_type VARCHAR(50) NOT NULL,
       date_logged TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
   );
   ```

### Configuration
Update the database connection credentials in the `DatabaseConnection` class:
```java
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bintheredonethat"; 
    private static final String USER = "root";      
    private static final String PASSWORD = "password"; 
```

## IV. Sustainable Development Goal (SDG) Integration
This project proudly champions **SDG 12: Responsible Consumption and Production**:

- 🌿 **Education**: Teach users how to sort and manage waste responsibly.
- ♻️ **Action**: Encourage recycling and composting to minimize waste.
- 🌟 **Impact**: Provide actionable tips for sustainable living.

By categorizing waste and offering eco-friendly tips, this system promotes habits that reduce environmental impact, making it a small yet meaningful step toward a better world. 🌏

## V. Instructions for Running the Program

### Prerequisites

- **Java Development Kit (JDK)**: Make sure JDK 8 or later is installed.
- **MySQL Database**: Install and configure MySQL Server.
- **IDE or Command Line**: Use any Java-supported IDE (like IntelliJ IDEA or Eclipse) or the terminal.

### Setup

1. Clone or download the project repository.
2. Import the database schema into your MySQL server.
   - Execute the SQL commands provided in the Database Schema section to create the required tables.
3. Update the database connection details in the `DatabaseConnection` class.

### Running the Program

1. **Compile** the program:
   ```bash
   javac Main/Main.java
   ```
2. **Run** the program:
   ```bash
   java Main.Main
   ```

### Features

#### User Functionalities:

- **Register**: Create an account for logging waste disposal activities.
- **Log In**: Access your account to start categorizing waste.
- **Dispose Waste**: Enter an item name, and the system will categorize it as recyclable, compostable, or hazardous.

#### Admin Functionalities:

- **View Disposal Logs**: Review the waste items disposed of by all users, including their types and timestamps.
- **View Registered Users**: See the list of all users and their registration dates.

### Exit Gracefully

Type "exit" from the Main Menu when you’re ready to wrap up.

---

💡 **Pro Tip**: Stick around for eco-friendly tips and make waste disposal fun! Continue to make a difference :) 🌟
