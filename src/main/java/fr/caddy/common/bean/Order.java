package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final String COLLECTION_NAME = "Order";

    @Id
    protected Long id;
    protected LocalDate date;
    protected Float price;
    protected String customer;
    protected String sign;
    protected Long idExt;

    protected List<Product> products = new ArrayList<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }
    public void setProducts(List<Product> products) {
        this.products= products;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getIdExt() {
        return idExt;
    }

    public void setIdExt(Long idExt) {
        this.idExt = idExt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, idExt=%s, date=%s, sign='%s', price=%s, customer='%s', products=%s ]",
                COLLECTION_NAME, id, idExt, date, sign, price, customer, products);
    }
}
