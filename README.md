# ERP-Spring-Boot-Angular-Microservices

The project generally aims to achieve an effective distributed ERP system structure (Microservices –Based) to dynamically manage and integrate some of the organization’s operations in the General Administration, Financial Administration and Human Resource Management departments, to help them manage these businesses efficiently and flexibly in a way that allows for functional scalability and acceptance of changes in workflows, all that using modern technologies and software engineering concepts.

# System Architecture  : 
To achieve the main goal of the intended design, which is to separate the components of the system and achieve the principle of (Loose - Coupling) to increase the availability,scalability and fault-isolation. The presented structure raises several points:
•	Separating the different system components according to the functional or non-functional services they provide, each component is an isolated microserivce .
•	Each microserivce has its own database.
•	Defining REST APIs for different services, called from anywhere in the system, and configured appropriately.
•	Achieving an asynchronous communication structure between microservices through a message queue using the Event-driven Design Pattern. 

# Implementation: 
•	Back-end : spring boot 2.2.6 
•	Microservices : spring cloud Netflix (Zuul – cloud config – eureka – zipkin –activeMQ)
•	Dynamic workflows : camunda workflow engine .
•	Database : mysql 8.0
•	Front-end : Angular 

# Deployment: 
Docker (containerization)  : each microservice has its own docker image and all images are defined in a docker compose file to run it entairly.

