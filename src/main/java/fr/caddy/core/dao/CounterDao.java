package fr.caddy.core.dao;

import fr.caddy.core.dao.helper.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CounterDao {
    @Autowired
    private MongoOperations mongo;

    public Long getNextSequence(String collectionName) {

        Counter counter = mongo.findAndModify(
                Query.query(Criteria.where("_id").is(collectionName)),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true),
                Counter.class);

        return Long.valueOf(counter.getSeq());
    }
}
