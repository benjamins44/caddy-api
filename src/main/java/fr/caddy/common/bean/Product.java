
package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.web.SortDefault;

import java.util.List;

public class Product {

    public static final String COLLECTION_NAME = "Product";

    @Id
    private Long id;

    private String customer;

    private String type;

    private String family;

    private String category;

    private String dlc;

    private Float quantity;

    private ProductStatus status = ProductStatus.USED;

    private ProductOrderStatus orderStatus = ProductOrderStatus.NO_ORDER;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDlc() {
        return dlc;
    }
    public void setDlc(String dlc) {
        this.dlc = dlc;
    }


    private Consumption consumption;

    private List<ProductInstance> substitutes = null;

    private ProductInstance favorite = null;

    private List<ProductInstance> histories = null;

    private List<ProductInstance> bestSubstitutes = null;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consumption getConsumption() {
        return consumption;
    }

    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public ProductOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ProductOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public List<ProductInstance> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<ProductInstance> substitutes) {
        this.substitutes = substitutes;
    }

    public ProductInstance getFavorite() {
        return favorite;
    }

    public void setFavorite(ProductInstance favorite) {
        this.favorite = favorite;
    }

    public List<ProductInstance> getHistories() {
        return histories;
    }

    public void setHistories(List<ProductInstance> histories) {
        this.histories = histories;
    }

    public List<ProductInstance> getBestSubstitutes() {
        return bestSubstitutes;
    }

    public void setBestSubstitutes(List<ProductInstance> bestSubstitutes) {
        this.bestSubstitutes = bestSubstitutes;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, customer='%s', type='%s', family='%s', category='%s', quantity=%s, dlc='%s', status='%', orderStatus='%s', consumption=%s, substitutes=%s, favorite=%s, histories=%s, bestSubstitutes=%s ]",
                COLLECTION_NAME, id, customer, type, family, category, quantity, dlc, status, orderStatus, consumption, substitutes, favorite, histories, bestSubstitutes);
    }
}
