package com.example.demo.dto;

import com.example.demo.domain.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Data
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private long id;
    private String name;
    @Singular
    private List<String> departaments;

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
                .departaments(employee.getDepartaments().stream()
                        .map(departament -> departament.getName())
                        .collect(Collectors.toList()))
                .build();
        return employeeDTO;
    }
}


