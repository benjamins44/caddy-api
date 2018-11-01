package fr.caddy.core.service;

import fr.caddy.common.bean.PreOrder;

import java.util.List;

public interface PreOrderService {

    public List<PreOrder> getAll(String customer);

    /**
     * Get product by id
     * @param id
     * @return
     */
    public PreOrder getById(Long id);

    /**
     * Add product in preOrder with statistics
     * @param customer
     * @return
     */
    public PreOrder prepareOrder(String customer);

    /**
     * Create new preOrder
     * @param preOrder
     * @return
     */
    public PreOrder create(PreOrder preOrder);


}
