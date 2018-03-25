package com.example.demo.repository;

import com.example.demo.BaseDomainTest;
import com.example.demo.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepositoryTest extends BaseDomainTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findAll() {
        List<Employee> all = employeeRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    public void getByName() {
        Employee employee = employeeRepository.getEmployeeByName("Bob");
        assertThat(employee).isNotNull();
    }

    @Test
    public void getById(){
        Employee employee = employeeRepository.getEmployeeById(employeeRepository.findAll().get(0).getId());
        assertThat(employee).isNotNull();
    }

    @Test
    public void add(){
        int initial = employeeRepository.findAll().size();
        employeeRepository.save(Employee.builder().name("Bob").build());
        int finish = employeeRepository.findAll().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void delete(){
        int initial = employeeRepository.findAll().size();
        employeeRepository.deleteById(employeeRepository.findAll().get(0).getId());
        int finish = employeeRepository.findAll().size();
        assertThat(initial).isGreaterThan(finish);
    }
}
