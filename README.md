# Blood Donor App Backend 🩸🚑

 This Spring Boot project serves as the backend for a blood donation management system. It provides RESTful APIs to manage donor registrations, blood donation requests, and other related functionalities.

## Features ✨

- **Donor Registration & Management**:  
  Allows donors to register and update their profiles.

- **Blood Donation Requests**:  
  Manage requests for blood donations and match them with available donors.

- **Secure API Endpoints**:  
  Implements security measures to ensure data privacy and integrity.

- **Database Integration**:  
  Uses JPA/Hibernate for database interactions, making data management seamless.

## Technology Stack 🛠️

- **Spring Boot**  
- **Spring Data JPA**  
- **Spring Security**  
- **PostgreSQL (or your preferred RDBMS)**  
- **Maven**  
- **Java 11+**

## Installation & Setup 🛠️

1. **Clone the Repository**:  
   Open your terminal and run:  
   ```bash
   git clone https://github.com/JohnSkouloudis/BloodDonorApp-Backend.git
2. **Navigate to the Project Directory**:
   - Open your terminal and enter:
     ```bash
       cd BloodDonorApp-Backend
3. **Configure the Application**:
   - Open the `application.properties` file (located in `src/main/resources`) and update the database configuration, port settings, and any other necessary configurations.
4. **Build the Project:**:
    - Run the following command to build the project using Maven:   
      ```bash
       mvn clean install
## Start Spring

```sh
mvn spring-boot:run
```

## Start postgres db as container
```sh
docker run --name BloodDonor-Database --rm \
-e POSTGRES_PASSWORD=pass123 \
-e POSTGRES_USER=dbuser \
-e POSTGRES_DB=BloodDonors \
-d --net=host \
-v ds-lab-vol:/var/lib/postgresql/data \
postgres:14
```
## Dockerize
```sh
./mvnw package -Dmaven.test.skip
```
## Start Compose
```sh
docker-compose up
```
