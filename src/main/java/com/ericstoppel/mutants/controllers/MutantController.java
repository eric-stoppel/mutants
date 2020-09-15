package com.ericstoppel.mutants.controllers;

import com.ericstoppel.mutants.exceptions.InvalidDnaSequenceException;
import com.ericstoppel.mutants.model.dtos.ApiResponse;
import com.ericstoppel.mutants.model.dtos.HumanDnaDto;
import com.ericstoppel.mutants.model.dtos.MutantStatsDto;
import com.ericstoppel.mutants.services.MutantService;
import com.ericstoppel.mutants.services.MutantStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(MutantController.URL_MAPPING)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class MutantController {
    public static final String URL_MAPPING = "/mutant";

    public MutantController(MutantService mutantService, MutantStatService mutantStatService){
        this.mutantService = mutantService;
        this.mutantStatService = mutantStatService;
    }

    private MutantService mutantService;
    private MutantStatService mutantStatService;

    @PostMapping
    public ResponseEntity<?> detectMutant(@RequestBody @Validated HumanDnaDto user) {

        try {
            if (mutantService.isMutant(user.getDna()))
                return ResponseEntity.ok(ApiResponse.builder().body("the dna provided is mutant").build());
        }catch (InvalidDnaSequenceException ex){
            log.warn("Invalid call of endpoint /mutant, the dna provided is invalid");
            return ResponseEntity.badRequest().body(ApiResponse.error().setBody(ex.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error().setBody("the dna provided is not mutant"));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/stats")
    public ApiResponse getMutantStats() {
        return ApiResponse.builder().body(mutantStatService.fetchMutantVerificationStats()).build();
    }
}
