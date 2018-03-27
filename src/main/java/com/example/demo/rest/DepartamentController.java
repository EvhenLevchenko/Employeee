package com.example.demo.rest;


import com.example.demo.dto.DepartamentDTO;
import com.example.demo.service.DepartamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departaments")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartamentController {
    private final DepartamentService departamentService;

    @GetMapping
    public List<DepartamentDTO> getAll() {
        return departamentService.getAll();
    }

    @PostMapping
    public ResponseEntity<DepartamentDTO> add(@RequestBody DepartamentDTO departamentDTO) {
        DepartamentDTO departamentDTO1 = departamentService.add(departamentDTO);
        return ResponseEntity.ok(departamentDTO1);
    }

    @PutMapping
    public ResponseEntity<DepartamentDTO> update(@RequestBody DepartamentDTO departamentDTO) {
        DepartamentDTO departamentDTO1 = departamentService.update(departamentDTO);
        return ResponseEntity.ok(departamentDTO1);
    }

    @DeleteMapping("/{departament_id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "departament_id") long departamentId) {
        try {
            departamentService.deleteDepartamentById(departamentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{departament_id}")
    public ResponseEntity<DepartamentDTO> getDepartamentById(@PathVariable(value = "departament_id") long departamentId) {
        return ResponseEntity.ok(departamentService.getDepartamentId(departamentId));
    }

    @GetMapping("/{departament_name}")
    public ResponseEntity<DepartamentDTO> getDepartamentByModel(@PathVariable(value = "departament_name") String departamentName) {
        return ResponseEntity.ok(departamentService.getByDepartamentName(departamentName));
    }
}
