package com.ericstoppel.mutants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
@AllArgsConstructor
public class HumanDnaDto {

    @NonNull
    private String[] dna;
}
