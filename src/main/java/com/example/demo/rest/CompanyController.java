package com.example.demo.rest;


import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDTO> getAll() {
        return companyService.getAllCompany();
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCar(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.addCompany(companyDTO);
        return ResponseEntity.ok(companyDTO1);
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> updateCar(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.updateCompany(companyDTO);
        return ResponseEntity.ok(companyDTO1);
    }

    @DeleteMapping("/{company_id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(value = "company_id") long companyId) {
        try {
            companyService.deleteCompanyById(companyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{company_id}")
    public ResponseEntity<CompanyDTO> getEmployeeById(@PathVariable(value = "company_id") long companyId) {
        return ResponseEntity.ok(companyService.getCompanyId(companyId));
    }

    @GetMapping("/{company_name}")
    public ResponseEntity<CompanyDTO> getCarByModel(@PathVariable(value = "car_model") String companyName) {
        return ResponseEntity.ok(companyService.getByCompanyName(companyName));
    }
}
