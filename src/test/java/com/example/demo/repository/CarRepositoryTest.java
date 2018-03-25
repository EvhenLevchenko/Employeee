package com.example.demo.repository;

import com.example.demo.BaseDomainTest;
import com.example.demo.domain.Car;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void delete() {
        int initial = carRepository.findAll().size();
        carRepository.deleteById(carRepository.findAll().get(0).getId());
        int finish = carRepository.findAll().size();
        assertThat(initial).isGreaterThan(finish);
    }
}