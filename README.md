Here’s a clean **README.md** code block you can copy directly into your project:

```markdown
# Hibernate Learning Project

A simple Java project to practice **Hibernate ORM** with MySQL.  
This project demonstrates Hibernate configuration, entity mapping, relationships, and CRUD operations.

---

## 📌 Features
- Hibernate configuration via `hibernate.properties`
- Entities:
  - `Student` (with fields like name, college, email, etc.)
  - `Certicate` (linked to Student via `@ManyToOne`)
- Bidirectional relationship: One Student → Many Certificates
- CRUD operations (save, update, delete, find)
- Queries using:
  - HQL (Hibernate Query Language)
  - Criteria API
- Pagination support

---

## ⚙️ Requirements
- Java 17+ (or compatible version)
- Maven (or Gradle)
- MySQL 8.x
- Hibernate ORM (latest stable version)
- MySQL Connector/J driver

---

## 🚀 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/sunnysingh3972/learninghiberante.git
   cd learninghiberante
   ```

2. **Configure database connection**  
   Edit `src/main/resources/hibernate.properties`:
   ```properties
   hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
   hibernate.connection.url=jdbc:mysql://localhost:3306/hibernateLearning
   hibernate.connection.username=root
   hibernate.connection.password=your_password
   hibernate.dialect=org.hibernate.dialect.MySQLDialect
   hibernate.hbm2ddl.auto=update
   hibernate.show_sql=true
   hibernate.format_sql=true
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   java -cp target/learninghiberante-1.0-SNAPSHOT.jar com.hibernatelearning.Main
   ```

---

## 🗂️ Project Structure
```
src/main/java/com/hibernatelearning/
 ├── Entity/
 │    ├── Student.java
 │    └── Certicate.java
 ├── Services/
 │    └── StudentServices.java
 ├── Util/
 │    └── HibernateUtil.java
 └── Main.java
src/main/resources/
 └── hibernate.properties
```

---

## 📖 Learning Goals
- Understand Hibernate configuration
- Map Java classes to database tables
- Implement relationships (`@OneToMany`, `@ManyToOne`)
- Perform CRUD operations
- Use HQL and Criteria API
- Implement pagination

---

## ⚠️ Notes
- Do not commit sensitive files (like `hibernate.properties` with DB credentials).  
  Add them to `.gitignore`:
  ```gitignore
  src/main/resources/hibernate.properties
  ```
- Use environment variables or external config for production.

---

## 🧪 Example Usage
```java
StudentServices service = new StudentServices();

// Save a student
Student s = new Student();
s.setName("Sunny");
s.setCollege("ABC College");
service.saveStudent(s);

// Fetch by ID
Student fetched = service.getStudentById(1);
System.out.println(fetched);

// Update student
fetched.setCollege("XYZ University");
service.updateStudent(fetched.getStudentId(), fetched);

// Delete student
service.deleteStudent(1);
```

---

👨‍💻 Built for learning Hibernate ORM step by step.
```
