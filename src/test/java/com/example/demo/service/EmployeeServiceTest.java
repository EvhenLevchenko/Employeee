package com.example.demo.service;
import com.example.demo.BaseDomainTest;
import com.example.demo.dto.EmployeeDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
public class EmployeeServiceTest extends BaseDomainTest{
    @Autowired
    private  EmployeeService employeeService;

    @Test
    public void add(){
        int initial=  employeeService.getAllEmployees().size();
        employeeService.addEmployee(EmployeeDTO.builder().name("Bob").build());
        int finish = employeeService.getAllEmployees().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void getById() {
        EmployeeDTO employeeDTO = employeeService.getEmployeeId(employeeService.getAllEmployees().get(0).getId());
        assertThat(employeeDTO).isNotNull();
    }

    @Test
    public void getAll() {
        assertThat(employeeService.getAllEmployees()).hasSize(1);
    }

    @Test
    public void getByName() {
        EmployeeDTO employeeDTO = employeeService.getByEmployeeName(employeeService.getByEmployeeName("Bob").getName());
        assertThat(employeeDTO).isNotNull();
    }

    @Test
    public void delete() {
        int initial = employeeService.getAllEmployees().size();
        employeeService.deleteEmployeeById(employeeService.getAllEmployees().get(0).getId());
        int finish = employeeService.getAllEmployees().size();
        assertThat(initial).isGreaterThan(finish);
    }
}


