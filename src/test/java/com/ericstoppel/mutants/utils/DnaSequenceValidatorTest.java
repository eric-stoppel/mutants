package com.ericstoppel.mutants.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DnaSequenceValidatorTest {

    DnaSequenceValidator sequenceValidator = new DnaSequenceValidator();
    @Test
    void whenGivenValidSequence_thenReturnTrue() {
        Assertions.assertTrue(sequenceValidator.isValid("GGGG"));
    }

    @Test
    void whenGivenInvalidSequence_thenReturnFalse() {
        assertFalse(sequenceValidator.isValid("TACGO"));
    }

    @Test
    void whenGivenEmptyArray_thenReturnFalse() {
        assertFalse(sequenceValidator.isValid(""));
    }
}