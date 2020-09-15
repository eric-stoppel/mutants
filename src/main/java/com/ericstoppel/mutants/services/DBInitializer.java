package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.Dna;
import com.ericstoppel.mutants.repositories.DnaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class DBInitializer implements CommandLineRunner {

    public DBInitializer(DnaRepository dnaRepository, DnaService dnaService){
        this.dnaRepository = dnaRepository;
        this.dnaService = dnaService;
    }

    private DnaRepository dnaRepository;
    private DnaService dnaService;

    @Override
    public void run(String... args) {
        dnaRepository.deleteAll();

    }
}
