package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

public class HistoryOrder {

    @Id
    private Long id;
    private LocalDate date;
    private Float price;
    private String customer;
    private String sign;
    private List<HistoryOrderProduct> productOrders;

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

    public List<HistoryOrderProduct> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<HistoryOrderProduct> productOrders) {
        this.productOrders = productOrders;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return String.format(
                "HistoryOrder[id=%s, date=%s, price=%s, customer='%s', sign='%s', productOrders=%s ]",
                id, date, price, customer, sign, productOrders);
    }
}
