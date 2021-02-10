# projet7-Openclassrooms

Pour deployer l'application forkez puis telechargez ce repository

Effectuer un mvn package qui va generer le SNAPSHOT.jar executable de l'application 

Executer le SNAPSHOT.jar generé

Modifiez le fichier application.properties

```
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url = jdbc:postgresql://localhost:5432/P10_database
spring.datasource.username = postgres
spring.datasource.password = 123456
logging.file.name = logs

account=annalibraryoc@gmail.com
password=12345LibraryOC

ratp.api.url="https://api-ratp.pierre-grimaud.fr/v4"
climacell.api.url="https://api.climacell.co/v3/weather/forecast/hourly?"
google.matrix.api="https://maps.googleapis.com/maps/api/distancematrix/json?units=metric"
```
L'application utilise le serveur stmp gmail, vous pouvez modifier le compte d'accès. 

L'application utlise PostGreSQL comme serveur de base de données, les scripts sont présent dans le fichier nommée "SQL".

## Test

pour tester l'application, allez dans la racine de la couche back ou batch et effectuez un mvn test
