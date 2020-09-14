package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.exceptions.InvalidDnaSequenceException;
import com.ericstoppel.mutants.repositories.DnaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MutantServiceTest {

    @Autowired
    private MutantService mutantService;

    @Autowired
    private DnaService dnaService;

    final String[] dnaMutantArray = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    final String[] dnaNotMutantArray = {"TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CGCCTA", "TCACTG"};
    final String[] dnaInvalidArray = {"TTGCGA", "CAGTGC", "TTATGT", "AGAAXG", "CGCCTA", "TCACTG"};

    @Test
    void isMutantIncorrectArray() {
        int a = 0;
    }


    @Test
    void isMutantEmptyArray() {
    }


    @Test
    void whenGivenValidArrary_isMutant_expectToBeTrueAndSaved() {
        long numberOfDnas = dnaService.findAll().size();
        boolean isMutant = mutantService.isMutant(dnaMutantArray);
        assertEquals(dnaService.findAll().size(),numberOfDnas +1);
        assertTrue(isMutant);
    }

    @Test
    void whenGivenValidArrary_isNotMutant_expectToBeFalseAndSaved() {
        long numberOfDnas = dnaService.findAll().size();
        boolean isMutant = mutantService.isMutant(dnaNotMutantArray);
        assertEquals(dnaService.findAll().size(),numberOfDnas +1);
        assertFalse(isMutant);
    }

    @Test
    void whenGivenInvalidArrary_expectToThrowException() {
        assertThrows(InvalidDnaSequenceException.class, () -> mutantService.isMutant(dnaInvalidArray));
    }
}