package com.example.demo.rest;


import com.example.demo.dto.CarDTO;
import com.example.demo.service.CarService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartamentService;
import com.example.demo.service.EmployeeService;
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
@WebMvcTest(CarController.class)
@ComponentScan
public class CarControllerTest    {

    private final String CAR_URL = "/cars";


    @MockBean
    private CompanyService companyService;

    @MockBean
    private DepartamentService departamentService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private CarService carService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private CarDTO firstCarDTO = createUniqueCarDTO();
    private CarDTO secondCarDTO = createUniqueCarDTO();

    @Before
    public void setUp() throws Exception {
        when(carService.getAllCars()).thenReturn(Arrays.asList(firstCarDTO, secondCarDTO));
    }

    private CarDTO createUniqueCarDTO() {
        return CarDTO.builder()
                .id(new Random().nextInt())
                .model(UUID.randomUUID().toString())
                .year(new Random().nextInt())
                .build();
    }

    @Test
    public void getAll() throws Exception {
        String result = objectMapper.writeValueAsString(Arrays.asList(firstCarDTO, secondCarDTO));

        mvc.perform(get(CAR_URL)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    public void addCar() throws Exception {
        String requestBody = objectMapper.writeValueAsString(firstCarDTO);

        mvc.perform(post(CAR_URL)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCar() throws Exception {
        mvc.perform(delete(CAR_URL + "/" + firstCarDTO.getId()))
                .andExpect(status().isOk());
    }
}
