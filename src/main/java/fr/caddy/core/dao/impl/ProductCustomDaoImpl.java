package fr.caddy.core.dao.impl;

import fr.caddy.common.bean.Product;
import fr.caddy.core.dao.ProductCustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ProductCustomDaoImpl implements ProductCustomDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> findByIdProductInstance(Long id) {
        final Query query = new Query(Criteria.where("productInstances.id").is(id));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> findByOrderIdAndProduct(Long orderId, Long productId) {
        final Query query = new Query(Criteria.where("id").is(productId)
            .and("consumption.dayQuantity.orderId").is(orderId));
        return mongoTemplate.find(query, Product.class);
    }
}
