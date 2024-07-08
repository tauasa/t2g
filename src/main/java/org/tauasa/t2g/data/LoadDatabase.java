package org.tauasa.t2g.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tauasa.t2g.model.Course;
import org.tauasa.t2g.model.Golfer;
import org.tauasa.t2g.model.Hole;
import org.tauasa.t2g.model.HoleScore;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.Scorecard;
import org.tauasa.t2g.model.Tee;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(CourseRepository courseRepository, GolferRepository golferRepository, ScoreRepository scoreRepository, ScorecardRepository scorecardRepository) {

		long courseCount = courseRepository.findAll().size();
		log.debug("Courses: {}", courseRepository.findAll().size());
		log.debug("Golfers: {}", golferRepository.findAll().size());
		log.debug("Scores: {}", scoreRepository.findAll().size());
		log.debug("Scorecards: {}", scorecardRepository.findAll().size());

		if(courseCount > 0){
			return args -> {
				log.info("Database initialized. Nuthin to do here");
			};
		}

		return args -> {

			// TODO - scrape score card data from https://freegolftracker.com/courses/Diamond-Oaks_4311.htm
			log.info("Initializting database...");

			log.info("Create/pre-load some courses");
			initCourses(courseRepository);
			List<Course> courses = courseRepository.findAll();

			scoreRepository.findAll().forEach(score -> log.info("+Preloaded " + score));
			courses.forEach(course_ -> log.info("+Preloaded: {}", course_));
			

			// tee time starts here
			LocalDateTime startDate = LocalDateTime.of(2024, 6, 21, 9, 15);
			//create some golfers
			initGolfers(golferRepository);
			int teeTimeCounter = 0;

			List<Golfer> golfers = golferRepository.findAll();

			//create scores for every golfer, tee for every course O(n^3)
			for(Course course : courses){
				for(Tee tee : course.getTees()){
					for(Golfer golfer : golfers){
						Score score = initScore(golfer, tee, startDate.plusDays(teeTimeCounter * -1), scoreRepository);
						golfer.add(score);
						golferRepository.save(golfer);
					}
					teeTimeCounter++;
				}
			}
			golfers.forEach(golfer -> log.info("+Preloaded: " + golfer));

			//add a score for a single golfer
			Golfer singleGolfer = golfers.get(0);
			Course singleCourse = courses.get(0);
			Tee firstTee = singleCourse.getTees().iterator().next();
			Score singleScore = initScore(singleGolfer, firstTee, startDate.plusDays(teeTimeCounter * -1), scoreRepository);
			singleGolfer.add(singleScore);
			golferRepository.save(singleGolfer);

			Scorecard singleCard = new Scorecard(LocalDateTime.now());
			singleCard.add(singleScore);
			scorecardRepository.save(singleCard);
			log.info("+Preloaded: {}", singleCard);

			// create some scorecards fix O(n^3)
			teeTimeCounter = 0;
			for(Course course : courses){
				for(Tee tee : course.getTees()){
					List<Score> scores = scoreRepository.findByTeeIdAndTeeTime(tee.getId(), startDate.plusDays(teeTimeCounter * -1));
					Scorecard card = new Scorecard();
					card.setTeeTime(scores.get(0).getTeeTime());// hokey
					for (Score score : scores) {
						card.add(score);
					}
					scorecardRepository.save(card);
					teeTimeCounter++;
				}
			}//*/
			scoreRepository.findAll().forEach(score -> log.info("+Preloaded " + score));
			scorecardRepository.findAll().forEach(scorecard -> log.info("+Preloaded " + scorecard));
			log.info("Database initialized");



			// create some courses
			if(courseRepository.count()==0 || golferRepository.count()==0){
				
			}
		};
		
	}

	private static int randInt(int min, int max){
		return new Random().nextInt(min, max);
	}

	private static float randFloat(float min, float max){
		return new Random().nextFloat(min, max);
	}

	private Score initScore(Golfer golfer, Tee tee, LocalDateTime teeTime, ScoreRepository scoreRepository){
		// create a scores for the specified golfer, course and the first tee
		Score score = new Score(golfer, tee, teeTime);

		score.setHoleScore1(createHoleScore(tee.getHole1(), 0, true, true, false));
		score.setHoleScore2(createHoleScore(tee.getHole2(), 0, true, false, false));
		score.setHoleScore3(createHoleScore(tee.getHole3(), 0, false, true, true));
		score.setHoleScore4(createHoleScore(tee.getHole4(), 0, true, true, false));
		score.setHoleScore5(createHoleScore(tee.getHole5(), 0, false, false, false));
		score.setHoleScore6(createHoleScore(tee.getHole6(), 0, true, true, false));
		score.setHoleScore7(createHoleScore(tee.getHole7(), 0, true, true, false));
		score.setHoleScore8(createHoleScore(tee.getHole8(), 0, false, true, false));
		score.setHoleScore9(createHoleScore(tee.getHole9(), 0, true, true, false));
		score.setHoleScore10(createHoleScore(tee.getHole10(), 0, true, true, false));
		score.setHoleScore11(createHoleScore(tee.getHole11(), 0, false, true, false));
		score.setHoleScore12(createHoleScore(tee.getHole12(), 0, false, false, false));
		score.setHoleScore13(createHoleScore(tee.getHole13(), 0, true, true, false));
		score.setHoleScore14(createHoleScore(tee.getHole14(), 0, true, true, false));
		score.setHoleScore15(createHoleScore(tee.getHole15(), 0, false, false, true));
		score.setHoleScore16(createHoleScore(tee.getHole16(), 0, true, true, false));
		score.setHoleScore17(createHoleScore(tee.getHole17(), 0, false, true, false));
		score.setHoleScore18(createHoleScore(tee.getHole18(), 0, true, true, false));

		return scoreRepository.save(score);
	}

	private HoleScore createHoleScore(Hole hole, int penalties, boolean fairway, boolean gir, boolean sandy){
		HoleScore hs = new HoleScore(
			hole.getPar() + randInt(-2, 4), //random score between birdie and snowman
			hole.getPar() > 3 ? randInt(200, hole.getDistance()-60) : 0, // random drive distance 
			randInt(0,5),
			penalties,
			0,
			fairway,
		 	gir,
			sandy);
		return hs;
	}

	private void initGolfers(GolferRepository golferRepository){
		golferRepository.save(createGolfer("Tauasa", "Timoteo"));
		golferRepository.save(createGolfer("Jarrod", "Corby"));
		golferRepository.save(createGolfer("Tiger", "Woods"));
		golferRepository.save(createGolfer("Ricky", "Fowler"));
		golferRepository.save(createGolfer("Michael", "Ambrose"));
		golferRepository.save(createGolfer("Michael", "Pentecost"));
		golferRepository.save(createGolfer("Pat", "Santora"));
		golferRepository.save(createGolfer("Nunya", "Bidness"));
		golferRepository.save(createGolfer("Inya", "Face"));
		golferRepository.save(createGolfer("John", "Timoeo"));
		golferRepository.save(createGolfer("Mindya", "Bidness"));
		golferRepository.save(createGolfer("Slapya", "Face"));
		golferRepository.save(createGolfer("Downya", "Hatch"));
		golferRepository.save(createGolfer("Sa", "Luafuluvalu"));
		golferRepository.save(createGolfer("Upya", "Butt"));
		golferRepository.save(createGolfer("Inya", "Crack"));
		golferRepository.save(createGolfer("Krossda", "Street"));
		golferRepository.save(createGolfer("Krossda", "Line"));
		golferRepository.save(createGolfer("John", "Doe"));
		golferRepository.save(createGolfer("Dirty", "Zapatos"));//*/
	}

	private Golfer createGolfer(String firstName, String lastName){
		return new Golfer("no-reply@tauasa.org", firstName, lastName);
	}

	private void initCourses(CourseRepository courseRepository){
		courseRepository.save(createCourse("Woodcreek GC"));
		courseRepository.save(createCourse("Diamond Oaks GC"));
		courseRepository.save(createCourse("Turkey Creek GC"));
		courseRepository.save(createCourse("Mather GC"));
	}

	private Course createCourse(String name){
		Course c = new Course(name);
		populateCourse(c);
		return c;
	}

	private void populateCourse(Course c){
		c.add(createTee(c, "Black", randInt(125, 155), randFloat(70F, 72F)));
		c.add(createTee(c, "Blue", randInt(120, 125), randFloat(68F, 70F)));
		c.add(createTee(c, "White", randInt(110, 120), randFloat(66F, 68F)));
		c.add(createTee(c, "Red", randInt(100, 110), randFloat(62F, 66F)));
	}

	private Tee createTee(Course course, String name, int slope, float rating){
		Tee tee = new Tee(name, slope, rating);
		tee.setCourse(course);
		tee.setHole1(new Hole(4, randInt(300, 410), 18));
		tee.setHole2(new Hole(4, randInt(300, 410), 17));
		tee.setHole3(new Hole(4, randInt(300, 410), 16));
		tee.setHole4(new Hole(3, randInt(100, 210), 15));
		tee.setHole5(new Hole(5, randInt(400, 600), 14));
		tee.setHole6(new Hole(4, randInt(300, 410), 13));
		tee.setHole7(new Hole(4, randInt(300, 410), 12));
		tee.setHole8(new Hole(3, randInt(100, 210), 11));
		tee.setHole9(new Hole(5, randInt(400, 600), 10));
		tee.setHole10(new Hole(5, randInt(400, 600), 9));
		tee.setHole11(new Hole(4, randInt(300, 410), 8));
		tee.setHole12(new Hole(4, randInt(300, 410), 7));
		tee.setHole13(new Hole(4, randInt(300, 410), 6));
		tee.setHole14(new Hole(3, randInt(100, 210), 5));
		tee.setHole15(new Hole(4, randInt(300, 410), 4));
		tee.setHole16(new Hole(5, randInt(400, 600), 3));
		tee.setHole17(new Hole(3, randInt(100, 210), 2));
		tee.setHole18(new Hole(4, randInt(300, 410), 1));
		return tee;
	}

}
