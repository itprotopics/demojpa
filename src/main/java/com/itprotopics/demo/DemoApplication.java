package com.itprotopics.demo;

import com.itprotopics.demo.repositories.CourseRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		studentRepository.saveStudentWithPassport();

	
	}

}
