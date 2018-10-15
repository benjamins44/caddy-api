package fr.caddy.core.dao;

import fr.caddy.common.bean.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductDao extends MongoRepository<Product, Long>, ProductCustomDao {

    public List<Product> findByCustomer(String customer);

}
