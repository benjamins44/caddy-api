package fr.caddy.core.dao;

import fr.caddy.common.bean.Product;

import java.util.List;

public interface ProductCustomDao {

    public List<Product> findByIdProductInstance(Long id);

    public List<Product> findByOrderIdAndProduct(Long orderId, Long productId);

    public List<Product> findByLabelContainingIgnoreCase(String likeLabel);


}
