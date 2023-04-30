# Container Shipment Application 📦✈️ * _______* ✈️📦

# Database

Postgres database is used for storing data in this application.

## Building application

# Backend

Please run `mvn clean install` to build the application.

# Frontend

Please run `npm install --force` to install the dependencies.

<i>**Note:**</i> the `--force` option is only when the previous command fails. 

If it still fails, please delete the file `package-lock.json` under `frontend` folder and run the command again.

## Running application

# Backend

Backend is integrated with docker-compose

Please run `docker-compose up --build -d` to run the application.

To check the progress of the backend logs, please run `docker logs backend -f`

`Ctrl + C` to stop the logs.

## Accessing application

You can access the Backend API endpoints using swagger:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

# Frontend

Under the `frontend` folder, please run `npm start` to run the application.

You can access the frontend application using the following URL:

[http://localhost:4200](http://localhost:4200)

## Stopping application

# Backend

Under the root directory, please run `docker-compose down` to stop the application.

# Frontend

Under the `frontend` folder, please run `npm stop` or `Cntrl +C` (if the frontend is still running)
to stop the application.

