package com.ericstoppel.mutants.controllers;

import com.ericstoppel.mutants.exceptions.InvalidDnaSequenceException;
import com.ericstoppel.mutants.services.MutantService;
import com.ericstoppel.mutants.services.MutantStatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MutantControllerTest {

    @InjectMocks
    MutantController mutantController;

    @Mock
    MutantService mutantService;

    @Mock
    MutantStatService mutantStatService;


    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mutantController).build();
    }

    String dnaRequest = "{ \"dna\": [ \"GTGCAA\",\"CAGTGC\"] }";

    @Test
    void whenPostMutant_withMutantDna_expect200AndStatusSuccess() throws Exception {
        Mockito.doReturn(true).when(mutantService).isMutant(Mockito.any(String[].class));

        mockMvc.perform(MockMvcRequestBuilders
                .post(MutantController.URL_MAPPING)
                .content(dnaRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void whenPostMutant_withNonMutantDna_expect403AndStatusError() throws Exception{
        Mockito.doReturn(false).when(mutantService).isMutant(Mockito.any(String[].class));

        mockMvc.perform(MockMvcRequestBuilders
                .post(MutantController.URL_MAPPING)
                .content(dnaRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    void whenPostMutant_InvalidDna_expect400AndStatusError() throws Exception{
        Mockito.doThrow(InvalidDnaSequenceException.class).when(mutantService).isMutant(Mockito.any(String[].class));

        mockMvc.perform(MockMvcRequestBuilders
                .post(MutantController.URL_MAPPING)
                .content(dnaRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getMutantStats() {
    }
}