package com.example.demo.service;

import com.example.demo.BaseDomainTest;
import com.example.demo.dto.CarDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest extends BaseDomainTest {

//    @Autowired
//    private CarService carService;
//
//    @Test
//    public void findAll() {
//        List<CarDTO> all = carService.getAllCars();
//        assertThat(all).hasSize(1);
//    }
//
//    @Test
//    public void getByModel() {
//        CarDTO carDTO = carService.getByCarModel("model");
//        assertThat(carDTO).isNotNull();
//    }
//
//    @Test
//    public void getById() {
//        CarDTO carDTO = carService.getCarId(carService.getAllCars().get(0).getId());
//        assertThat(carDTO).isNotNull();
//    }
//
//    @Test
//    public void add() {
//        int initial = carService.getAllCars().size();
//        carService.addCar(CarDTO.builder().model("model").build());
//        int finish = carService.getAllCars().size();
//        assertThat(initial).isLessThan(finish);
//    }
//
//    @Test
//    public void delete() {
//        int initial = carService.getAllCars().size();
//        carService.deleteCarById(carService.getAllCars().get(0).getId());
//        int finish = carService.getAllCars().size();
//        assertThat(initial).isGreaterThan(finish);
//    }
}
