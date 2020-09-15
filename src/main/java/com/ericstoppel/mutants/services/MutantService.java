package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.exceptions.InvalidDnaSequenceException;
import com.ericstoppel.mutants.utils.DnaSequenceValidator;
import com.ericstoppel.mutants.utils.MatrixHelper;
import com.ericstoppel.mutants.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class MutantService {

    public MutantService(DnaService dnaService){
        this.dnaService = dnaService;
    }

    @Value("${mutant.sequences.number}")
    private Integer MUTANT_SEQUENCES_REQUIRED;

    @Value("${mutant.sequences.length}")
    private Integer LENGTH_OF_MUTANT_SEQUENCE;

    private DnaService dnaService;

    public boolean isMutant(String[] dna){
        log.info("Processing dna: "+dna.toString());
        if(!validDnaSequence(dna)){
            String message = "Dna sequence is invalid because of one of the following reasons:  " +
                                "1. Array is empty " +
                                "2. Dna is not squared " +
                                "3. It contains invalid nitrogen Bases";
            log.warn(message);
            throw new InvalidDnaSequenceException(message);
        }

        int amountOfSequences = getNumberOfSequencesOfLength(LENGTH_OF_MUTANT_SEQUENCE, dna);
        boolean isMutant = amountOfSequences >= MUTANT_SEQUENCES_REQUIRED;
        dnaService.createAndSave(dna, isMutant);
        return isMutant;
    }

    private boolean validDnaSequence(String[] dna){
        DnaSequenceValidator validator = new DnaSequenceValidator();
        if (dna.length < 1) return false;
        boolean valid = Arrays.stream(dna).allMatch(validator::isValid);
        return Util.haveEqualLength(dna) && valid && dna[0].length() == dna.length;
    }

    private int getNumberOfSequencesOfLength(int n, String[] dna){
        log.info("Get number of dna sequences, size of sequence to be mutant "+MUTANT_SEQUENCES_REQUIRED);
        char[][] dnaMatrix = Util.convertStringArrayToMatrixOfChar(dna);
        int rowSequences = MatrixHelper.numberOfRowSequencesOfSize(dnaMatrix, n);
        int columnSequences = MatrixHelper.numberOfColumnSequencesOfSize(dnaMatrix, n);
        int diagonalSequences = MatrixHelper.numberOfDiagonalSequencesOfSize(dnaMatrix, n);
        int total = rowSequences + columnSequences + diagonalSequences;
        log.info("Total sequences found: "+total);

        return total;
    }



}
