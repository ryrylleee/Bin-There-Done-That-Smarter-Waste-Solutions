# ♻️Bin There, Done That♻️

## I. Project Overview

🎉 Welcome to **"Bin There, Done That!"** – a fun and interactive waste management system! This project is designed to educate users about proper waste disposal while promoting eco-friendly habits. By integrating user and admin features, it lets you categorize, log, and track waste disposal activities. Think of it as your digital buddy for making the planet greener, one waste item at a time! 🌍

## II. Application of OOP Principles

This project embodies the magic of Object-Oriented Programming (OOP) to create a clean, reusable, and scalable codebase. Here's how:

1. **Encapsulation**:

   - User and admin functionalities are neatly packed into the `User` and `Admin` classes. Each class shows only what’s necessary, keeping things secure and tidy. ✨
   - The `WasteManagementSystem` class handles the heavy lifting of waste categorization and logging.

2. **Inheritance**:

   - Meet the `Waste` family! The parent class `Waste` gives life to its children: `RecyclableWaste`, `CompostableWaste`, and `HazardousWaste`, each tailored for a specific type of waste. ♻️

3. **Polymorphism**:

   - Methods like `processWaste()` and `getEcoFriendlyTip()` adapt to the waste type, showcasing different behaviors for recyclable, compostable, and hazardous items. Dynamic and smart! 💡

4. **Abstraction**:

   - Behind-the-scenes magic! Complex implementations are hidden so users can focus on what matters – disposing waste responsibly without worrying about the technicalities. 🎩

## III. Sustainable Development Goal (SDG) Integration

This project proudly champions **SDG 12: Responsible Consumption and Production**:

- 🌿 **Education**: Teach users how to sort and manage waste responsibly.
- ♻️ **Action**: Encourage recycling and composting to minimize waste.
- 🌟 **Impact**: Provide actionable tips for sustainable living.

By categorizing waste and offering eco-friendly tips, this system promotes habits that reduce environmental impact, making it a small yet meaningful step toward a better world. 🌏

## IV. Instructions for Running the Program

### Prerequisites

- **Java Development Kit (JDK)**: Make sure JDK 8 or later is installed.
- **IDE or Command Line**: Use any Java-supported IDE (like IntelliJ IDEA or Eclipse) or the terminal.

### Setup

1. Clone or download the project repository.
2. Navigate to the project directory.

### Running the Program

1. **Compile** the program:
   ```
   javac Main/Main.java
   ```
2. **Run** the program:
   ```
   java Main.Main
   ```

4. **Explore the System**  
   - **Users**: Register, log in, and start categorizing waste.  
   - **Admins**: Log in to view disposal logs and manage users.  

5. **Exit Gracefully**  
   Type "exit" from the Main Menu when you’re ready to wrap up.  

---

💡 **Pro Tip**: Stick around for eco-friendly tips and make waste disposal fun! Continue to make a difference :) 🌟  
