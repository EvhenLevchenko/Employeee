package com.example.demo.service;

import com.example.demo.domain.Company;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {
    private CompanyRepository companyRepository;

    public List<CompanyDTO> getAllCompany() {
        return companyRepository.findAll().stream()
                .map(CompanyDTO::fromCompany)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCompanyById(long id) {
        companyRepository.deleteById(id);
    }

    @Transactional
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = companyRepository.save(CompanyDTO.fromCompanyDTO(companyDTO));
        return CompanyDTO.fromCompany(company);
    }

    @Transactional
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        Company company = companyRepository.getOne(companyDTO.getId());
        companyRepository.saveAndFlush(company);
        return CompanyDTO.fromCompany(company);
    }

    public CompanyDTO getCompanyId(long companyId) {
        return CompanyDTO.fromCompany(companyRepository.getCompanyById(companyId));
    }

    public CompanyDTO getByCompanyName(String companyName) {
        return CompanyDTO.fromCompany(companyRepository.getCompanyByName(companyName));
    }
}
