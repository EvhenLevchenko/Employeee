package com.example.demo;


import com.example.demo.domain.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public abstract class BaseDomainTest {
    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp()throws Exception{
        Employee employee=Employee.builder()
                .name("Bob")
                .build();
        Car car= Car.builder()
                .model("model")
                .year(2000)
                .build();
        entityManager.persist(employee);
    }
}
