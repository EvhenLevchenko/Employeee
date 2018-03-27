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
    public  List<CarDTO> getAll(){
        return carService.getAllCars();
    }

//    @GetMapping
//    public ResponseEntity<CarDTO> addCar(@RequestBody CarDTO carDTO) {
//        CarDTO carDTO1 = carService.addCar(carDTO);
//        return ResponseEntity.ok(carService.addCar(carDTO));//TODO  Error creating bean with name 'requestMappingHandlerMapping'
//    }

    @PostMapping
    public ResponseEntity<CarDTO> add(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carService.addCar(carDTO);
        return ResponseEntity.ok(carDTO1);
    }

    @PostMapping("/all")
    public ResponseEntity<CarDTO> adds(@RequestBody List<CarDTO>  carDTOs) {
        CarDTO carDTO1 = carService.addCar(carDTOs);
        return ResponseEntity.ok(carDTO1);
    }

    @PutMapping
    public ResponseEntity<CarDTO> update(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carService.updateCar(carDTO);
        return ResponseEntity.ok(carDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") long carId) {
        try {
            carService.deleteCarById(carId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable(value = "id") long carId) {
        return ResponseEntity.ok(carService.getCarId(carId));
    }

    @GetMapping("/{car_model}")
    public ResponseEntity<CarDTO> getCarByModel(@PathVariable(value = "car_model") String carModel) {
        return ResponseEntity.ok(carService.getByCarModel(carModel));
    }
}
