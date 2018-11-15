package fr.caddy.core.dao;

import fr.caddy.common.bean.ProductsGrouping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsGroupingDao extends MongoRepository<ProductsGrouping, Long> {

    public Optional<ProductsGrouping> findByCategories(List<String> categories);
}
