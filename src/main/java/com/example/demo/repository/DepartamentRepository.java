package com.example.demo.repository;

import com.example.demo.domain.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
    Departament getDepartamentById(long id);
    Departament getDepartamentByName(String name);
}
