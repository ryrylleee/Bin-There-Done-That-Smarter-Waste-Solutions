# Bin There, Done That 🌍♻️

## I. Project Overview

Welcome to **Bin There, Done That**—your ultimate guide to managing waste and helping save the planet, one eco-friendly tip at a time! 🌱 This Java-based application allows users to easily categorize and dispose of their waste in a way that benefits the environment. Whether you're throwing away a plastic bottle or composting food scraps, this system helps you do it right—no waste left behind! 

The system helps users learn about proper waste disposal, offers personalized eco-tips, and encourages sustainable habits. Admins can track usage and ensure everyone is sticking to the planet-friendly rules. It's time to get serious about waste, but in a fun and rewarding way! 🌍

## II. Application of Object-Oriented Programming (OOP) Principles

Our project is built using **Object-Oriented Programming (OOP)** principles, making the code structured, scalable, and easy to maintain. Here’s how it works:

1. **Encapsulation:**
   - The `Waste` class acts as a protective wrapper for each piece of waste, keeping all related data and methods neatly packed inside. Think of it like a tidy trash bag that keeps everything organized until it's ready to be disposed of! 🗑️

2. **Inheritance:**
   - Waste types like `RecyclableWaste`, `CompostableWaste`, and `HazardousWaste` inherit core features from the `Waste` class. This allows each waste type to have its own unique behavior, without repeating code. Waste doesn’t have to be complicated—it just needs to follow the rules! 🔄

3. **Polymorphism:**
   - Different types of waste use the same method (`getEcoFriendlyTip()`), but return different messages depending on the waste type. One size doesn’t fit all when it comes to disposal, so why should tips be any different? 🌿

4. **Abstraction:**
   - The complex logic behind waste processing is hidden from users. You don’t need to know how it works under the hood, just that it helps you dispose of waste responsibly. Leave the technical stuff to us! 😎

5. **Classes & Objects:**
   - From the `User` class to the `Admin` class and beyond, the program is built with objects that interact seamlessly to create a smooth, efficient waste management system. Each class serves a unique purpose, contributing to the big picture of eco-friendly disposal! 🏆

## III. Details of the Chosen SDG and Its Integration into the Project

This project is fully aligned with **Sustainable Development Goal 12**: **Responsible Consumption and Production**. 🌱 Specifically, it focuses on **Sub-goal 12.5**, which is all about **reducing waste generation through prevention, reduction, recycling, and reuse**.

### How We're Helping the Planet:

- **Waste Categorization:** Whether it’s recyclable, compostable, or hazardous, the system helps users properly categorize their waste, so it’s disposed of in the most environmentally friendly way possible. Every type of waste is important, and every type has a place in the system! 🌍

- **Eco-Friendly Tips:** With every waste disposal action, the system provides a list of useful, easy-to-follow eco-tips. Want to know how to properly dispose of plastic, or how to compost effectively? We’ve got you covered! 🌿

- **Admin Monitoring:** Admins can oversee waste logs and ensure that users are following the right steps. They help keep the system on track, ensuring that everyone gets the guidance they need to be eco-conscious and responsible. 💼

By fostering responsible disposal habits and offering helpful tips, this project champions the **3Rs**: **Reduce, Reuse, Recycle**—because it's not just about what you throw away, it’s about how you throw it away! ♻️

## IV. Instructions for Running the Program

Ready to join the recycling revolution? Here's how you can run the **Bin There, Done That** system on your own machine:

### Prerequisites

- **Java 8 or above** installed.
- Basic command-line skills (don't worry, we’ll guide you through it!). 🚀

### Steps to Run the Program

1. **Clone the Repository:**
   - First, grab the project files from GitHub:
   ```bash
   git clone https://github.com/your-username/waste-management-system.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd waste-management-system
   ```

3. **Compile the Code:**
   - Let’s bring the magic to life:
   ```bash
   javac -d bin src/Main/*.java src/Users/*.java src/Waste/*.java
   ```

4. **Run the Program:**
   - It's time to start managing waste like a pro:
   ```bash
   java -cp bin Main.Main
   ```

5. **Start Using the System:**
   - **User Login:** Whether you’re a first-timer or a seasoned eco-warrior, log in and start categorizing your waste. The more you dispose of properly, the better the planet will be! 🌍
   - **Admin Login:** Admins can manage users, monitor waste logs, and ensure everyone is following the system’s eco-friendly rules. 🛠️

### Example Workflow:

- **Step 1: Log In**
   - First, you’ll either log in or create an account. Let's get started! 🌟

- **Step 2: Waste Disposal**
   - Start disposing of your waste. Whether it’s a recyclable can or compostable banana peel, the system will categorize it and offer tips on how to dispose of it correctly. 🍌

- **Step 3: Get Eco-Friendly Tips**
   - Once you dispose of an item, the system will give you a personalized tip to help you stay eco-conscious. A little green wisdom goes a long way! 🌱

- **Step 4: View Disposal Log**
   - Curious about how much you’ve contributed to a cleaner environment? Check your personal log to see all the waste you’ve disposed of properly. 📊

- **Step 5: Admin Control**
   - Admins can monitor the overall system, view user logs, and ensure the app runs smoothly for all participants. 💼

---

### Let’s Make the World a Cleaner Place! 🌍✨

It’s time to **Bin There, Done That**—and feel great about it! By responsibly disposing of waste, you’re not just helping the environment—you’re creating a cleaner, greener world for future generations. Every small action counts! 💚

Ready to get started? Let's make waste management fun and effective! 🚮💚♻️

---