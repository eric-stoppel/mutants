package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.Dna;
import com.ericstoppel.mutants.model.dtos.MutantStatsDto;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class MutantStatService {

    public MutantStatService(DnaService dnaService){
        this.dnaService = dnaService;
    }

    private DnaService dnaService;

    public MutantStatsDto fetchMutantVerificationStats(){
        LinkedList<Dna> dnaLinkedList = dnaService.findAll();
        long mutantDnas = dnaLinkedList
                .stream()
                .filter(Dna::isMutant)
                .count();

        double ratio = (double) mutantDnas / dnaLinkedList.size();
        return new MutantStatsDto(mutantDnas, dnaLinkedList.size(), ratio);
    }
}
