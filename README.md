# **🗑️ Bin There, Done That ♻️**  
**Smart Waste Management System**
---

## **I. Project Overview**  

Welcome to **Bin There, Done That** — a smarter way to manage your waste while saving the planet! 🗑️♻️  

This innovative system empowers you to:  
- **Dispose responsibly**: Classify waste into Compostable, Recyclable, or Hazardous.  
- **Learn eco-friendly tips**: Get practical advice to reduce waste and live sustainably.  
- **Track your impact**: Log your disposals to see how you’re contributing to a cleaner world!  

Plus, we’ve got a **powerful Admin Module** that enables admins to view disposal logs and manage registered users effortlessly. It’s waste management, reimagined for a greener tomorrow! 🌟  

---

## **II. How OOP Makes This Shine**  

We’ve harnessed the power of **Object-Oriented Programming (OOP)** to make this system modular, reusable, and a breeze to maintain! Here’s how:  

1. **🔒 Encapsulation**  
   - Sensitive data like user credentials and waste logs are securely stored in private fields.  
   - Public methods like `register()` and `login()` ensure controlled access to the data.  

2. **🎭 Abstraction**  
   - The `Waste` class acts as the backbone of our waste types. Users don’t need to know the technical details—just input your item, and we’ll do the categorizing magic!  

3. **🔗 Inheritance**  
   - Waste types like `CompostableWaste`, `HazardousWaste`, and `RecyclableWaste` inherit common properties from the `Waste` class. Less code, more reuse!  

4. **🌀 Polymorphism**  
   - With methods like `categorizeWaste()`, we dynamically decide which waste class to use based on your input. It’s flexibility at its finest!  

---

## **III. Our Chosen SDG: Responsible Consumption and Production**  

This project is inspired by **Sustainable Development Goal (SDG) 12: Responsible Consumption and Production**. 🌿  

Here’s how we integrate it:  
- **🚮 Proper Waste Disposal**: Users are guided to sort waste accurately, reducing pollution and increasing recycling rates.  
- **📚 Education**: Eco-friendly tips encourage sustainable habits in everyday life.  
- **📊 Waste Tracking**: By logging your disposals, you can visualize your impact on the environment.  

Together, these features foster a culture of responsibility and sustainability, making a cleaner, greener planet achievable! 🌏💚  

---

## **IV. How to Run the Program**  

Ready to dive in? Here’s your guide to running **Bin There, Done That** and making a difference!  

### **🔧 Prerequisites**  
- **Java Development Kit (JDK)** installed (version 8 or higher).  
- An IDE (like IntelliJ or Eclipse) or terminal to compile and run Java code.  

### **🏗️ Project Structure**  
Your project directory should look like this:  
```
/Main
    - Main.java
    - WasteManagementSystem.java
/Users
    - Admin.java
    - User.java
/Waste
    - Waste.java
    - CompostableWaste.java
    - HazardousWaste.java
    - RecyclableWaste.java
```  

### **🚀 Steps to Run**  

1. **Download the Project**  
   Clone or download the project to your local machine.  

2. **Compile the Code**  
   Open a terminal in the project directory and run:  
   ```bash  
   javac Main/Main.java Users/*.java Waste/*.java  
   ```  

3. **Run the Program**  
   Execute the program with:  
   ```bash  
   java Main.Main  
   ```  

4. **Explore the System**  
   - **Users**: Register, log in, and start categorizing waste.  
   - **Admins**: Log in to view disposal logs and manage users.  

5. **Exit Gracefully**  
   Type "exit" from the Main Menu when you’re ready to wrap up.  

---

💡 **Pro Tip**: Stick around for eco-friendly tips and make waste disposal fun! Your small actions can lead to a big impact. 🌟  

---
# About the Author
- Hi, I'm Karylle. 
