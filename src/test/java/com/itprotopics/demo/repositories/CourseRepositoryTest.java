package com.itprotopics.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import com.itprotopics.demo.DemoApplication;
import com.itprotopics.demo.entities.Course;
import com.itprotopics.demo.entities.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(classes=DemoApplication.class)
public class CourseRepositoryTest {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CourseRepository courseRepository;


	@Test
	void testFindById() {

        Course course = courseRepository.findById(10001L);

        assertEquals("Math", course.getName());
        
	}


    @Test
    @DirtiesContext
    void testDeleteById() {
        
        courseRepository.deleteById(10001L);
        
        assertNull(courseRepository.findById(10001L));


    }
    
    @Test
    @DirtiesContext
    void testSave() {
        
        Course course = courseRepository.findById(10001L);
        assertEquals("Math", course.getName());

        course.setName("Math updated");

        courseRepository.save(course);

        courseRepository.save(course);

        Course course1 = courseRepository.findById(10001L);
        
        assertEquals("Math updated", course1.getName());


    }

    @Test
    void testPlayWithEntityManager() {

        courseRepository.playWithEntityManager();
    }

    

}
