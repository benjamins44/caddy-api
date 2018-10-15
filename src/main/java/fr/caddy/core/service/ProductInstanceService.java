package fr.caddy.core.service;

import fr.caddy.common.bean.HistoryOrderProduct;
import fr.caddy.common.bean.ProductInstance;

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
}
