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
import org.tauasa.t2g.model.Scorecard;
import org.tauasa.t2g.model.Tee;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(GolferRepository golferRepository, CourseRepository courseRepository, ScorecardRepository scorecardRepository) {
		
		// TODO - scrape score card data from https://freegolftracker.com/courses/Diamond-Oaks_4311.htm
		log.info("Initializting database");

		return args -> {
			log.info("Create/pre-load some golfers");
			initGolfers(golferRepository);
			golferRepository.findAll().forEach(golfer -> log.info("+Preloaded " + golfer));

			// create and preload some courses
			log.info("Create/pre-load some golfers");
			initCourses(courseRepository);
			courseRepository.findAll().forEach(course -> {log.info("+Preloaded " + course);});

			// create scorecards for each golfer
			// initScorecards(golferRepository.findAll(), courseRepository.findAll(), scorecardRepository);			
			// scorecardRepository.findAll().forEach(scorecard -> log.info("+Preloaded " + scorecard));
			
			log.info("Database initialized");
		};
	}

	private void initScorecards(List<Golfer> golfers, List<Course> courses, ScorecardRepository scorecardRepository){
		// create a scorecard for every golfer, course and the first tee
		for (Golfer golfer : golfers) {
			for(Course course : courses){
				Tee tee = course.getTees().iterator().next();
				//create a scorecard for the current golfer and tee
				scorecardRepository.save(new Scorecard(golfer, tee));
				//Scorecard scorecard = new Scorecard(golfer, tee);
				//scorecardRepository.save(scorecard);
			}
		}
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
