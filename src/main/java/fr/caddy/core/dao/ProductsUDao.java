package fr.caddy.core.dao;


import fr.caddy.common.bean.opendfoodfact.ProductsU;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ProductsUDao extends MongoRepository<ProductsU, Long>, ProductCustomDao {

    public Optional<ProductsU> findByCode(String code);

}
