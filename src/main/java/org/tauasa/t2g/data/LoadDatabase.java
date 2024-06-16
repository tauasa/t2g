package org.tauasa.t2g.data;

import java.util.List;

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
import org.tauasa.t2g.model.Tee;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(GolferRepository golferRepository, CourseRepository courseRepository, ScoreRepository scoreRepository) {
		
		// TODO - scrape score card data from https://freegolftracker.com/courses/Diamond-Oaks_4311.htm
		log.info("Initializting database");

		return args -> {

			log.info("Create/pre-load some golfers");
			initGolfers(golferRepository);
			List<Golfer> golfers = golferRepository.findAll();
			golfers.forEach(golfer -> log.info("+Preloaded " + golfer));

			// create and preload some courses
			log.info("Create/pre-load some courses");
			initCourses(courseRepository);
			List<Course> courses = courseRepository.findAll();
			courses.forEach(course -> {log.info("+Preloaded " + course);});

			// create scores
			for (Golfer golfer : golfers) {//for every golfer...
				for(Course course : courses){//and every course...
					Tee tee = course.getTees().iterator().next();//use the first tee...
					initScore(golfer, tee, scoreRepository);//and create score
				}
			}
	
			scoreRepository.findAll().forEach(score -> log.info("+Preloaded " + score));
			
			log.info("Database initialized");
		};
	}

	private void initScore(Golfer golfer, Tee tee, ScoreRepository scoreRepository){
		// create a scores for every golfer, course and the first tee

		Score score = new Score(golfer, tee);

		score.setHoleScore1(createHoleScore(tee.getHole1(), 2, 0, true, true, false));
		score.setHoleScore2(createHoleScore(tee.getHole2(), 3, 0, true, false, false));
		score.setHoleScore3(createHoleScore(tee.getHole3(), 2, 0, false, true, false));
		score.setHoleScore4(createHoleScore(tee.getHole4(), 1, 0, true, true, false));
		score.setHoleScore5(createHoleScore(tee.getHole5(), 2, 0, true, false, false));
		score.setHoleScore6(createHoleScore(tee.getHole6(), 2, 0, true, true, false));
		score.setHoleScore7(createHoleScore(tee.getHole7(), 3, 0, true, true, false));
		score.setHoleScore8(createHoleScore(tee.getHole8(), 1, 0, false, true, false));
		score.setHoleScore9(createHoleScore(tee.getHole9(), 0, 0, true, true, false));
		score.setHoleScore10(createHoleScore(tee.getHole10(), 2, 0, true, true, false));
		score.setHoleScore11(createHoleScore(tee.getHole11(), 4, 0, false, true, false));
		score.setHoleScore12(createHoleScore(tee.getHole12(), 1, 0, false, false, false));
		score.setHoleScore13(createHoleScore(tee.getHole13(), 1, 0, true, true, false));
		score.setHoleScore14(createHoleScore(tee.getHole14(), 2, 0, true, true, false));
		score.setHoleScore15(createHoleScore(tee.getHole15(), 1, 0, false, false, true));
		score.setHoleScore16(createHoleScore(tee.getHole16(), 3, 0, true, true, false));
		score.setHoleScore17(createHoleScore(tee.getHole17(), 2, 0, false, true, false));
		score.setHoleScore18(createHoleScore(tee.getHole18(), 3, 0, true, true, false));

		scoreRepository.save(score);
	}

	private HoleScore createHoleScore(Hole hole, int putts, int penalties, boolean fairway, boolean gir, boolean sandy){
		HoleScore hs = new HoleScore(hole.getPar()+1,//strokes (bogey golf)
			(int)(hole.getDistance() * 0.70f),//drive 70% of distance
			putts,
			penalties,
			0,
			fairway,
			gir,
			sandy);
		return hs;
	}

	private void initGolfers(GolferRepository golferRepository){
		golferRepository.save(new Golfer("golfer@tauasa.org", "Nunya", "Bidness"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Mindya", "Bidness"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Inya", "Face"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Slapya", "Face"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Downya", "Hatch"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Upya", "Butt"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Inya", "Crack"));
		golferRepository.save(new Golfer("golfer@tauasa.org", "Krossda", "Street"));
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
		c.add(createTee("Blue", 126, 71.4F));
		c.add(createTee("White", 113, 70.7F));
		c.add(createTee("Red", 108, 69.9F));
	}

	private Tee createTee(String name, int slope, float rating){
		Tee tee = new Tee(name, slope, rating);
		//tee.setCourse(c);
		tee.setHole1(new Hole(4, 370, 18));
		tee.setHole2(new Hole(4, 340, 17));
		tee.setHole3(new Hole(4, 360, 16));
		tee.setHole4(new Hole(3, 148, 15));
		tee.setHole5(new Hole(5, 460, 14));
		tee.setHole6(new Hole(4, 330, 13));
		tee.setHole7(new Hole(4, 390, 12));
		tee.setHole8(new Hole(3, 126, 11));
		tee.setHole9(new Hole(5, 440, 10));
		tee.setHole10(new Hole(5, 440, 9));
		tee.setHole11(new Hole(4, 300, 8));
		tee.setHole12(new Hole(4, 360, 7));
		tee.setHole13(new Hole(4, 310, 6));
		tee.setHole14(new Hole(3, 180, 5));
		tee.setHole15(new Hole(4, 420, 4));
		tee.setHole16(new Hole(5, 450, 3));
		tee.setHole17(new Hole(3, 120, 2));
		tee.setHole18(new Hole(4, 360, 1));

		return tee;
	}

}
