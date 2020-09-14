package com.ericstoppel.mutants.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void whenGivenNotSquaredArray_expectToThrowException() {
        String[] seq = {"bbb", "aaa"};
        assertThrows(RuntimeException.class, () -> Util.convertStringArrayToMatrixOfChar(seq));
    }

    @Test
    void whenGivenSquaredArray_expectToRetrieveASquaredMatrixOfSameSize() {
        String[] seq = {"bbb", "aaa", "ccc"};
        char[][] matrix = Util.convertStringArrayToMatrixOfChar(seq);

        assertEquals(matrix.length, seq.length);
        assertEquals(seq[0].charAt(0), 'b');
        assertEquals(seq[1].charAt(1), 'a');
        assertEquals(matrix[0].length, seq[0].length());
    }


    @Test
    void whenGivenEmptyArray_expectEmptyMatrix() {
        String[] seq = {};
        char[][] matrix = Util.convertStringArrayToMatrixOfChar(seq);
        assertEquals(matrix.length, 0);
    }
}