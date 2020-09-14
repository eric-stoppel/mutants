package com.ericstoppel.mutants.utils;

public class DnaSequenceValidator {
    char[] validChars = {'T', 'A', 'C', 'G'};

    public boolean isValid(String sequence){
        if (sequence.isBlank()) return false;
        return sequence
                .chars()
                .mapToObj(i -> (char)i)
                .allMatch(this::isValidNitrogenBase);
    }

    private boolean isValidNitrogenBase(char c){
        return new String(validChars).indexOf(c) != -1;
    }
}
