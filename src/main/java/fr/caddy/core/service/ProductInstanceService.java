package fr.caddy.core.service;

import fr.caddy.common.bean.HistoryOrderProduct;
import fr.caddy.common.bean.ProductInstance;

import java.util.List;

public interface ProductInstanceService {
    /**
     * Return the product instance of the history order product
     * Save it if not exists
     * @param historyOrderproduct
     * @return
     */
    public ProductInstance getOrSave(HistoryOrderProduct historyOrderproduct, String sign);
    /**
     * Refresh informations from openfodofact
     * @param productInstance
     */
    public Integer refresh(ProductInstance productInstance);
    /**
     * Refresh product instance and all depedencies
     * @param productInstance
     */
    public void refreshAndUpdateDepedencies(ProductInstance productInstance);

    /**
     * Return all products instance
     * @return
     */
    public List<ProductInstance> getAll();

    /**
     * Return all products instance like label
     * @return
     */
    public List<ProductInstance> getByLabeLike(String label);

    /**
     * Get products instance by id
     * @param id
     * @return
     */
    public ProductInstance getById(Long id);

    /**
     * Update productInstance
     * @param productInstance
     */
    public ProductInstance update(ProductInstance productInstance);

    /**
     * Create productInstance
     * @param productInstance
     */
    public ProductInstance create(ProductInstance productInstance);
    /**
     * Delete productInstance
     * @param productInstance
     */
    public void delete(ProductInstance productInstance);

}
