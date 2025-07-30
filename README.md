# tracker-backend
Backend API repository for Accountability Tracker. Using Spring Boot.
## Setup
JDK17 is required! Because a Gradle wrapper has been implemented, upon initial build JDK17 will be installed if not yet existing; no action needs to be taken.
### Local setup
App is now set up to use deployed database, regardless of whether you are using the deployed backend or hosting on local (localhost). /
It is not necessary to create the local database, but ensure that the `.env` file holds the correct variables!

```
DATABASE_URL=<desired_URL>
DATABASE_USERNAME=<username>
DATABASE_PASSWORD=<password>
```

Once this database is created, run the project. It should remain up and running and be accessible at `http://localhost:8080`.
# Notes
Because of how CORS is configured, to make requests to tracker-backend, you must be using either `http://localhost:5173` (VITE default port), or the deployed frontend at [ellenjin.github.io/tracker-frontend](https://ellenjin.github.io/tracker-frontend/).
