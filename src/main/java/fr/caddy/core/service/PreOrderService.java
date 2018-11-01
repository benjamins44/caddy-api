package fr.caddy.core.service;

import fr.caddy.common.bean.PreOrder;
import fr.caddy.common.bean.PreOrder;

import java.util.List;

public interface PreOrderService {

    public List<PreOrder> getAll(String customer);

    /**
     * Get preOrder by id
     * @param id
     * @return
     */
    public PreOrder getById(Long id);

    /**
     * Add preOrder in preOrder with statistics
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

    /**
     * Get last preorder of a customer
     * @param customer
     * @return
     */
    public PreOrder getLastByCustomer(String customer);
    /**
     * Update PreOrder
     * @param preOrder
     */
    public PreOrder update(PreOrder preOrder);

    /**
     * Delete preOrderInstance
     * @param preOrder
     */
    public void delete(PreOrder preOrder);


    public List<PreOrder> save(List<PreOrder> preOrders);

    public PreOrder save(PreOrder preOrder);
}
