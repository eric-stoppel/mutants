package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.repositories.DnaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DnaServiceTest {

    @Autowired
    private DnaService dnaService;



    @BeforeEach
    public void setUp() {
        dnaService.deleteAll();
    }

    @Test
    public void whenCreatingNewDna_expectToBeSaved() {
        String[] dna = {"TCBA", "TABC"};
        dnaService.createAndSave(dna, true);
        Assertions.assertEquals(dnaService.findAll().size(), 1);
    }


}