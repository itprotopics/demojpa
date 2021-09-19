package com.itprotopics.demo.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.itprotopics.demo.DemoApplication;
import com.itprotopics.demo.entities.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=DemoApplication.class)
public class StudentRepositoryTest {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    EntityManager em;


    @Test
    @Transactional
    public void retrieveStudenAndPassport() {

        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student.toString());
        logger.info("Passport-> {}", student.getPassport().toString());
        
        
    }

}