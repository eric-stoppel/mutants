package com.ericstoppel.mutants.utils;

public class MatrixHelper {
    public static int numberOfRowSequencesOfSize(char[][] matrix, int size){
        if (size == 1) return matrix.length;
        int matrixLength = matrix.length;
        Integer total = 0;

        for (int i = 0; i < matrixLength; i++){
            int consecutives = 1;
            for (int j = 0; j < matrixLength; j++){
                if (j == matrixLength-1){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[i][j] == matrix[i][j+1]) {
                    consecutives++;
                }else{
                    //check if reached max
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }

    public static int numberOfColumnSequencesOfSize(char[][] matrix, int size){
        if (size == 1) return matrix.length;
        int matrixLength = matrix.length;
        int total = 0;

        for (int i = 0; i < matrixLength; i++){
            int consecutives = 1;
            for (int j = 0; j < matrixLength; j++){
                if (j == matrixLength-1){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[j][i] == matrix[j+1][i]) {
                    consecutives++;
                }else{
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }

    public static int numberOfDiagonalSequencesOfSize(char[][] matrix, int size){
        if (size == 1) return matrix.length;
        return superiorDiagonal(matrix, size)
                + inferiorDiagonal(matrix, size)
                + superiorDiagonalReverseOrder(matrix, size)
                + inferiorDiagonalReverseOrder(matrix, size)
                + diagonals(matrix, size);
    }

    public static int diagonals(char[][] matrix, int size){
        int matrixLength = matrix.length;
        int total = 0;

        int consecutives = 1;
        for (int i = 0; i < matrixLength; i++ ){
            if(i != matrixLength -1 && matrix[i][i] == matrix[i+1][i+1]){
                consecutives++;
            }else{
                if (consecutives >= size)
                    total++;
                consecutives=1;
            }
        }

        consecutives = 1;
        for (int i = matrixLength-1; i >= 0; i-- ){
            if(i != 0 && matrix[i][matrixLength-1-i] == matrix[i-1][matrixLength-i]){
                consecutives++;
            }else{
                if (consecutives >= size)
                    total++;
                consecutives=1;
            }
        }

        return total;
    }

    private static int superiorDiagonal(char[][] matrix, int size){
        int matrixLength = matrix.length;
        int total = 0;

        //find superior part
        for (int j = 1; j < matrixLength; j++){
            int consecutives = 1;
            if (j == matrixLength-1) continue;

            for (int i = 0; i < matrixLength-j; i++){
                if (i+j == matrixLength -1 ){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[i][j+i] == matrix[i+1][j+i+1]){
                    consecutives++;
                }else{
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }

    private static int inferiorDiagonal(char[][] matrix, int size){
        int matrixLength = matrix.length;
        int total = 0;

        //find superior part
        for (int j = 1; j < matrixLength; j++){
            int consecutives = 1;
            if (j == matrixLength-1) continue;

            for (int i = 0; i < matrixLength-j; i++){
                if (i+j == matrixLength -1 ){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[j+i][i] == matrix[j+i+1][i+1]){
                    consecutives++;
                }else{
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }

    private static int superiorDiagonalReverseOrder(char[][] matrix, int size){
        int matrixLength = matrix.length;
        int total = 0;

        //find superior part
        for (int j = 1; j < matrixLength; j++){
            int consecutives = 1;
            if (j == matrixLength-1) continue;
            //hasta aca es igual
            for (int i = matrixLength-1; i >= 0+j; i--){
                if (j+matrixLength-1-i == matrixLength-1){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[i][j+matrixLength-1-i] == matrix[i-1][j+matrixLength-i]){
                    consecutives++;
                }else{
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }

    private static int inferiorDiagonalReverseOrder(char[][] matrix, int size){
        int matrixLength = matrix.length;
        int total = 0;

        //find superior part
        for (int j = 1; j < matrixLength; j++){
            int consecutives = 1;
            if (j == matrixLength-1) continue;
            //hasta aca es igual
            for (int i = matrixLength-1-j; i >= 0; i--){
                if (i == 0){
                    if (consecutives >= size)
                        total++;
                    continue;
                }

                if (matrix[i][matrixLength-1-j-i] == matrix[i-1][matrixLength-j-i]){
                    consecutives++;
                }else{
                    if (consecutives >= size)
                        total++;
                    consecutives = 1;
                }
            }
        }
        return total;
    }



}
