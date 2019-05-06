# AirWatch

## Problem Statement

Build a system to keep track of Air Quality.

## Requirements:
1. The application needs to fetch existing states from `https://www.airvisual.com/air-pollution-data-api`
2. A frontend where the user can **View and create WatchList of Cities.** 

## Modules:
1. AccountManager - Should be able to manage user accounts
2. **AirWatchUI** -
  - User should be able to
    1. Needs to show all the countries which AirVisual Supports. On clicking the **Country** it should display all the **States** present in the country.
    2. On clicking the **State** the interface needs to show the AirQuality of all the **Cities of that particular state.**
3. The AirWatcher - Application should be able to maintain watchlist of cities.

## Tech Stack
- Spring Boot 
- Angular
- CI (Gitlab Runner)
- Docker, Docker Compose

## Flow of Modules

All these durations are only approximations

- ** Building Frontend**:
  1. Building **Responsive** Views:
    1. Build a View to show all 
      1. Countries - Populating from external api
      2. States - Populating from external api
      3. Build a view to show cities added under watchlist
      4. A view to authenticate users
  2. Using **Services** to populate these data in views
  3. Stitching these views using **Routes and Guards**
  4. Unit Testing for Components
  5. E2E only for few views
  6. **Writing CI configuration file**
  7.  **Dockerizing the frontend**

- ** Building the Account Manager **
  1. Creating a server in Java to 
    1. **facilitate registration** and login using **JWT token** and **MySQL**
    2. **facilitate CRUD operation** over **AirWatchList** resources stored in MySQL
  2. Writing Swagger Documentation
  3. Unit Testing
  4. **Write CI Configuration**
  5. **Dockerize the application**

- ** Building the Airwatcher Application **
  1. Creating a server in Java to
    1. Application should be able to maintain watchlist of cities
  2. Writing Swagger Documentaion
  3. Unit Testing
  4. **Write CI Configuration**
  5. **Dockerize the application**
  
- ** Write docker-compose file to build both frontend and backend application **
- Demonstrate the entire application
