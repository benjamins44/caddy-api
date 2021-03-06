package fr.caddy.core.service;

import fr.caddy.common.bean.Order;
import fr.caddy.common.bean.Product;
import fr.caddy.common.bean.ProductInstance;

import java.util.List;

public interface ProductService {
    /**
     * Return the product of the product instance
     * Save it if not exists
     * @param productInstance
     * @return
     */
    public Product getOrSave(ProductInstance productInstance, String customer);

    public List<Product> getOrSave(List<ProductInstance> productInstance, String customer);

    public List<Product> getAll(String customer);

    public List<Product> getAll();

    /**
     * Return all products like label
     * @return
     */
    public List<Product> getByLabelLike(String label);

    /**
     * Get product by id
     * @param id
     * @return
     */
    public Product getById(Long id);

    /**
     * Update ProductsU
     * @param product
     */
    public Product update(Product product);

    /**
     * Create productInstance
     * @param product
     */
    public Product create(Product product);
    /**
     * Delete productInstance
     * @param product
     */
    public void delete(Product product);


    public void save(List<Product> products);

    /**
     * Refresh product instance of all products
     * @param productInstance
     */
    public void refreshProductInstance(ProductInstance productInstance);
    /**
     * Calculate Consumptions with orders
     */
    public List<Product> calculateConsumptionsOfOrders(List<Order> orders);
    public List<Product> calculateConsumptions(List<Product> products);

    /**
     * Calculate Averages
     * @param product
     */
    public void calculateAverage(Product product);
    public void calculateAverage(List<Product> products);

    public void calculateProbabilities(List<Product> products);
    public void calculateProbabilities(Product product);

    public void calculateBestSubstitutes(Product product);

    public void refresh(Product product);
}
