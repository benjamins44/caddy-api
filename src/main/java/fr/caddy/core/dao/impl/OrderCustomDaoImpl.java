package fr.caddy.core.dao.impl;

import fr.caddy.common.bean.Order;
import fr.caddy.common.bean.Product;
import fr.caddy.core.dao.OrderCustomDao;
import fr.caddy.core.dao.ProductCustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.regex.Pattern;

public class OrderCustomDaoImpl implements OrderCustomDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Order> findByIdProductInstance(Long id) {
        final Query query = new Query(Criteria.where("products.favorite.id").is(id));
        return mongoTemplate.find(query, Order.class);
    }

}
