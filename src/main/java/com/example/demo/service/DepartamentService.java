package com.example.demo.service;


import com.example.demo.domain.Departament;
import com.example.demo.dto.DepartamentDTO;
import com.example.demo.repository.DepartamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartamentService {


    private DepartamentRepository departamentRepository;

    public List<DepartamentDTO> getAllDepartaments() {
        return departamentRepository.findAll().stream()
                .map(DepartamentDTO::fromDepartament)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteDepartamentById(long id) {
        departamentRepository.deleteById(id);
    }

    @Transactional
    public DepartamentDTO addDepartament(DepartamentDTO departamentDTO) {
        Departament departament = departamentRepository.save(DepartamentDTO.fromDepartamentDTO(departamentDTO));
        return DepartamentDTO.fromDepartament(departament);
    }

    @Transactional
    public DepartamentDTO updateDepartament(DepartamentDTO departamentDTO) {
        Departament departament = departamentRepository.getOne(departamentDTO.getId());
        departamentRepository.saveAndFlush(departament);
        return DepartamentDTO.fromDepartament(departament);
    }

    public DepartamentDTO getDepartamentId(long departamentId) {
        return DepartamentDTO.fromDepartament(departamentRepository.getDepartamentById(departamentId));
    }

    public DepartamentDTO getByDepartamentName(String departamentName) {
        return DepartamentDTO.fromDepartament(departamentRepository.getDepartamentByName(departamentName));
    }
}
