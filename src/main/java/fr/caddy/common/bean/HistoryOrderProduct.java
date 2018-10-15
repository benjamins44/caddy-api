package fr.caddy.common.bean;

import org.springframework.data.annotation.Id;

public class HistoryOrderProduct {

    @Id
    private Long id;
    private String label;
    private Float quantity;
    private String url;
    private String category;
    private String unit;
    private String sign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String libelle) {
        this.label = libelle;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantite) {
        this.quantity = quantite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
                "HistoryOrderProduct[id=%s, libelle='%s', quantite=%s, unit='%s', url='%s', category='%s', sign='%s']",
                id, label, quantity, unit, url, category, sign);
    }
}
