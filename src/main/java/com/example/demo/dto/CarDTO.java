package com.example.demo.dto;

import com.example.demo.domain.Car;
import com.example.demo.domain.Employee;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO implements Serializable {
    private long id;
    private Integer year;
    private String model;
    private List<String> employeeName;

    public static Car fromCar(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .year(carDTO.getYear())
                .model(carDTO.getModel())
                .build();
    }

    public static CarDTO fromCarDTO(Car car) {
        CarDTO carDTO = CarDTO.builder()
                .id(car.getId())
                .year(car.getYear())
                .model(car.getModel())
                .build();
        List<String> employees = new ArrayList<>();
        if (car.getEmployeers() != null) {
            for (Employee employee : car.getEmployeers()) {
                employees.add(employee.getName());
            }
            carDTO = carDTO.toBuilder().employeeName(employees).build();
        }
        return carDTO;
    }
}
