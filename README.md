# T2G Golf Score Tracker
Basic HATEOAS-driven REST service for tracking golf scores. Built using [Spring Boot](https://github.com/spring-projects/spring-boot) and [Spring JPA](https://github.com/spring-projects/spring-data-jpa) the model with a flat model.

## Model
* `Golfer` has zero or more `Score`s
* `Course` has one or more `Tee`s
* `Tee`s have a _slope_, _rating_ and 18 `Hole`s
* `Score` has a `Golfer`, `Tee`, a _teeTime_ (`java.util.Date`) and 18 `HoleScore` beans
* 'HoleScore' is a POJO with the fields below
* `Score` has an _id_ pk and a uniqe composite key made from _teeId_, _teeTime_, and _golferId_
* `Scorecard` is a collection of all `Score`s with matching _teeId_ and _teeTime_
  
![T2G model](model.png)

## `HoleScore` tracks the following stuffs for each hole:
* Strokes (int)
* Fairway Hit (boolean)
* Drive Distance (int)
* GIR (boolean)
* Putts (int)
* Penalties (int)
* Sand Save (boolean)
* Mulligans (int)

## Swagger API Docs
http://localhost:8080/swagger-ui/index.html

### Build and Run Locally
> `mvn spring-boot run`

### Post a Score 
> `curl -X POST --data @./sample_json/score.json -H 'Content-Type: application/json' localhost:8080/scores`

### Update a Score (PUT)
> `curl -X PUT --data @./sample_json/score.json -H 'Content-Type: application/json' localhost:8080/scores`

### Get a Score
Two methods
> `curl -X GET localhost:8080/scores/{teeId}/{teeTime}/{golferId}`

> `curl -X GET localhost:8080/scores?id={id}`

### Get a Scorecard
> `curl -X GET localhost:8080/scorecards/{id}`

### Get all Scores for a Golfer
> `curl -X GET localhost:8080/scores?golfer={golferId}`

### Get a Course
> `curl -X GET localhost:8080/courses/{courseId}`

### TODO + WIP
* Build course repository (@see [FreeGolf Tracker](https://freegolftracker.com/courses/findgolfcourses.php))
* UI with dashboard
* Dockerize
* Index/HDCP calculation
* PG stuffs
* Security stuffs

