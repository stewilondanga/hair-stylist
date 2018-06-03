# Hair-stylist
An app for a hair salon where the owner is able to add a list of the stylists, and for each stylist, 
add clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist.

Created by Stewart ilondanga

stilondanga@gmail.com

copyright 2018

## Description

This application let hair salons create hairstylists's agenda (database) as it stores each client a specific hairstylist has.
One hairstylist can have several clients, but a client will only have a hairstylist (as we are still dealing with 
"one to many" relationship).

application homepage https://agile-ravine-16392.herokuapp.com/

## Setup installation requirements

- CREATE DATABASE hair_salon;
- CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
- CREATE TABLE clients (id serial PRIMARY KEY, name varchar, int stylist_id);
- Create application functionalities (back-end);
- Run all back-end tests;
- Implement User Interface (front-end);
- Run all front-end tests;

## Known bugs

None;

## Technologies used

- Java
- Spark
- Gradle
- Velocity
- Bootstrap
- Heroku
- Psl

## License
Application can be used under MIT licenses.
