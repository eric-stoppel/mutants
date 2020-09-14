package com.ericstoppel.mutants.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;


@Document(collection = "dnas")
@Setter
@Getter
@AllArgsConstructor
public class Dna {
    @Transient
    public static final String SEQUENCE_NAME = "dna_sequence";

    @Id
    private Long dnaId;

    private boolean isMutant;
    private List<String> dnas;

    protected Dna(){}

    public Dna(Long id){
        this.dnaId = id;
    }

    public void addDna(String dna){
        this.dnas.add(dna);
    }

    public static Dna createDna(String[] dna){
        Dna newDna = new Dna();
        newDna.dnas = Arrays.asList(dna);
        return newDna;
    }

    @Override
    public String toString() {
        return "Dna{" +
                "dnaId=" + dnaId +
                ", isMutant=" + isMutant +
                ", dnas=" + dnas +
                '}';
    }
}
