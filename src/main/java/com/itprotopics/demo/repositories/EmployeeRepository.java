package com.itprotopics.demo.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.itprotopics.demo.entities.Employee;
import com.itprotopics.demo.entities.FullTimeEmployee;
import com.itprotopics.demo.entities.PartTimeEmployee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee) {
        
        em.persist(employee);
    }

    // public List<Employee> retrieveAllEmployees() {
        
    //     return em.createQuery("select e from Employee e", Employee.class).getResultList();

    // }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();

    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();

    }


}