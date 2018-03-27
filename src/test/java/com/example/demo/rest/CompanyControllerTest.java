package com.example.demo.rest;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;
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
@WebMvcTest(CompanyController.class)
@ComponentScan
public class CompanyControllerTest {


    private final String COMPANY_URL = "/companies";

    @MockBean
    private EmployeeController employeeController;
    @MockBean
    private DepartamentController departamentController;
    @MockBean
    private CarController carController;

    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private CompanyDTO companyDTO = createUniqueCompanyDTO();
    private CompanyDTO companyDTO1 = createUniqueCompanyDTO();

    @Before
    public void setUp() throws Exception {
        when(companyService.getAll()).thenReturn(Arrays.asList(companyDTO, companyDTO1));
    }

    private CompanyDTO createUniqueCompanyDTO() {
        return CompanyDTO.builder()
                .id(new Random().nextInt())
                .name(UUID.randomUUID().toString())
                .size(new Random().nextInt())
                .build();
    }

    @Test
    public void getAll() throws Exception {
        String result = objectMapper.writeValueAsString(Arrays.asList(companyDTO, companyDTO1));

        mvc.perform(get(COMPANY_URL)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(result));}

        @Test
        public void addCompany()throws Exception{
            String requestBody = objectMapper.writeValueAsString(companyDTO);

            mvc.perform(post(COMPANY_URL)
                    .accept(APPLICATION_JSON)
                    .contentType(APPLICATION_JSON)
                    .content(requestBody))
                    .andExpect(status().isOk());
        }
        @Test
        public void deleteCompany() throws Exception {
            mvc.perform(delete(COMPANY_URL + "/" + companyDTO.getId()))
                    .andExpect(status().isOk());
        }

}
