
package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Product {

    public static final String COLLECTION_NAME = "Product";

    @Id
    private Long id;

    private String label;

    private String customer;

    private String type;

    private String family;

    private String category;

    private String dlc;

    private String image;

    private Float quantity;

    private ProductStatus status = ProductStatus.USED;

    private ProductOrderStatus orderStatus = ProductOrderStatus.NO_ORDER;

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

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

    private List<ProductInstance> productInstances = null;

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

    public List<ProductInstance> getProductInstances() {
        return productInstances;
    }

    public void setProductInstances(List<ProductInstance> productInstances) {
        this.productInstances = productInstances;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, label='%s', customer='%s', type='%s', family='%s', category='%s', quantity=%s, dlc='%s', status='%', orderStatus='%s', consumption=%s, productInstances=%s, image='%s' ]",
                COLLECTION_NAME, id, label, customer, type, family, category, quantity, dlc, status, orderStatus, consumption, productInstances, image);
    }
}
