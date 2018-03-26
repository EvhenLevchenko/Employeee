package com.example.demo.repository;
import com.example.demo.BaseDomainTest;
import com.example.demo.domain.Departament;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartamenRepositoryTest extends BaseDomainTest {
    @Autowired
    private DepartamentRepository departamentRepository;

    @Test
    public void findAll() {
        List<Departament> all = departamentRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    public void getByName() {
        Departament departament = departamentRepository.getDepartamentByName("Departament");
        assertThat(departament).isNotNull();
    }

    @Test
    public void getById(){
        Departament departament = departamentRepository.getDepartamentById(departamentRepository.findAll().get(0).getId());
        assertThat(departament).isNotNull();
    }

    @Test
    public void add(){
        int initial = departamentRepository.findAll().size();
        departamentRepository.save(Departament.builder().name("Departament").build());
        int finish = departamentRepository.findAll().size();
        assertThat(initial).isLessThan(finish);
    }

    @Test
    public void delete(){
        int initial = departamentRepository.findAll().size();
        departamentRepository.deleteById(departamentRepository.findAll().get(0).getId());
        int finish = departamentRepository.findAll().size();
        assertThat(initial).isGreaterThan(finish);
    }
}
