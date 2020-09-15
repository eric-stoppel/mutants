package com.ericstoppel.mutants.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Getter
@NoArgsConstructor
public class HumanDnaDto {

    @NonNull
    private String[] dna;
}
