package fr.caddy.core.service;

import fr.caddy.common.bean.ProductsGrouping;

import java.util.List;
import java.util.Optional;

public interface ProductsGroupingService {

    public List<ProductsGrouping> getAll();
    public ProductsGrouping getById(Long id);
    public Optional<ProductsGrouping> getByCategories(String categories);
    public ProductsGrouping update(ProductsGrouping productsGrouping);
    public void delete(ProductsGrouping productsGrouping);
    public List<ProductsGrouping> save(List<ProductsGrouping> productsGroupings);
    public ProductsGrouping save(ProductsGrouping productsGrouping);
    public ProductsGrouping create(ProductsGrouping productsGrouping);
    public void deleteAll();
    public void autoCreateAll();

}
