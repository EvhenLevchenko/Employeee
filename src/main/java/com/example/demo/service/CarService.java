package com.example.demo.service;


import com.example.demo.domain.Car;
import com.example.demo.dto.CarDTO;
import com.example.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private CarRepository carRepository;

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(CarDTO::fromCar)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public CarDTO addCar(CarDTO carDTO) {
        Car car = carRepository.save(CarDTO.fromCarDTO(carDTO));
        return CarDTO.fromCar(car);
    }

    @Transactional
    public CarDTO updateCar(CarDTO carDTO) {
        Car car = carRepository.getOne(carDTO.getId());
        carRepository.saveAndFlush(car);
        return CarDTO.fromCar(car);
    }

    public CarDTO getCarId(long carId) {
        return CarDTO.fromCar(carRepository.getCarById(carId));
    }

    public CarDTO getByCarModel(String carModel) {
        return CarDTO.fromCar(carRepository.getCarByModel(carModel));
    }
}
