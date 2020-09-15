package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.Dna;
import com.ericstoppel.mutants.model.dtos.MutantStatsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@Slf4j
public class MutantStatService {

    public MutantStatService(DnaService dnaService){
        this.dnaService = dnaService;
    }

    private DnaService dnaService;

    public MutantStatsDto fetchMutantVerificationStats(){
        log.info("Fetch mutant stats");
        LinkedList<Dna> dnaLinkedList = dnaService.findAll();
        long mutantDnas = dnaLinkedList
                .stream()
                .filter(Dna::isMutant)
                .count();

        double ratio = 0;
        if (dnaLinkedList.size() > 0)
            ratio = (double) mutantDnas / dnaLinkedList.size();

        return new MutantStatsDto(mutantDnas, dnaLinkedList.size(), ratio);
    }
}
