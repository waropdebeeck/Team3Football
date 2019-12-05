## Table of content

* [Over Team3Football](#Over-Team3Football)
* [Inhoud](#Inhoud)
* [Beschrijving repository](#Beschrijving-repository)
* [Front-end](#Front-end)
* [Back-end](#Back-end)
* [Team Team3Football](#Teamleden)
* [Screenshots Swagger](#Screenshots-Swagger)
* [Known Issues](#Known-Issues)

## Over Team3Football

Team3Football is een voetbal applicatie waarmee je jouw droomteam kan opstellen.
Het is een applicatie ontwikkeld in spring en angular.

## Inhoud

* 3 microservices met:
  * één mongoDB service
  * twee postgreSQL services
* Eureka server
* Edge service met GET, POST, PUT, DELETE endpoints
* Edge service gedocumenteerd met SwaggerUI
* Zuul gateway
* Front end in Angular 

  
## Beschrijving microservices
Deel het applicatie op in micro(deel) applicaties = micoservices

## Beschrijving repository

Deze repository bevat 3 microservices, Edge service, Eureka service, een zuul gateway en het Angular project.


### Players service

Deze microservice om voetbalspelers op te slagen in het database.

### Team service

Deze microservice gebruiken om voetbalteams op te slagen in het database.

### Lineup service

Deze microservice gebruiken om een elftal op te slagen in het database.


### Edge service

Deze service is een tussenlaag met de front end en Eureka service.

### Eureka service

Eureka service is ook een Spring Boot app
Deze service laat de REST-communicatie een dynamische URL gebruiken = discovery service
Laad REST-oproepen tussen services
Alle interne calls gaan er doorheen

### Team3Football angular project

In het Team3Football folder zit het frond end gedeelte.

### Zuul gateway

Zuul gateway is een Spring Boot applicatie die de REST-communicatie dynamische url laat gebruiken.
De zuul gateway blokeert gevoelige informatie tussen de andere diensten. De zuul gateway gebruikt
authenticatiefilters.

### Front-end

* Angular 8 

### Back-end
* Microservices met spring (Java)


## Teamleden

* Melih Doksanbir
* War Op De Beeck
* Ruben Horemans

## Screenshots Swagger

URLS
## Known Issues


*Wij maken gebruik van elephantsql en gebruiker hierbij het tinyturtle plan.
Het probeleem Hierbij is dat een service meerdere connecties aanmaakt en dit 
zorgt ervoor dat we geen queries meer kunnen uitvoeren.
*Midas van Herck is uit het team (en dit te laat laten weten) gestapt waardoor onze workload omhoog is gegaan.

