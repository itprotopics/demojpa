package com.itprotopics.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import com.itprotopics.demo.entities.Course;
import com.itprotopics.demo.entities.Review;

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

        Course course1  = new Course("Web services in 100 steps");
        em.persist(course1);
        
        Course course2  = new Course("Angular in 100 steps");
        em.persist(course2);
        em.flush();

       
        course1.setName("Web services in 100 steps Updated");
        course2.setName("Angular in 100 steps Updated");
       
        em.refresh(course1);
        em.flush();

    }

    public void addReviewsForCourse() {

        Course course = findById(10003L);

        course.getReviews().stream().forEach(r -> logger.info(r.toString()));

        Review review1 = new Review("5",  "Great Hands-on Stuff.");
        Review review2 = new Review("5", "Hatsoff.");

        review1.setCourse(course);
        review2.setCourse(course);

        course.addReview(review1);
        course.addReview(review2);

        em.persist(review1);
        em.persist(review2);

    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {

        Course course = findById(courseId);

        course.getReviews().stream().forEach(r -> logger.info(r.toString()));

        reviews.stream().forEach(r -> {

            r.setCourse(course);
            course.addReview(r);
            em.persist(r);
        });
        


    }

    
}