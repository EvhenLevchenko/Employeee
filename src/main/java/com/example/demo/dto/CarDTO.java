package com.example.demo.dto;

import com.example.demo.domain.Car;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO implements Serializable {
    private long id;
    private int year;
    private String model;
    @Singular
    private List<String> employees;

    public static Car fromCarDTO(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .year(carDTO.getYear())
                .model(carDTO.getModel())
                .build();
    }

    public static CarDTO fromCar(Car car) {
        CarDTO carDTO=CarDTO.builder()
                .id(car.getId())
                .year(car.getYear())
                .model(car.getModel())
                .employees(car.getEmployees().stream()
                        .map(employee -> employee.getName())
                        .collect(Collectors.toList()))
                .build();
        return  carDTO;
    }
}
