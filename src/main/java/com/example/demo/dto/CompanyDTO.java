package com.example.demo.dto;

import com.example.demo.domain.Company;
import lombok.*;

import java.io.Serializable;

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



    public static CompanyDTO fromCompany(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .size(company.getSize())
                .build();
    }

    public static Company fromCompanyDTO(CompanyDTO companyDTO) {
        return Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .size(companyDTO.getSize())
                .build();
    }
}
