# Car Rental Management System - Spring Boot Backend

## Project Description
A RESTful Web Service application built with Spring Boot using a clean 3-layer architecture (Controller, Service, Repository). The system manages a car rental domain utilizing three core related resources (**Car**, **Customer**, and **Rental**) with preloaded sample data in an in-memory H2 database.

---

## How to Run Locally

1. **Open the Project:**
   * Open the project folder in **IntelliJ IDEA**.
2. **Run the Application:**
   * Locate the main application class (e.g., `CarRentalApplication.java`).
   * Click the green **Run** button in IntelliJ.
3. **Access H2 Database Console:**
   * Open your browser and go to: `http://localhost:8080/h2-console`
   * JDBC URL: `jdbc:h2:mem:testdb`
   * User name: `sa`
   * Password: *(leave blank)*

---

## API Endpoints Table

| Resource | Method | Endpoint | Description |
| :--- | :--- | :--- | :--- |
| **Cars** | GET | `/api/cars` | Retrieve all cars |
| | GET | `/api/cars/{id}` | Retrieve a car by ID |
| | POST | `/api/cars` | Create a new car |
| | PUT | `/api/cars/{id}` | Update an existing car |
| | DELETE | `/api/cars/{id}` | Delete a car |
| **Customers** | GET | `/api/customers` | Retrieve all customers |
| | GET | `/api/customers/{id}` | Retrieve a customer by ID |
| | POST | `/api/customers` | Create a new customer |
| | PUT | `/api/customers/{id}` | Update a customer |
| | DELETE | `/api/customers/{id}` | Delete a customer |
| **Rentals** | GET | `/api/rentals` | Retrieve all rentals |
| | GET | `/api/rentals/{id}` | Retrieve a rental by ID |
| | POST | `/api/rentals` | Create a new rental |
| | DELETE | `/api/rentals/{id}` | Delete/cancel a rental |
| **Relationships**| GET | `/api/customers/{id}/rentals`| Get all rentals associated with a specific customer |

---

## Sample Requests

### 1. Create a New Car (POST)
* **Endpoint:** `POST /api/cars`
* **Body (JSON):**
  ```json
  {
    "brand": "Toyota",
    "model": "Corolla",
    "year": 2023,
    "dailyRate": 45.00
  }
2. Get Customer Rentals (Aggregated Endpoint)
Endpoint: GET /api/customers/1/rentals

Response: Returns the customer details along with a list of their active and past rentals.

API Testing (cURL Examples)
Get All Cars
Bash
curl -X GET http://localhost:8080/api/cars
Create a Car
Bash
curl -X POST http://localhost:8080/api/cars \
  -H "Content-Type: application/json" \
  -d '{"brand":"Toyota","model":"Corolla","year":2023,"dailyRate":45.00}'
Credentials
No authentication credentials are required for local H2 database or API testing.
