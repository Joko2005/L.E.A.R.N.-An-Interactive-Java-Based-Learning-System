# L.E.A.R.N.  - An Interactive Java-Based Learning System

![Java](https://img.shields.io/badge/Java-100%25-orange)
![Platform](https://img.shields.io/badge/platform-Desktop-lightgrey)

**L.E.A.R.N.** (Learning and Educational Application with Resource Navigation) is a comprehensive interactive learning system built entirely in Java. The application features a modern GUI with role-based access control, offering multiple educational modules including quizzes, chatbot assistance, and data visualization tools.

## 📋 Table of Contents

- [Features](#features)
- [System Architecture](#system-architecture)
- [User Roles](#user-roles)
- [Modules](#modules)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [Credits](#credits)

## ✨ Features

- **Role-Based Access Control** - Three distinct user roles (Guest, User, Admin) with customized permissions
- **Interactive Dashboard** - Central navigation hub with personalized welcome messages
- **Quiz Module** - Test knowledge in history with score-based recommendations
- **Simple Chatbot** - Healthy lifestyle information bot with predefined Q&A
- **Data Visualization** - Interactive charts for monitoring inventory and sales
- **Credits System** - View project team and instructor information
- **Real-Time Clock** - Live date and time display
- **Modern UI/UX** - Custom-designed interface with gradient buttons and smooth animations
- **Secure Login** - User authentication with role assignment

## 🏗️ System Architecture

The application follows a modular architecture with distinct packages for each feature:

```
src/
├── login_page/          # Authentication module
├── dashboard/           # Main dashboard and navigation
│   ├── UI/             # Dashboard user interface
│   ├── roles/          # User role definitions
│   └── icons/          # Dashboard assets
├── quiz/               # Quiz module
├── chatbot/            # Chatbot module
├── datavisualization/  # Data visualization charts
├── credits/            # Credits page
└── commons/            # Shared utilities and components
    ├── UIPositionUtil   # UI positioning helper
    ├── NavigationUtil   # Frame navigation utility
    ├── RoundButton      # Custom rounded button component
    └── GradientButton   # Custom gradient button component
```

## 👥 User Roles

### 🔓 Guest
- **Access:** Limited
- **Features:**
  - ✅ Data Visualization
  - ✅ Credits
  - ❌ Take Quiz
  - ❌ Simple Chatbot

### 👤 User
- **Access:** Standard
- **Features:**
  - ✅ Take Quiz
  - ✅ Simple Chatbot
  - ✅ Credits
  - ❌ Data Visualization

### 🔑 Admin
- **Access:** Full
- **Features:**
  - ✅ Take Quiz
  - ✅ Simple Chatbot
  - ✅ Data Visualization
  - ✅ Credits

## 📦 Modules

### 1. Dashboard Module
The central navigation hub that adapts to user roles and provides access to all available features.

**Key Features:**
- Role-based interface configuration
- Real-time date and time display
- Personalized welcome messages
- Quick access to all modules via sidebar or feature cards

### 2. Quiz Module
Interactive history quiz with scoring and recommendations.

**Key Features:**
- Multiple-choice questions
- Score tracking
- Performance-based recommendations
- Available to User and Admin roles

### 3. Simple Chatbot (Hetty - Healthy Bot)
A conversational chatbot providing healthy lifestyle information.

**Key Features:**
- 12+ predefined questions about healthy living
- Topics include exercise, nutrition, sleep, stress management, and mental health
- Conversation reset functionality
- Question selection with auto-disable to prevent repetition

**Sample Topics:**
- Importance of regular exercise
- Benefits of a balanced diet
- Importance of drinking water
- Sleep and health
- Stress management techniques
- Mental health and lifestyle connection

### 4. Data Visualization Module
Interactive charts for monitoring business metrics. 

**Key Features:**
- Inventory tracking charts
- Sales data visualization
- Bar charts and pie charts
- Available to Guest and Admin roles

### 5. Credits Module
Displays information about the development team and instructor.

**Key Features:**
- Team member profiles
- Instructor information
- Project acknowledgments
- Available to all roles

## 📸 Screenshots

### Guest Dashboard
![Guest Dashboard](<img width="1919" height="1079" alt="Screenshot 2026-01-03 003636" src="https://github.com/user-attachments/assets/a68ed35e-9a71-4f91-bd17-871181e2dec4" />)
*Limited access dashboard for guest users*

### User Dashboard
![User Dashboard](<img width="1919" height="1079" alt="Screenshot 2026-01-03 003732" src="https://github.com/user-attachments/assets/6cd0f4c7-7280-4c1e-b407-51ea5e01d9c1" />)

*Standard access dashboard with quiz and chatbot features*

### Admin Dashboard
![Admin Dashboard](<img width="1919" height="1079" alt="Screenshot 2026-01-03 003757" src="https://github.com/user-attachments/assets/5c0fc795-2897-4482-a69c-d5a7e94a487f" />)

*Full access dashboard with all features enabled*

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (recommended) or any Java IDE
- Minimum 4GB RAM
- Windows/macOS/Linux operating system

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Joko2005/L.E. A.R.N.-An-Interactive-Java-Based-Learning-System.git
   ```

2. **Navigate to the project directory**
   ```bash
   cd L.E.A.R.N.-An-Interactive-Java-Based-Learning-System
   ```

3. **Open in NetBeans**
   - Launch NetBeans IDE
   - Go to `File > Open Project`
   - Select the project folder
   - Wait for dependencies to load

4. **Build the project**
   ```bash
   # Using NetBeans:  Right-click project > Clean and Build
   # Or use command line: 
   javac -d bin src/**/*.java
   ```

5. **Run the application**
   ```bash
   # Using NetBeans: Press F6 or click Run
   # Or use command line:
   java -cp bin login_page.login
   ```

## 💻 Usage

### Login Credentials

**User Access:**
- Username: `Luisa Fernandez`
- Password: `User123`

**Admin Access:**
- Username: `Joko Comia`
- Password: `Admin123`

### Navigation

1. **Login** - Enter credentials to access the system
2. **Dashboard** - View available features based on your role
3. **Sidebar Navigation** - Click any module button to navigate
4. **Feature Cards** - Click action buttons on cards to access modules
5. **Logout** - Click the logout button to return to login screen

### Using the Dashboard

- **Minimize Window:** Click the `–` button in the top-right corner
- **Close Application:** Click the `×` button in the top-right corner
- **Access Modules:** Use sidebar buttons or feature card buttons
- **View Profile:** Check the left sidebar for your name and role

## 🛠️ Technology Stack

- **Language:** Java (100%)
- **GUI Framework:** Java Swing
- **IDE:** NetBeans
- **Build Tool:** NetBeans Ant-based build system
- **Design Pattern:** MVC (Model-View-Controller)
- **Layout Managers:** 
  - BorderLayout
  - GroupLayout
  - AbsoluteLayout (for precise component positioning)

## 📁 Project Structure

```
L.E.A.R.N.-An-Interactive-Java-Based-Learning-System/
│
├── src/                          # Source code
│   ├── login_page/              # Login module
│   ├── dashboard/               # Dashboard module
│   │   ├── UI/                 # User interface
│   │   │   └── DashboardUI.java
│   │   ├── roles/              # Role definitions
│   │   └── icons/              # Image resources
│   ├── quiz/                    # Quiz module
│   │   └── QuizUI.java
│   ├── chatbot/                 # Chatbot module
│   │   └── Chatbot1.java
│   ├── datavisualization/       # Data visualization
│   │   └── ui/
│   │       └── DataVisUI.java
│   ├── credits/                 # Credits module
│   │   └── ui/
│   │       └── CreditsUI.java
│   └── commons/                 # Shared utilities
│       ├── UIPositionUtil.java
│       ├── NavigationUtil. java
│       ├── RoundButton.java
│       └── GradientButton.java
│
├── build/                        # Compiled classes
├── dist/                         # Distribution JAR
├── nbproject/                    # NetBeans project files
├── docs/                         # Documentation
│   ├── screenshots/             # Application screenshots
│   └── user-manual/             # User manuals
│
└── README.md                     # This file
```


### Coding Standards
- Follow Java naming conventions
- Add comments for complex logic
- Maintain consistent indentation (4 spaces)
- Test thoroughly before submitting

## 👨‍💻 Credits

### Development Team
**Project Lead & Developer:** Wincel Crusit
**UI Designer & Developer:** Joko Comia
**Developer:** Patrick Fernandez
**Developer:** Raymund Hernandez
**Developer:** Adriel Naval


### Instructor
**CSST 101 Professor:** Norris Alexis Amora

### Acknowledgments
- Built as part of [CSST 101 - ADREP]
- Special thanks to all contributors and testers


## 📞 Contact

**Joko Comia**
- GitHub: [@Joko2005](https://github.com/Joko2005)
- Repository: [L.E.A. R.N.  System](https://github.com/Joko2005/L.E.A.R.N.-An-Interactive-Java-Based-Learning-System)

## 🔄 Version History

- **v1.0.0** (2026-01-03)
  - Initial release
  - Dashboard module with role-based access
  - Quiz module implementation
  - Chatbot module (Hetty)
  - Data visualization charts
  - Credits system
  - Login authentication

## 🐛 Known Issues

- None reported at this time

## 📝 Future Enhancements

- [ ] Database integration for user management
- [ ] Additional quiz categories
- [ ] Enhanced chatbot with AI capabilities
- [ ] More visualization chart types
- [ ] User profile customization
- [ ] Progress tracking and analytics
- [ ] Mobile responsive version
- [ ] Multi-language support

---

**Made with ❤️ using Java**

*Learn something new today with L.E.A.R.N.*
```
