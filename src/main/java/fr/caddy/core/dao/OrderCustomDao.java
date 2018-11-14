package fr.caddy.core.dao;

import fr.caddy.common.bean.Order;
import fr.caddy.common.bean.Product;

import java.util.List;

public interface OrderCustomDao {

    public List<Order> findByIdProductInstance(Long id);
}
