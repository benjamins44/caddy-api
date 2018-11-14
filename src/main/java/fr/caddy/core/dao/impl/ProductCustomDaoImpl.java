package fr.caddy.core.dao.impl;

import fr.caddy.common.bean.Product;
import fr.caddy.core.dao.ProductCustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.regex.Pattern;

public class ProductCustomDaoImpl implements ProductCustomDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> findByIdProductInstance(Long id) {
        final Query query = new Query(Criteria.where("favorite.id").is(id));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> findByOrderIdAndProduct(Long orderId, Long productId) {
        final Query query = new Query(Criteria.where("id").is(productId)
            .and("consumption.dayQuantity.orderId").is(orderId));
        return mongoTemplate.find(query, Product.class);
    }

    @Override
    public List<Product> findByLabelContainingIgnoreCase(String likeLabel) {
        final Query query = new Query(Criteria.where("favorite.label")
                .regex(likeLabel)
                .regex( Pattern.compile(likeLabel, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
        return mongoTemplate.find(query, Product.class);
    }
}
