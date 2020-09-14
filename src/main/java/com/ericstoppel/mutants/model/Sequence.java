package com.ericstoppel.mutants.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequences")
@Getter
public class Sequence {
    @Id
    private String id;

    private long sequence;
}
