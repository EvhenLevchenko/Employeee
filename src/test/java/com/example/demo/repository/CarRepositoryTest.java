package com.example.demo.repository;

import com.example.demo.BaseDomainTest;
import com.example.demo.domain.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

public class CarRepositoryTest extends BaseDomainTest {

    @Autowired
    private CarRepository carRepository;


    @Test
    public void findAll() {
        List<Car> all = carRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    public void getByName() {
        Car car = carRepository.getCarByModel("model");
        assertThat(car).isNotNull();
    }

    @Test
    public void getById() {
        Car car = carRepository.getCarById(carRepository.findAll().get(0).getId());
        assertThat(car).isNotNull();
    }

    @Test
    public void add() {
        int initial = carRepository.findAll().size();
        carRepository.save(Car.builder().model("model").build());
        int finish = carRepository.findAll().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test


    public void testSimpleStuff() {
        String name = "SpringPersistenceWithHibernate";
        Assert.assertEquals("SpringPersistenceWithHibernate", name);
    }
}