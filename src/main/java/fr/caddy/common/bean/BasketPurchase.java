package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

public class BasketPurchase {

    @Id
    private Long id;

    private Long idProduct;

    private String label;

    private Long quantity;

    private String sign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
                "BasketPurchase[id=%s, idProduct=%s, label='%s', quantity=%s, sign='%s']",
                id, idProduct, label, quantity, sign);
    }
}
