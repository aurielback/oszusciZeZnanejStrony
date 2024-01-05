main/src/main/java/com/example/roomsandapartments -> main code
1. config -> beans, configuration classes (security etc)
2. controller -> last place before frontend (GUI interface). This is the place where request and responses gona be send and retrieve.
3. DTO -> transfer object. Mirroring of entities (objects in database)
4. enums -> constants values like city names, streets..somethink it's not depend from us
5. exceptions -> if somethink went wrong, like someone gonna use "238173918273981u231" as a city name, exception gonna be throw "Name of the city cannot be 382910312...bla bla"
6. mappers -> map entities to dto and vice versa
7. model -> entities. This is how tables looks like in database
8. repository / service -> entire logic of code
