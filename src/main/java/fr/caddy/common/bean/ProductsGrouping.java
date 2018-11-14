package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsGrouping {

    public static final String COLLECTION_NAME = "ProductsGrouping";

    @Id
    protected Long id;
    protected LocalDate date;
    protected String categories;
    protected List<ProductInstance> productInstance = new ArrayList<>();
    protected List<ProductInstance> bestProductInstance = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public List<ProductInstance> getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(List<ProductInstance> productInstance) {
        this.productInstance = productInstance;
    }

    public List<ProductInstance> getBestProductInstance() {
        return bestProductInstance;
    }

    public void setBestProductInstance(List<ProductInstance> bestProductInstance) {
        this.bestProductInstance = bestProductInstance;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, date=%s, categories='%s', productInstance=%s, bestProductInstance=%s ]",
                COLLECTION_NAME, id, date, categories, productInstance, bestProductInstance);
    }
}
