# Where To Eat API - Spring Boot
This document introduces the specifications for the API of Where To Eat, an API made for an application that helps users search for restaurants.
The API has been developed using Spring Boot. It consumes data from a database built in Azure SQL Edge. Both have been containerized using Docker Compose and deployed to Azure using Github Actions.

## Technologies used
- Spring Boot
- Azure SQL Edge
- Docker and Docker Compose

## Useful Links
- Repository: https://github.com/lara-ferrer/where-to-eat-api
- Images:
    - API: https://hub.docker.com/repository/docker/laraferrer/wheretoeat-api
    - BBDD: https://hub.docker.com/repository/docker/laraferrer/wheretoeat-bbdd

- API - production env (deployed to Azure): https://wheretoeat-api.azurewebsites.net/swagger-ui.html
- API - staging env (deployed to Azure): https://wheretoeat-api-pre.azurewebsites.net/swagger-ui.html
- BBDD address (deployed to Azure): 20.31.208.57