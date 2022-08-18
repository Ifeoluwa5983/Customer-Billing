**Customer Billing**

This is a simple implementation of a billing/funding system

This project is made of 6 separate Docker containers that holds:

PostgreSQL database
Customer-Service
Billing-Service
Billing-Worker-Service
Rabbitmq
pqadmin(Postgres gui)


Prerequisites
In order to run this application you need to install two tools: Docker & Docker Compose.

How to run it?

First build up the application running this command

$ docker-compose build --no-cache

The entire application can be ran with a single command in a terminal:

$ docker-compose up -d
If you want to stop it use following command:

$ docker-compose down

customers (Customer-Service-Database)
billing (Billing-Service-Database)
customers database contains 1 schema with 1 table - customer table.
billing database contains 1 schema with 2 tables - wallet and billing-transaction table.

After running the app it can be accessible using this connectors:

Host: localhost
Database: {database-name}
User: customer-billing
Password: password123
Like other parts of application Postgres database is containerized and the definition of its Docker container can be found in docker-compose.yml file.


This is a Spring Boot (Java) based application that connects with a database that and expose the REST endpoints that can be consumed by frontend. It supports multiple HTTP POST method for one resource - customer, which communicates internally with the billing service and the billing-worker-service.

Full list of available REST endpoints could be found in Postman Documentation, which could be called using link: https://documenter.getpostman.com/view/12585925/VUqoPHq8
