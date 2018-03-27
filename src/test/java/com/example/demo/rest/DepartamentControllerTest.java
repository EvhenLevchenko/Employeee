package com.example.demo.rest;

import com.example.demo.dto.DepartamentDTO;
import com.example.demo.service.DepartamentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(DepartamentController.class)
@ComponentScan
public class DepartamentControllerTest {

    private final String Departament_URL ="/departaments";

    @MockBean
    private CompanyController companyController;
    @MockBean
    private EmployeeController employeeController;
    @MockBean
    private CarController carController;
    @MockBean
    private DepartamentService departamentService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private DepartamentDTO departamentDTO = createUniqueDepartamentDTO();
    private DepartamentDTO departamentDTO1 = createUniqueDepartamentDTO();

    @Before
    public void setUp() throws Exception {
        when(departamentService.getAll()).thenReturn(Arrays.asList(departamentDTO, departamentDTO1));
    }

    private DepartamentDTO createUniqueDepartamentDTO() {
        return DepartamentDTO.builder()
                .id(new Random().nextInt())
                .name(UUID.randomUUID().toString())
                .build();
    }

    @Test
    public void getAll() throws Exception {
        String result = objectMapper.writeValueAsString(Arrays.asList(departamentDTO, departamentDTO1));

        mvc.perform(get(Departament_URL)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    public void addDepartament() throws Exception {
        String requestBody = objectMapper.writeValueAsString(departamentDTO);

        mvc.perform(post(Departament_URL)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteDepartament() throws Exception {
        mvc.perform(delete(Departament_URL + "/" + departamentDTO.getId()))
                .andExpect(status().isOk());
    }
}
