# iban-app
Microservices 



Any microservice must be able to locate the different instances of another service on which it depends without having their addresses defined in the code.

The programs used will be these:


* **Project**: subscription-service **Port:**: 8200

* **Project**: pub-service **Port:**: 8100

* **Project**: email-service **Port:**: 8001

* **Project**: eureka-service **Port:**: 8761


# Start the services in next order:

-eureka-server
-subscription-service
-pub-service
-email-service


# 1 - Start the eureka-service:


The first thing we need is to have a place where all microservices register when they are initialized. This service is the one that will be consulted when we want to locate the different instances. In this example we will use ** Eureka Server ** which is very easy to create.

 - After run it, please check in:

 http://localhost:8761/


 # 2 - Start the subscription service

 This service have the following endpoints:

 - get all subscriptions
 - create a new subscription

 In the path src/main/resources we have:

 - shema.sql
 - application.properties
 - subscription api, from postman

The database used, is H2 (memory database, that is good only for tests)
You need had this configuration to access database in your favorite browser:

H2 database configuration 

spring.datasource.url=jdbc:h2:mem:test
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


When you start this service (execute jar or in your IDE), you can see the database in following url:

-http://localhost:8001/h2

This service will be consulted by the pub-service, that is the public service.

Another point, this service to send information to email-service is necessary to download the activeMQ and install it in your machine.

the communication bettween subscription service and email service i used the JMS ActiveMQ.

https://activemq.apache.org/

After it, you can see it activeMQ is running in your machine or not in following url:

http://localhost:8161/admin

More information aboutActiveMQ in: 

https://activemq.apache.org/web-console

The reason to use the activeMQ is because:

"Decoupled : The systems are able to communicate without being connected. Queue lies between systems, one system failure will never affect other as communication is done through Queue. The systems continue to work when they are up.

Recovery support : The messages in Queues itself persisted. The messages can be restored later if Queue fails.

Reliable Communication : Consider a system that process client requests. In normal cases the system receives 100 requests per minute. This system is unreliable when number of request goes beyond average. In such case Queue can manage requests and it can push messages periodically based on system throughput without breaking it.

Asynchronous : Client server communication is non-blocking. Once client sent request to server it can do other operations without waiting for response. When response it received client can handle it anytime."


# 3 - Start the public service

This public service must be configured with a IP public, so in this case is very important have autenthication 

We can use, authentication with token (spring security),but i don´t had time to development it.

The goal of this public service, is consume all endpoints from the subscription service.

Endpoints:

GET http://localhost:8100/api/v1/subscriptions

POST http://localhost:8100/api/v1/subscriptions


BODY example:

{
        "firstName": "ana",
        "gender": "feminino",
        "dateOfBirth": "2006-10-10",
        "consent": "true",
        "emailId": "teste@gmail.com"
}




# 4 - Start email service:

The service is responsable to receive an email from subscription service and sent the information that was created a new subscription to the user mail.

So in application.properties file we have the following properties:

#spring-boot-starter-mail properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=email
spring.mail.password=pass
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.enable=false
spring.mail.test-connection=true

you must put the credencials about the aplication email provider :
something like this:

spring.mail.username=iban@gmail.com
spring.mail.password=iban

In this case the configuration is for gmail provider.



# DOCKER

I development this application in windows, so in this case, to use DOCKER i need a virtualized server, like virtualBox.
But the ideal is using a linux machine.

Steps to configure docker in this application:

# 1 - Install a virtualized server and install the docker.


# 2 -For Each project pom.xml file must have the a similar plugin like this:

 <plugins>
    ...
    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>dockerfile-maven-plugin</artifactId>
        <version>1.4.9</version>
        <executions>
            <execution>
                <id>default</id>
                <goals>
                    <goal>build</goal>
                    <goal>push</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <repository>subscriptions.com/microservice-docker-${project.artifactId}</repository>
            <tag>${project.version}</tag>
            <buildArgs>
                <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
            </buildArgs>
        </configuration>
    </plugin>
</plugins>


This XML configures the Dockerfile Maven plugin to build a Docker image every time you run ./mvnw install. Each image will be created with the name subscriptions.com/microservice-docker-${project.artifactId} where project.artifactId varies by project.


# 3 - Create one Docker image for each project. 

Each image should have the same Maven configuration and Dockerfile content in the root folder of each project. 
So for each project i must have a docker file. 
Basically, a Dockerfile is a simple text file with all the instructions required to build the docker image.

-eureka-server
	Dockerfile 
-subscription-service
    Dockerfile
-pub-service
    Dockerfile
-email-service
    Dockerfile

Inside each DockerFile i must put this instruttions:

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]



# 4 - Open the terminal and start the docker
systemctl start docker

# 5 - To each project, we must build a docker image. So for example to pub-service.
Open the terminal and go to the pub-service project:

docker image build -t pub-service.

This command will create a image docker to pub service, we must do this example for all remaining projects.
Each project must have an docker image.

# 6 - Now, i will create file called docker-compose.yml, which will use all these Dockerfiles to spawn our required environments:
Something like docker_compose.yml file that exists in repository project.

# 7 - After creating the file, we can build:  

 docker-compose up --build 

# 8 - To stop the complete environment, we can use this command:

 docker-compose down 















