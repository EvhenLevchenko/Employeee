package com.example.demo.dto;

import com.example.demo.domain.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private long id;
    private String name;
    private List<String> departamentName;
    private List<String> carName;

    public static Employee fromEmployeeDTO(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .build();
    }

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();

        List<String> departamentName = new ArrayList<>();
        if (employee.getDepartaments() != null) {
            for (Departament departament : employee.getDepartaments()) {
                departamentName.add(departament.getName());
            }
            employeeDTO = employeeDTO.toBuilder().departamentName(departamentName).build();
        }

        List<String> carName = new ArrayList<>();
        if (employee.getCars() != null) {
            for (Car car : employee.getCars()) {
                carName.add(car.getModel());
            }
            employeeDTO = employeeDTO.toBuilder().carName(carName).build();
        }
        return employeeDTO;
    }
}


