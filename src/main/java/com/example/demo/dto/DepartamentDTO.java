package com.example.demo.dto;

import com.example.demo.domain.Departament;
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
public class DepartamentDTO implements Serializable {
    private long id;
    private String name;
    private List<String> employeesName;

    public static Departament fromDepartament(DepartamentDTO departamentDTO) {
        return Departament.builder()
                .id(departamentDTO.getId())
                .name(departamentDTO.getName())
                .build();
    }

    public static DepartamentDTO fromDepartamentDTO(Departament departament) {
        DepartamentDTO departamentDTO = DepartamentDTO.builder()
                .id(departament.getId())
                .name(departament.getName())
                .build();

        List<String> employees = new ArrayList<>();
        if (departament.getEmployees() != null) {
            for (Employee employee : departament.getEmployees()) {
                employees.add(employee.getName());
            }
            departamentDTO = departamentDTO.toBuilder().employeesName(employees).build();
        }
        return departamentDTO;
    }
}