package com.itprotopics.demo.repositories;

import javax.persistence.EntityManager;

import com.itprotopics.demo.entities.Course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    
    @Autowired
    EntityManager em;

    public Course findById(Long id) {

        return em.find(Course.class, id);
        
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save (Course course)
    {
        if (course.getId() == null ) {
            em.persist((course));
        }
        else {
            em.merge(course);
        }

        return course;

    }

    public void playWithEntityManager() {
        
    }

    
}