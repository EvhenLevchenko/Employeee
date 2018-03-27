package com.example.demo.dto;

import com.example.demo.domain.Car;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO implements Serializable {
    private long id;
    private int year;
    private String model;

    public static Car fromCarDTO(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .year(carDTO.getYear())
                .model(carDTO.getModel())
                .build();
    }

    public static CarDTO fromCar(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .year(car.getYear())
                .model(car.getModel())
                .build();
    }
}
