package fr.caddy.core.dao;

import fr.caddy.common.bean.Product;
import fr.caddy.common.bean.ProductInstance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductInstanceDao extends MongoRepository<ProductInstance, Long>, ProductInstanceCustomDao {

    public Product findByOpenFoodFactId(Long openFoodFactId);

    public List<ProductInstance> findByLabelContainingIgnoreCase(String likeLabel);

}
