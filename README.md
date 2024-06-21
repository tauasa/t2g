# T2G Golf Score Tracker
Basic HATEOAS-driven REST service for tracking golf scores. Built with [Spring Boot](https://github.com/spring-projects/spring-boot) and [Spring JPA](https://github.com/spring-projects/spring-data-jpa).

### Model
![T2G model](model.png)

### Tracks the following data points for each hole:
* Strokes
* Fairways
* Drive Distance
* GIR
* Putts
* Penalties
* Sandies
* Mulligans
* Skins

### Build and Run Locally
> `mvn spring-boot run`

### Swagger API Docs
http://localhost:8080/swagger-ui/index.html

### Post a Scorecard
> `curl -X POST --data @./sample_json/scorecard.json -H 'Content-Type: application/json' localhost:8080/scorecards`

### Update a Scorecard
> `curl -X PUT --data @./sample_json/scorecard.json -H 'Content-Type: application/json' localhost:8080/scorecards`

### Get a Scorecard
> `curl -X GET -H 'Content-Type: application/json' localhost:8080/scorecards/{teeId}/{teeTime}/{golferId}`

### List Courses
> `curl -X GET -H 'Content-Type: application/json' localhost:8080/courses`

### TODO + WIP
* Build course repository (@see [FreeGolf Tracker](https://freegolftracker.com/courses/findgolfcourses.php))
* UI with dashboard
* Dockerize
* Index/HDCP calculation (multiple algos?)

