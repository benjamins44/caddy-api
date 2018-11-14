package fr.caddy.core.service;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.common.bean.Order;
import fr.caddy.common.bean.Product;
import fr.caddy.common.bean.ProductInstance;

import java.util.List;

public interface OrderService {

    public Order getOrSave(HistoryOrder historyOrder);

    public List<Order> getOrSave(List<HistoryOrder> historyOrders);

    public List<Order> getNewOrders(String customer, final String password);

    public List<Order> getAll(String customer);

    /**
     * Get product by id
     * @param id
     * @return
     */
    public Order getById(Long id);
    public void refreshProductInstance(ProductInstance productInstance);

}
