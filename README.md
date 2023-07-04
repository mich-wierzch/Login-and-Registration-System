Login and Registration System

Login and registration system implemented in Java using Swing for the GUI and PostgreSQL database for storing usernames and passwords. 
It allows users to create an account, login, and view a welcome page after successful login.

Technologies Used
- Java
- Swing (Java GUI toolkit)
- PostgreSQL (Relational database management system)
- Lombok (Boilerplate code reduction)
- Maven (Dependency management and project structure)

Installation
1. Clone the repository
git clone https://github.com/your-username/login-registration-system.git

2. Create a PostgreSQL database named "Users".

3. Import the project into your preferred Java IDE.

4. Set up the database connection details in the org.example.Database.dbConnectionDetails class.
private final String url = "jdbc:postgresql://localhost:5432/Users";\
 private final String user = "your-username";\
 private final String password = "your-password";

6. uild and run the project.
