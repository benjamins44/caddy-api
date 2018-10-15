package fr.caddy.core.dao.impl;

import fr.caddy.common.bean.ProductInstance;
import fr.caddy.core.dao.ProductInstanceCustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ProductInstanceCustomDaoImpl implements ProductInstanceCustomDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<ProductInstance> findByIdExtAndSign(Long idExt, String sign) {
        final Query query = new Query(Criteria.where("productShops.id").is(idExt)
                  .and("productShops.sign").is(sign));
        return mongoTemplate.find(query, ProductInstance.class);
    }

}
