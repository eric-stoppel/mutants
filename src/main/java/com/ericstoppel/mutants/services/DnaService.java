package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.Dna;
import com.ericstoppel.mutants.repositories.DnaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
@Slf4j
public class DnaService {

    public DnaService(DnaRepository dnaRepository,
                      NextSequenceService nextSequenceService){
        this.dnaRepository = dnaRepository;
        this.nextSequenceService = nextSequenceService;
    }

    private DnaRepository dnaRepository;
    private NextSequenceService nextSequenceService;

    public Dna save(Dna dna){
        log.info("Saving a new dna: "+dna.toString());
        return dnaRepository.save(dna);
    }

    public LinkedList<Dna> findAll(){
        return new LinkedList<>(dnaRepository.findAll());
    }

    public Dna createAndSave(String[] dna, boolean isMutant){
        Dna newDna = Dna.createDna(dna);
        newDna.setMutant(isMutant);
        newDna.setDnaId(nextSequenceService.getNextSequence(Dna.SEQUENCE_NAME));
        return this.save(newDna);
    }

    public void deleteAll(){
        dnaRepository.deleteAll();
    }
}
