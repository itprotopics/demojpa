package com.itprotopics.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.itprotopics.demo.DemoApplication;
import com.itprotopics.demo.entities.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes=DemoApplication.class)
public class JPQLTest {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    EntityManager em;

    @Test
    public void findById_basic() {

        List resultList = em.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void findById_typed() {

        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c TYPED -> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%Logic%'", Course.class );
        List<Course> resultList = query.getResultList();
        logger.info("Select with a LIKE -> {}", resultList);
    }
        
            
        


}