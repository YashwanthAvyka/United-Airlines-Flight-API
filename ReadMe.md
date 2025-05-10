## United Airlines Flight API:
A Spring Boot REST API for managing United Airlines flight data.
- United Airlines MiniProject - Java 17 + Spring Boot 3
- Functionality: CRUD REST API for managing flights
- Includes: Dockerfile, Kubernetes manifests, and unit tests

## Features
- CRUD operations for flights
- Java 17 + Spring Boot 3.2.x
- Docker + Kubernetes ready
- H2 for dev, configurable for MySQL/PostgreSQL
- Unit tests using Spring MockMvc

## Run Locally
- ./mvnw spring-boot:run

## Build Docker Image
- docker build -t united-airlines .

## Deploy to Kubernetes
- kubectl apply -f k8s/deployment.yaml
- kubectl apply -f k8s/service.yaml
- kubectl apply -f k8s/prod-values.yaml

## API Endpoints:
- GET /api/flights
- GET /api/flights/{id}
- POST /api/flights
- PUT /api/flights/{id}
- DELETE /api/flights/{id}

# 🛫 United Airlines Flight Management API

A Spring Boot-based CRUD REST API for managing United Airlines flight details. This project demonstrates industry-standard best practices with Docker and Kubernetes support.

---

## 📦 Sample Flight Object

```json
{
  "id": 1,
  "flightNumber": "UA123",
  "origin": "SFO",
  "destination": "LAX",
  "departureTime": "2025-05-15T10:00:00",
  "arrivalTime": "2025-05-15T11:30:00"
}
```
## 📥 Create Flight
### Endpoint: POST /api/flights

🔸 Request Body
```
{
  "flightNumber": "UA123",
  "origin": "SFO",
  "destination": "LAX",
  "departureTime": "2025-05-15T10:00:00",
  "arrivalTime": "2025-05-15T11:30:00"
}
```
🔸 Response: 200 OK
```
{
  "id": 1,
  "flightNumber": "UA123",
  "origin": "SFO",
  "destination": "LAX",
  "departureTime": "2025-05-15T10:00:00",
  "arrivalTime": "2025-05-15T11:30:00"
}
```
## 📤 Get All Flights
### Endpoint: GET /api/flights

🔸 Response: 200 OK
```
[
  {
    "id": 1,
    "flightNumber": "UA123",
    "origin": "SFO",
    "destination": "LAX",
    "departureTime": "2025-05-15T10:00:00",
    "arrivalTime": "2025-05-15T11:30:00"
  }
]
```
## 🔍 Get Flight by ID
### Endpoint: GET /api/flights/{id}
#### Example: GET /api/flights/1

🔸 Response: 200 OK
```
{
  "id": 1,
  "flightNumber": "UA123",
  "origin": "SFO",
  "destination": "LAX",
  "departureTime": "2025-05-15T10:00:00",
  "arrivalTime": "2025-05-15T11:30:00"
}
```
🔸 If Not Found: 404 Not Found
```
{}
```
## ✏️ Update Flight
### Endpoint: PUT /api/flights/{id}
#### Example: PUT /api/flights/1

🔸 Request Body
```
{
  "flightNumber": "UA124",
  "origin": "SFO",
  "destination": "NYC",
  "departureTime": "2025-05-15T09:00:00",
  "arrivalTime": "2025-05-15T17:30:00"
}
```
🔸 Response: 200 OK
```
{
  "id": 1,
  "flightNumber": "UA124",
  "origin": "SFO",
  "destination": "NYC",
  "departureTime": "2025-05-15T09:00:00",
  "arrivalTime": "2025-05-15T17:30:00"
}
```
## ❌ Delete Flight
### Endpoint: DELETE /api/flights/{id}
#### Example: DELETE /api/flights/1

🔸 Response: 204 No Content

```No response body returned.```

## ✅ Status Codes:

- 200 OK – Success
- 201 Created – Resource Created
- 204 No Content – Resource Deleted
- 400 Bad Request – Validation or Input Error
- 404 Not Found – Resource Not Found
- 500 Internal Server Error – Unexpected Error

## Steps to Build, Run, and Test the Docker Container from your Local System.

### 1. Build the Docker Image 
- In the root directory of your project (where the Dockerfile is located), run the following command to build the Docker image:
```docker build -t united-airlines-api .```
- -t united-airlines-api: This tags the Docker image as united-airlines-api.
- .: The dot represents the current directory, which contains the Dockerfile.

### 2. Run the Docker Container 
- Once the image is built successfully, you can run the Docker container with the following command:
```docker run -d -p 8080:8080 --name united-airlines-api-container united-airlines-api```
- -d: Runs the container in detached mode (in the background).
- -p 8080:8080: Maps port 8080 of your local machine to port 8080 in the container.
- --name united-airlines-api-container: Names the container for easier management.
- united-airlines-api: Specifies the image name that was built in the previous step.

### 3. Check the Running Container 
- Verify that the container is running by using the command:
```docker ps```
- This will show all running containers and their associated ports. You should see your united-airlines-api-container listed, with 8080 mapped.

### 4. Test the API 
- Now, you can test the API locally using Postman, curl, or a web browser.
- Using curl (for example to test GET /api/flights): ```curl http://localhost:8080/api/flights```
- If the server is running correctly, you should get a response from your API, such as a list of flights.