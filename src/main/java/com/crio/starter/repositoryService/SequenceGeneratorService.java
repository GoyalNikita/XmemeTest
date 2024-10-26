package com.crio.starter.repositoryService;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Objects;

import com.crio.starter.data.DatabaseSequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * This function gets the document from the mongoDB collection named "database_sequences" which matches the given seqName and updates its sequenceNo field by increameting it by 1. This sequenceNo can then be used to assign the PostEntity its id while saving it in the database
     * @param seqName
     * @return the next sequenceNo
     */
    public long generateSequence(String seqName) {

        Query query = new Query(Criteria.where("id").is(seqName));
        DatabaseSequence counter = mongoTemplate.findAndModify(query, new Update().inc("sequenceNo", 1), FindAndModifyOptions.options().returnNew(true).upsert(true), DatabaseSequence.class, "database_sequences");
        return !Objects.isNull(counter) ? counter.getSequenceNo() : 1;
    }
}
