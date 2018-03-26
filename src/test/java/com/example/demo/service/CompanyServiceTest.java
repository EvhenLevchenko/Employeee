package com.example.demo.service;

import com.example.demo.BaseDomainTest;
import com.example.demo.dto.CompanyDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class CompanyServiceTest  extends BaseDomainTest{

    @Autowired
    private  CompanyService companyService;

    @Test
    public void add(){
        int initial=  companyService.getAllCompany().size();
        companyService.addCompany(CompanyDTO.builder().name("Company").size(4555).build());
        int finish = companyService.getAllCompany().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void getById() {
        CompanyDTO companyDTO = companyService.getCompanyId(companyService.getAllCompany().get(0).getId());
        assertThat(companyDTO).isNotNull();
    }

    @Test
    public void getAll() {
        assertThat(companyService.getAllCompany()).hasSize(1);
    }

    @Test
    public void getByName() {
        CompanyDTO companyDTO = companyService.getByCompanyName(companyService.getByCompanyName("Company").getName());
        assertThat(companyDTO).isNotNull();
    }

    @Test
    public void delete() {
        int initial = companyService.getAllCompany().size();
        companyService.deleteCompanyById(companyService.getAllCompany().get(0).getId());
        int finish = companyService.getAllCompany().size();
        assertThat(initial).isGreaterThan(finish);
    }
}
