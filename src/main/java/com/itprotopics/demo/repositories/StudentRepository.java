
package com.itprotopics.demo.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.itprotopics.demo.entities.Course;
import com.itprotopics.demo.entities.Passport;
import com.itprotopics.demo.entities.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {

        return em.find(Student.class, id);
        
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save (Student student)
    {
        if (student.getId() == null ) {
            em.persist((student));
        }
        else {
            em.merge(student);
        }

        return student;

    }

    public void saveStudentWithPassport() {

        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student  = new Student("Mike");

        student.setPassport(passport);

        em.persist(student);
        

    }

    public void insertStudentAndCourse () {
        Student student = new Student("Jack");
        Course course = new Course("Curso de microservicios");

        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        
    }


}