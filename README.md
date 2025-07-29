# tracker-backend
Backend repository for Accountability Tracker. Using Springboot.
to run the project from the terminal ??
## Setup
JDK17 is required! Gradle should be able to build once the project is cloned and run as long as the project is set up with JDK17.
### Local database setup
In order to run locally, the database `accountability_tracker` must be created. In terminal: 
``` SQL
psql -U postgres
CREATE DATABASE accountability_tracker;
```

Once this database is created, run the project. It should remain up and running and be accessible at `http://localhost:8080`.
