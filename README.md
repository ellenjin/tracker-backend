# Logger – Accountability Tracker (Backend)

Backend repository for **Logger**, a full-stack accountability tracker that helps users stay on track with personal or group goals — from workouts to cooking at home.  
This backend is built with **Java Spring Boot** and provides the API, database integration, and core business logic for the application.

## Table of Contents
- [Logger – Accountability Tracker (Backend)](#logger--accountability-tracker-backend)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [Tech Stack](#tech-stack)
  - [Team](#team)
  - [Backend Setup (`tracker-backend`)](#backend-setup-tracker-backend)
  - [Environment Variables](#environment-variables)
  - [Notes](#notes)

---

## Overview
Logger enables users to:
- Track activities individually or in groups.
- Get matched with accountability partners based on shared interests.
- Send and receive text notifications for check-ins.
- Keep logs of daily progress.

The backend handles authentication, database storage, group management, and SMS notifications.

---

## Tech Stack
**Backend:**
- Java 17
- Spring Boot
- Hibernate JPA
- PostgreSQL

**Other Tools:**
- Textbelt API (SMS notifications)
- Gradle
- Figma (design reference)

---

## Team
- **Solhee Jin**
- **Sno Ochoa**
- **Laura Castro**

---

## Backend Setup (`tracker-backend`)

1. **Clone the repository**:
   ```bash
   git clone <backend-repo-url>
   cd tracker-backend
   ```

2. **Ensure Java 17 is installed**.  
   A Gradle wrapper has been implemented, so on the initial build, JDK 17 will be installed automatically if not present.

3. **Create a `.env` file** in the backend root:
   ```
   DATABASE_URL=<desired_URL>
   DATABASE_USERNAME=<username>
   DATABASE_PASSWORD=<password>
   ```

4. **Run the backend server**:
   ```bash
   ./gradlew bootRun
   ```

5. The backend will be available at:
   ```
   http://localhost:8080
   ```

---

## Environment Variables
**Backend (`.env`):**
```
DATABASE_URL=<url>
DATABASE_USERNAME=<username>
DATABASE_PASSWORD=<password>
```

---

## Notes
- **CORS**: Requests to the tracker-backend must come from:
  - `http://localhost:5173` (default Vite port), or
  - The deployed frontend: [ellenjin.github.io/tracker-frontend](https://ellenjin.github.io/tracker-frontend/)
- The app is configured to use the deployed database by default — local DB setup is optional.




