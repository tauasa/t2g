package org.tauasa.t2g.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tauasa.t2g.model.Course;
import org.tauasa.t2g.model.Golfer;
import org.tauasa.t2g.model.Hole;
import org.tauasa.t2g.model.HoleScore;
import org.tauasa.t2g.model.Location;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.Scorecard;
import org.tauasa.t2g.model.Tee;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	private static final Random RAND = new Random();
	private static final List<String> SURNAMES = readSurnames();
	private static final List<String> FIRST_NAMES = readFirstNames();
	private static final List<String> US_STATES = readUsStates();
	private static final List<String> US_CITIES = readUsCities();
	private static final List<String> TEE_NAMES = Arrays.asList("Black", "Blue", "White", "Red");
	private static final List<String> COURSE_EXTS = Arrays.asList("GC", "Golf Course", "Country Club", "CC", "Pines", "Municipal GC", "");
	private static final List<String> DOMAINS = Arrays.asList("tauasa.org", "gmail.com", "yahoo.com", "icloud.com", "mustard.edu", "att.org", "hamdsandwish.netx");
	private static final long NUM_COURSES = 1000;
	private static final long NUM_GOLFERS = 500;
	private static final int NUM_SCORECARDS = 200;
	private static final int NUM_GOLFERS_PER_SCORECARD = 4;

	@Bean
	public CommandLineRunner initDatabase(CourseRepository courseRepository, GolferRepository golferRepository, ScoreRepository scoreRepository, ScorecardRepository scorecardRepository) {

		return (String[] args) -> {

			if (scorecardRepository.count() > NUM_SCORECARDS) {

				log.info("Database previously initialized");
				
			}else{

				log.info("Populating database with random data...");

				if(courseRepository.count() < NUM_COURSES){
					log.info("Create {} random courses", NUM_COURSES);
					initCourses(courseRepository, NUM_COURSES-courseRepository.count());
				}
				List<Course> courses = courseRepository.findAll();
				courses.forEach(c -> log.info("+Preloaded: {}", c));

				if(golferRepository.count() < NUM_GOLFERS){
					log.info("Create/pre-load {} random golfers", NUM_GOLFERS);
					initGolfers(golferRepository, NUM_GOLFERS-golferRepository.count());
				}
				List<Golfer> golfers = golferRepository.findAll();
				golfers.forEach(g -> log.info("+Preloaded: {}", g));

				LocalDateTime teeTime = LocalDateTime.now().minusDays(30).withHour(6).withMinute(30).withSecond(0);
				log.info("Create/pre-load {} random scorecards", NUM_SCORECARDS);

				for(int i=0;i<NUM_SCORECARDS;i++){
					Scorecard scorecard = new Scorecard(teeTime);

					// select a random course
					Course course = (Course)randObj(courses);

					// select NUM_GOLFERS_PER_SCORECARD random golfers using a Set to 
					// avoid possible duplicates that violates a unique constraint
					Set<Golfer> foursome = new HashSet<>();
					for(int j=0;j<NUM_GOLFERS_PER_SCORECARD;j++){
						foursome.add(golfers.get(randInt(0, golfers.size()-1)));
					}

					// create a score for each golfer and add it to the scorecard
					for(Golfer golfer : foursome){
						// each golfer plays from a random tee
						Tee tee = (Tee)randObj(new ArrayList<>(course.getTees()));
						log.debug("Create/pre-load score for {} on {} tees", tee.getName(), golfer.getEmail());
						Score score = initScore(golfer, tee, teeTime, scoreRepository);
						scorecard.add(score);
					}

					scorecardRepository.save(scorecard);

					// if it's after 1700 skip to tomorrow @ 0630 otherwise increment by 15 min
					teeTime = teeTime.getHour() > 17 ? teeTime.plusDays(i).withHour(6).withMinute(30) : teeTime.plusMinutes(15);
				}

				scoreRepository.findAll().forEach(score -> log.info("+Preloaded " + score));
				scorecardRepository.findAll().forEach(scorecard -> log.info("+Preloaded " + scorecard));
				
				log.info("Database initialized");

			}

		};
		
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

	private static HoleScore createHoleScore(Hole hole, int penalties, boolean fairway, boolean gir, boolean sandy){
		HoleScore hs = new HoleScore(
			hole.getPar() + randInt(-2, 4), // random score between birdie and snowman
			hole.getPar() > 3 ? randInt(200, hole.getDistance()-90) : 0, // random drive distance 
			randInt(0,5),
			penalties,
			RAND.nextInt(0,2),
			fairway,
		 	gir,
			sandy);
		return hs;
	}

	private void initGolfers(GolferRepository golferRepository, long num){
		for(int i=0;i<num;i++){
			golferRepository.save(createGolfer(randString(FIRST_NAMES), randString(SURNAMES)));
		}
	}

	private Golfer createGolfer(String firstName, String lastName){
		return new Golfer(
			(firstName.charAt(0)+lastName+randInt(100,999)
			+"@"+randString(DOMAINS)).toLowerCase(), 
			firstName, lastName);
	}

	private void initCourses(CourseRepository courseRepository, long num){
		for(int i=0;i<num; i++){
			courseRepository.save(createCourse(randString(US_CITIES)+" "+randString(COURSE_EXTS)));
		}
	}

	private Course createCourse(String name){
		Course c = new Course(name, new Location(randString(US_CITIES), randString(US_STATES)));
		populateTees(c);
		return c;
	}

	private void populateTees(Course c){
		for(String name : TEE_NAMES){
			c.add(createTee(name, randInt(100, 155), randFloat(70F, 72F)));
		}
	}

	private Tee createTee(String name, int slope, float rating){
		Tee tee = new Tee(name, slope, rating);
		tee.setHole1(new Hole(4, randInt(300, 410), 18));
		tee.setHole2(new Hole(4, randInt(300, 410), 2));
		tee.setHole3(new Hole(4, randInt(300, 410), 16));
		tee.setHole4(new Hole(3, randInt(100, 210), 4));
		tee.setHole5(new Hole(5, randInt(400, 600), 14));
		tee.setHole6(new Hole(4, randInt(300, 410), 10));
		tee.setHole7(new Hole(4, randInt(300, 410), 8));
		tee.setHole8(new Hole(3, randInt(100, 210), 6));
		tee.setHole9(new Hole(5, randInt(400, 600), 11));
		tee.setHole10(new Hole(5, randInt(400, 600), 9));
		tee.setHole11(new Hole(4, randInt(300, 410), 12));
		tee.setHole12(new Hole(4, randInt(300, 410), 7));
		tee.setHole13(new Hole(4, randInt(300, 410), 13));
		tee.setHole14(new Hole(3, randInt(100, 210), 5));
		tee.setHole15(new Hole(4, randInt(300, 410), 15));
		tee.setHole16(new Hole(5, randInt(400, 600), 3));
		tee.setHole17(new Hole(3, randInt(100, 210), 17));
		tee.setHole18(new Hole(4, randInt(300, 410), 1));
		return tee;
	}

	private static List<String> readSurnames(){
		return readLinesFromInputStream(LoadDatabase.class.getResourceAsStream("/data/surnames.txt"));
	}

	private static List<String> readFirstNames(){
		return readLinesFromInputStream(LoadDatabase.class.getResourceAsStream("/data/first-names.txt"));
	}

	private static List<String> readUsStates(){
		return readLinesFromInputStream(LoadDatabase.class.getResourceAsStream("/data/us-states.txt"));
	}

	private static List<String> readUsCities(){
		return readLinesFromInputStream(LoadDatabase.class.getResourceAsStream("/data/us-cities.txt"));
	}

	private static List<String> readLinesFromInputStream(InputStream inputStream){
		List<String> rows = new ArrayList<>();
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				rows.add(line);
			}
		}catch(IOException e){
			//swallow
		}
		return rows;
	}

	private static int randInt(int min, int max){
		return RAND.nextInt(min, max);
	}

	private static float randFloat(float min, float max){
		DecimalFormat df = new DecimalFormat("##.#");
		return Float.parseFloat(df.format(RAND.nextFloat(min, max)));
	}

	private static String randString(List<String> list){
		return list.get(randInt(0, list.size()-1));
	}

	private static Object randObj(List<? extends Object> list){
		return list.get(randInt(0, list.size()-1));
	}

	

}
