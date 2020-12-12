# Open Tracing Microservice Demo (with Jaeger or Zipkin)
A sample microservices application with OpenTracing with Jaeger or Zipkin. To know more read the blog - https://sunitc.dev/2020/09/08/microservices-distributed-tracing-with-jaeger/

## Demo App Architecture
![Architecture](/resources/OpenTracingDemoApp.png)


## Jaeger Setup vs Zipkin Setup

#### To run Jaeger
Change following configurations in `docker-compose.yml`
  * Set `OPENTRACING_JAEGER_ENABLED: 'true'`, in environment variables for following services (`config-server`, `customer-service`, `product-service`, `order-service`, `bff-service`)
  * Set `--tracing.jaeger=true` and `--tracing.zipkin=false` in the `command` for the `load-balancer` service.
  * Access Jaeger UI on - http://localhost:16686/search
  <br>

#### To run Zipkin
Change following configurations in `docker-compose.yml`
  * Set `OPENTRACING_JAEGER_ENABLED: 'false'`, in environment variables for following services (`config-server`, `customer-service`, `product-service`, `order-service`, `bff-service`)
  * Set `--tracing.jaeger=false` and `--tracing.zipkin=true` in the `command` for the `load-balancer` service.
  * Acces Zipkin UI on - http://localhost:9411/zipkin/
<br>

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
 
    `docker-compose up -d --build`
    
   
## Data Creation
Connect to PostGres (username: `pgadmin`, password: `pgadmin#123`), and run the sql scripts in `resources/dummy-data-scripts` folder to create the dummy data for this application.

 * `Customer-DummyData.sql`  - Run on `customerdb`
 * `Orders-DummyData.sql`    - Run on `orderdb`
 * `Products-DummyData.sql`  - Run on `productdb`


## PostGres Admin
To connect to postgres from your host machine, you can install `pgAdmin`

`docker run --name postgres-admin -p 5000:80 -e "PGADMIN_DEFAULT_EMAIL=admin@dba.com" -e "PGADMIN_DEFAULT_PASSWORD=admin" -d dpage/pgadmin4`

Connect to pgAdmin at http://localhost:5000, and login using the admin credentials provided in docker run command.




## SAMPLE REST END POINTS

 * Get all customers
 ```http://localhost/api/v1/bff/customers?pageNum=0&pageSize=10```

 * Get All Orders for a customer 
  ```http://localhost/api/v1/bff/customer/5c0e7fe0-f062-11ea-9298-0242c0a88003/orders```
 
 * Encrypt properties for 
  ```curl http://localhost:<config-server-port>/encrypt -d dummyPropValue```
       
 * Get Config for Customer Service
  ```curl http://localhost:<config-server-port>/product-service/default```
