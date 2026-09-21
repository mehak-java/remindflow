# RemindFlow
A backend **Reminder Management REST API** built using Java and Spring Boot.

## 🚀 Features
* Create, view, update and delete reminders
* Mark reminders as completed
* Filter by priority
* Filter by completion status
* Request validation
* Centralized exception handling
* DTO-based API responses
* MySQL database integration
* Automatic created/updated timestamps

## 🛠️ Tech Stack
* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL 8
* Maven
* Jakarta Validation
* Git & GitHub

## 📁 Project Structure

```text
src/main/java/com/mehak/remindflow
├── controller
├── dto
├── entity
├── exception
├── repository
└── service
```

## 🔗 API Endpoints

| Method | Endpoint                       | Description        |
| ------ | ------------------------------ | ------------------ |
| POST   | `/api/reminders`               | Create reminder    |
| GET    | `/api/reminders`               | Get all reminders  |
| GET    | `/api/reminders/{id}`          | Get reminder by ID |
| PUT    | `/api/reminders/{id}`          | Update reminder    |
| PATCH  | `/api/reminders/{id}/complete` | Complete reminder  |
| DELETE | `/api/reminders/{id}`          | Delete reminder    |

### Filtering

```text
GET /api/reminders?priority=HIGH
GET /api/reminders?completed=false
```

## 📝 Example Request

```json
{
  "title": "Submit project report",
  "description": "Complete and submit the project report",
  "dueDateTime": "2026-08-25T18:00:00",
  "priority": "HIGH"
}
```

## 🗄️ Database

MySQL database:

```text
remindflow
```

Reminder fields include:

`id`, `title`, `description`, `dueDateTime`, `priority`, `completed`, `createdAt`, `updatedAt`

## ⚙️ Configuration

Create `application-local.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/remindflow
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

Keep this file out of GitHub because it contains database credentials.

## ▶️ Run Locally

Clone the repository:

```bash
git clone https://github.com/mehak-java/remindflow.git
```

Create the database:

```sql
CREATE DATABASE remindflow;
```

Run the application on Windows:

```bash
mvnw.cmd spring-boot:run
```

API base URL:

```text
http://localhost:8080/api/reminders
```

## 🧪 Testing

The API can be tested using Postman, IntelliJ HTTP Client, or cURL.

## 🔮 Future Improvements

* Swagger / OpenAPI
* JUnit & Mockito tests
* Pagination and sorting
* Spring Security & JWT
* Docker
* Frontend integration
* Cloud deployment

## 👩‍💻 Author

**Mehak Saini**

Java / Spring Boot Developer
