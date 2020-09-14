package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.dtos.MutantStatsDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MutantStatServiceTest {

    @Autowired
    private MutantStatService mutantStatService;

    @Autowired
    private DnaService dnaService;

    final String[] dnaMutantArray = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

    @BeforeEach
    public void setUp()
    {
        dnaService.deleteAll();
        createDnas();
    }

    @Test
    void fetchMutantVerificationStats() {
        MutantStatsDto dto = mutantStatService.fetchMutantVerificationStats();
        assertEquals(dto.getCountMutantDna(), 2);
        assertEquals(dto.getCountHumanDna(), 4);
        assertEquals(dto.getRatio(), 0.5);

    }

    private void createDnas(){
        dnaService.createAndSave(dnaMutantArray, true);
        dnaService.createAndSave(dnaMutantArray, true);
        dnaService.createAndSave(dnaMutantArray, false);
        dnaService.createAndSave(dnaMutantArray, false);
    }
}