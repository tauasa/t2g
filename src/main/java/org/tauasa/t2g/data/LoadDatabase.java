package org.tauasa.t2g.data;

import java.util.Date;
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
import org.tauasa.t2g.model.ScoreId;
import org.tauasa.t2g.model.Scorecard;
import org.tauasa.t2g.model.Tee;
import org.tauasa.t2g.util.Utils;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(GolferRepository golferRepository, CourseRepository courseRepository, ScoreRepository scoreRepository, ScorecardRepository scorecardRepository) {
		
		// TODO - scrape score card data from https://freegolftracker.com/courses/Diamond-Oaks_4311.htm
		log.info("Initializting database");

		return args -> {

			log.info("Create/pre-load some golfers");
			initGolfers(golferRepository);
			List<Golfer> golfers = golferRepository.findAll();
			golfers.forEach(golfer -> log.info("+Preloaded: " + golfer));

			// create and preload some courses
			log.info("Create/pre-load some courses");
			initCourses(courseRepository);
			List<Course> courses = courseRepository.findAll();
			courses.forEach(course -> {log.info("+Preloaded: " + course);});

			Date teeTime = Utils.parseTeeTime("2406210900");

			int teeTimeCounter = 0;
			for(Course course : courses){
				Scorecard scorecard = new Scorecard();
				Tee tee = course.getTees().iterator().next();
				for(Golfer golfer : golfers){
					Score score = initScore(golfer, tee, 
						Utils.adjustDate(teeTime, teeTimeCounter * -1), scoreRepository);
					golfer.add(score);
					//golferRepository.save(golfer);
					scorecard.add(score);
				}
				teeTimeCounter++;
				scorecardRepository.save(scorecard);
			}//*/

			scoreRepository.findAll().forEach(score -> log.info("+Preloaded " + score));
			scorecardRepository.findAll().forEach(scorecard -> log.info("+Preloaded " + scorecard));
			
			log.info("Database initialized");
		};
	}

	private static int randInt(int min, int max){
		Random random = new Random();
		return random.nextInt(min, max);
	}

	private static float randFloat(float min, float max){
		Random random = new Random();
		return random.nextFloat(min, max);
	}

	private Score initScore(Golfer golfer, Tee tee, Date teeTime, ScoreRepository scoreRepository){
		// create a scores for the specified golfer, course and the first tee
		Score score = new Score(new ScoreId(tee.getId(), teeTime, golfer.getId()));

		score.setHoleScore1(createHoleScore(tee.getHole1(), randInt(0,5), 0, true, true, false));
		score.setHoleScore2(createHoleScore(tee.getHole2(), randInt(0,5), 0, true, false, false));
		score.setHoleScore3(createHoleScore(tee.getHole3(), randInt(0,5), 0, false, true, false));
		score.setHoleScore4(createHoleScore(tee.getHole4(), randInt(0,5), 0, true, true, false));
		score.setHoleScore5(createHoleScore(tee.getHole5(), randInt(0,5), 0, true, false, false));
		score.setHoleScore6(createHoleScore(tee.getHole6(), randInt(0,5), 0, true, true, false));
		score.setHoleScore7(createHoleScore(tee.getHole7(), randInt(0,5), 0, true, true, false));
		score.setHoleScore8(createHoleScore(tee.getHole8(), randInt(0,5), 0, false, true, false));
		score.setHoleScore9(createHoleScore(tee.getHole9(), randInt(0,5), 0, true, true, false));
		score.setHoleScore10(createHoleScore(tee.getHole10(), randInt(0,5), 0, true, true, false));
		score.setHoleScore11(createHoleScore(tee.getHole11(), randInt(0,5), 0, false, true, false));
		score.setHoleScore12(createHoleScore(tee.getHole12(), randInt(0,5), 0, false, false, false));
		score.setHoleScore13(createHoleScore(tee.getHole13(), randInt(0,5), 0, true, true, false));
		score.setHoleScore14(createHoleScore(tee.getHole14(), randInt(0,5), 0, true, true, false));
		score.setHoleScore15(createHoleScore(tee.getHole15(), randInt(0,5), 0, false, false, true));
		score.setHoleScore16(createHoleScore(tee.getHole16(), randInt(0,5), 0, true, true, false));
		score.setHoleScore17(createHoleScore(tee.getHole17(), randInt(0,5), 0, false, true, false));
		score.setHoleScore18(createHoleScore(tee.getHole18(), randInt(0,5), 0, true, true, false));

		return scoreRepository.save(score);
	}

	private HoleScore createHoleScore(Hole hole, int putts, int penalties, boolean fairway, boolean gir, boolean sandy){
		HoleScore hs = new HoleScore(
			hole.getPar() + randInt(-2, 4), //random score between birdie and snowman
			hole.getPar() > 3 ? randInt(200, hole.getDistance()-60) : 0, // random drive distance 
			putts,
			penalties,
			0,
			fairway,
		 	gir,
			sandy);
		return hs;
	}

	private void initGolfers(GolferRepository golferRepository){
		golferRepository.save(createGolfer("Tauasa", "Timoteo"));
		golferRepository.save(createGolfer("Nunya", "Bidness"));
		golferRepository.save(createGolfer("Inya", "Face"));
		golferRepository.save(createGolfer("Mindya", "Bidness"));
		/*golferRepository.save(createGolfer("Slapya", "Face"));
		golferRepository.save(createGolfer("Downya", "Hatch"));
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
