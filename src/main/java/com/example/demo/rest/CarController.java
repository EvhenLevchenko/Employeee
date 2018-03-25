package com.example.demo.rest;


import com.example.demo.dto.CarDTO;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<CarDTO> addCar(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carService.addCar(carDTO);
        return ResponseEntity.ok(carDTO1);
    }

    @PutMapping
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carService.updateCar(carDTO);
        return ResponseEntity.ok(carDTO1);
    }

    @DeleteMapping("/{car_id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(value = "car_id") long carId) {
        try {
            carService.deleteCarById(carId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<CarDTO> getEmployeeById(@PathVariable(value = "car_id") long carId) {
        return ResponseEntity.ok(carService.getCarId(carId));
    }

    @GetMapping("/{car_model}")
    public ResponseEntity<CarDTO> getCarByModel(@PathVariable(value = "car_model") String carModel) {
        return ResponseEntity.ok(carService.getByCarModel(carModel));
    }
}
