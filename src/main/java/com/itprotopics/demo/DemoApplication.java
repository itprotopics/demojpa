package com.itprotopics.demo;

import java.math.BigDecimal;

import com.itprotopics.demo.entities.FullTimeEmployee;
import com.itprotopics.demo.entities.PartTimeEmployee;
import com.itprotopics.demo.repositories.CourseRepository;
import com.itprotopics.demo.repositories.EmployeeRepository;
import com.itprotopics.demo.repositories.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CourseRepository courseRepository = null ;

	@Autowired
	private StudentRepository studentRepository = null ;

	@Autowired
	private EmployeeRepository employeeRepository = null ;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//studentRepository.saveStudentWithPassport();

		// List<Review> reviews = Arrays.asList(
		// 	new Review("4",  "Great Hands-on Stuff."),
		// 	new Review("4", "Hatsoff.")
		// );

		// courseRepository.addReviewsForCourse(10003L, reviews);
	
		//studentRepository.insertStudentAndCourse();

		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("200")));

		//employeeRepository.retrieveAllEmployees().stream().forEach(e -> logger.info(e.toString()));

		employeeRepository.retrieveAllFullTimeEmployees().stream().forEach(e -> logger.info(e.toString()));
		employeeRepository.retrieveAllPartTimeEmployees().stream().forEach(e -> logger.info(e.toString()));
	}

}
