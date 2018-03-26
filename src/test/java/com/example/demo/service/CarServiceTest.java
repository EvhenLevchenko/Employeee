package com.example.demo.service;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.demo.BaseDomainTest;
import com.example.demo.dto.CarDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CarServiceTest extends BaseDomainTest {
    
    @Autowired
    private  CarService carService;

    @Test
    public void add(){
        int initial=  carService.getAllCars().size();
        carService.addCar(CarDTO.builder().model("model").year(2000).build());
        int finish = carService.getAllCars().size();
        assertThat(initial).isLessThan(finish);
    }
    @Test

    public void getById() {
        CarDTO CarDTO = carService.getCarId(carService.getAllCars().get(0).getId());
        assertThat(CarDTO).isNotNull();
    }

    @Test
    public void getAll() {
        assertThat(carService.getAllCars()).hasSize(1);
    }

    @Test
    public void getByName() {
        CarDTO CarDTO = carService.getByCarModel(carService.getByCarModel("model").getModel());
        assertThat(CarDTO).isNotNull();
    }

//    @Test
//    public void delete() {
//        int initial = carService.getAllCars().size();
//        carService.deleteCarById(carService.getAllCars().get(0).getId());
//        int finish = carService.getAllCars().size();
//        assertThat(initial).isGreaterThan(finish);
//    }
}
