package com.example.demo.repository;

import com.example.demo.BaseDomainTest;
import com.example.demo.domain.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CompanyRepositoryTest extends BaseDomainTest {

    @Autowired
    private  CompanyRepository companyRepository;

    @Test
    public void findAll() {
        List<Company> all = companyRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    public void getByName() {
        Company company = companyRepository.getCompanyByName("Company");
        assertThat(company).isNotNull();
    }

    @Test
    public void getById() {
        Company company = companyRepository.getCompanyById(companyRepository.findAll().get(0).getId());
        assertThat(company).isNotNull();
    }

    @Test
    public void add() {
        int initial = companyRepository.findAll().size();
        companyRepository.save(Company.builder().name("Company").build());
        int finish = companyRepository.findAll().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void delete() {
        int initial = companyRepository.findAll().size();
        companyRepository.deleteById(companyRepository.findAll().get(0).getId());
        int finish = companyRepository.findAll().size();
        assertThat(initial).isGreaterThan(finish);
    }
}
