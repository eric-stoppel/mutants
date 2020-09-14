package com.ericstoppel.mutants.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixHelperTest {
    @Test
    void numberOfRowSequencesOfSize_MatrixWith5Consecutives_expectResultToBe5() {
        final char[][] matrix = {
                { 'T', 'T', 'T', 'T' },
                { 'A', 'B', 'B', 'B' },
                { 'C', 'C', 'A', 'A' },
                { 'C', 'A', 'C', 'C'}
        };
        int seq = MatrixHelper.numberOfRowSequencesOfSize(matrix, 2);
        Assertions.assertEquals(5, seq);
    }

    @Test
    void numberOfColumnSequencesOfSize_MatrixWith5Consecutives_expectResultToBe5() {
        final char[][] matrix = {
                { 'T', 'C', 'T', 'T' },
                { 'T', 'C', 'B', 'T' },
                { 'C', 'A', 'B', 'T' },
                { 'C', 'B', 'B', 'T'}
        };
        int seq = MatrixHelper.numberOfColumnSequencesOfSize(matrix, 2);
        Assertions.assertEquals(5, seq);
    }

    @Test
    void numberOfDiagonalSequencesOfSize_MatrixWith7Consecutives_expectResultToBe7() {
        final char[][] matrix = {
                { 'T', 'T', 'T', 'T', 'T' },
                { 'A', 'B', 'B', 'B', 'T' },
                { 'C', 'C', 'B', 'A', 'T' },
                { 'C', 'A', 'C', 'C', 'T'},
                { 'C', 'A', 'C', 'C', 'C'}
        };

        int seq = MatrixHelper.numberOfDiagonalSequencesOfSize(matrix, 2);
        Assertions.assertEquals(7, seq);
    }

}