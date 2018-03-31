package com.example.demo.dto;

import com.example.demo.domain.Company;
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
public class CompanyDTO implements Serializable {
    private long id;
    private String name;
    private int size;
    @Singular
    private List<String> departaments;

    public static CompanyDTO fromCompany(Company company) {
        CompanyDTO companyDTO=CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .size(company.getSize())
                .departaments(company.getDepartaments().stream()
                        .map(departament -> departament.getName())
                        .collect(Collectors.toList()))
                .build();
        return companyDTO;
    }

    public static Company fromCompanyDTO(CompanyDTO companyDTO) {
        return Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .size(companyDTO.getSize())
                .build();
    }
}
