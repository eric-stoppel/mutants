package com.ericstoppel.mutants.repositories;

import com.ericstoppel.mutants.model.Dna;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DnaRepository extends MongoRepository<Dna, Long> {
}
