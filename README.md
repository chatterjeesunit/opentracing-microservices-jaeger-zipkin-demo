# Jaeger Microservice Demo
A demo application with jaeger tracing


## Running the application
##### Pre-requisite
 - Docker
 - Java 11
 - Gradle
 
##### First Time Setup
Do this if you are starting the application for first time
    
   `rm -rf ~/data/jaeger-pgres-13`
    
   `mkdir -p ~/data/jaeger-pgres-13`
   
##### Run the application
 
 - Build
    
    `./gradlew clean build --console=plain`
    
 - Run
 
    `docker-compose up --build`
    
   
## Data Creation
Connect to PostGres (username: `pgadmin`, password: `pgadmin#123`), and run the sql scripts in `resources` folder to create the dummy data for this application.
    - `Customer-DummyData.sql`  - Run on `customerdb`
    - `Orders-DummyData.sql`    - Run on `orderdb`
    - `Products-DummyData.sql`  - Run on `productdb`


## PostGres Admin
To connect to postgres from your host machine, you can install `pgAdmin`

`docker run --name postgres-admin -p 5000:80 -e "PGADMIN_DEFAULT_EMAIL=admin@dba.com" -e "PGADMIN_DEFAULT_PASSWORD=admin" -d dpage/pgadmin4`

Connect to pgAdmin at http://localhost:5000, and login using the admin credentials provided in docker run command.




## REST END POINTS

### Config service
 - Encrypt properties 
 
    `curl http://localhost:9000/encrypt -d dummyPropValue`
    
 - Get Config for Customer Service
 
    `curl http://localhost:9000/product-service/default`
 
