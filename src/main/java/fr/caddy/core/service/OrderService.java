package fr.caddy.core.service;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.common.bean.Order;

import java.util.List;

public interface OrderService {

    public Order getOrSave(HistoryOrder historyOrder);

    public List<Order> getOrSave(List<HistoryOrder> historyOrders);

    public List<Order> getNewOrders(String customer, final String password);

}
