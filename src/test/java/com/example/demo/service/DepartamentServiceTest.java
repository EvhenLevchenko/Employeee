package com.example.demo.service;

import com.example.demo.BaseDomainTest;
import com.example.demo.dto.DepartamentDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class DepartamentServiceTest extends BaseDomainTest {
    @Autowired
    private  DepartamentService departamentService;

    @Test
    public void add(){
        int initial=  departamentService.getAllDepartaments().size();
        departamentService.addDepartament(DepartamentDTO.builder().name("Departament").build());
        int finish = departamentService.getAllDepartaments().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void getById() {
        DepartamentDTO departamentDTO = departamentService.getDepartamentId(departamentService.getAllDepartaments().get(0).getId());
        assertThat(departamentDTO).isNotNull();
    }

    @Test
    public void getAll() {
        assertThat(departamentService.getAllDepartaments()).hasSize(1);
    }

    @Test
    public void getByName() {
        DepartamentDTO departamentDTO = departamentService.getByDepartamentName(departamentService.getByDepartamentName("Departament").getName());
        assertThat(departamentDTO).isNotNull();
    }

    @Test
    public void delete() {
        int initial = departamentService.getAllDepartaments().size();
        departamentService.deleteDepartamentById(departamentService.getAllDepartaments().get(0).getId());
        int finish = departamentService.getAllDepartaments().size();
        assertThat(initial).isGreaterThan(finish);
    }
}