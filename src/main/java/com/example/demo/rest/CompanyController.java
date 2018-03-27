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
        return companyService.getAll();
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> add(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.add(companyDTO);
        return ResponseEntity.ok(companyDTO1);
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.update(companyDTO);
        return ResponseEntity.ok(companyDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") long companyId) {
        try {
            companyService.deleteCompanyById(companyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable(value = "id") long companyId) {
        return ResponseEntity.ok(companyService.getCompanyId(companyId));
    }

    @GetMapping("/{company_name}")
    public ResponseEntity<CompanyDTO> getCompanyByName(@PathVariable(value = "company_name") String companyName) {
        return ResponseEntity.ok(companyService.getByCompanyName(companyName));
    }
}
