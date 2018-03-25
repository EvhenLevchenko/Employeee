package com.example.demo.service;


import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.save(EmployeeDTO.fromEmployeeDTO(employeeDTO));
        return EmployeeDTO.fromEmployee(employee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getOne(employeeDTO.getId());
        employeeRepository.saveAndFlush(employee);
        return EmployeeDTO.fromEmployee(employee);
    }

    public EmployeeDTO getEmployeeId(long employeeId) {
        return EmployeeDTO.fromEmployee(employeeRepository.getEmployeeById(employeeId));
    }

    public EmployeeDTO getByEmployeeName(String employeeName) {
        return EmployeeDTO.fromEmployee(employeeRepository.getEmployeeByName(employeeName));
    }
}