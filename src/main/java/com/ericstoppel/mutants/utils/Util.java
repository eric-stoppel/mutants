package com.ericstoppel.mutants.utils;

import java.util.Arrays;

public class Util {
    public static char[][] convertStringArrayToMatrixOfChar(String[] array ){
        if (array.length == 0) return new char[0][0];

        if (!haveEqualLength(array) || array[0].length() != array.length) throw new RuntimeException("Cannot convert from array to matrix because it is not squared");
        int arrayLength = array.length;
        char matrix[][] = new char[arrayLength][arrayLength];

        for (int i = 0; i < arrayLength; i++){
            for (int j = 0; j < arrayLength; j++){
                matrix[i][j] = array[i].charAt(j);
            }
        }
        return matrix;
    }

    public static boolean haveEqualLength(String[] array){
        if (array.length == 0) return true;
        return Arrays.stream(array).allMatch(seq -> seq.length() == array[0].length());
    }
}
