package com.example.demo.dto;

import com.example.demo.domain.Departament;
import lombok.*;

import java.io.Serializable;

@Getter
@Data
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentDTO implements Serializable {
    private long id;
    private String name;


    public static Departament fromDepartamentDTO(DepartamentDTO departamentDTO) {
        return Departament.builder()
                .id(departamentDTO.getId())
                .name(departamentDTO.getName())
                .build();
    }

    public static DepartamentDTO fromDepartament(Departament departament) {
        return DepartamentDTO.builder()
                .id(departament.getId())
                .name(departament.getName())
                .build();
    }
}