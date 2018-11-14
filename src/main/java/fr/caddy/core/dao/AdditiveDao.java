package fr.caddy.core.dao;

import fr.caddy.common.bean.Additives;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdditiveDao extends MongoRepository<Additives, ObjectId> {

    public Optional<Additives> findByCodeIgnoreCase(String code);
}
