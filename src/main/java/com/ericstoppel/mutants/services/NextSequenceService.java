package com.ericstoppel.mutants.services;

import com.ericstoppel.mutants.model.Sequence;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NextSequenceService {

    public NextSequenceService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    private MongoOperations mongoOperations;

    public long getNextSequence(String seqName)
    {
        Sequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("sequence",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);

        return counter.getSequence();
    }
}
