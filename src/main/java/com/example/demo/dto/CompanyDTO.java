package com.example.demo.dto;

import com.example.demo.domain.Company;
import com.example.demo.domain.Departament;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO implements Serializable {
    private long id;
    private String name;
    private Integer size;
    private List<String> departametsName;

    private static Company fromCompany(CompanyDTO companyDTO) {
        return Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .size(companyDTO.getSize())
                .build();
    }

    private static CompanyDTO fromCompanyDTO(Company company) {
        CompanyDTO companyDTO = CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .size(company.getSize())
                .build();

        List<String> departaments = new ArrayList<>();
        if (company.getDepartaments() != null) {
            for (Departament departament : company.getDepartaments()) {
                departaments.add(departament.getName());
            }
            companyDTO = companyDTO.toBuilder().departametsName(departaments).build();
        }
        return companyDTO;
    }

}
