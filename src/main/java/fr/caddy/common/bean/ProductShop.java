
package fr.caddy.common.bean;

public class ProductShop {

    private Long id;
    private String label;
    private String sign;
    private String name;
    private Double price;
    private String url;
    private String ticketLabel;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getTicketLabel() {
        return ticketLabel;
    }
    public void setTicketLabel(String ticketLabel) {
        this.ticketLabel = ticketLabel;
    }

    @Override
    public String toString() {
        return String.format(
                "ProductShop[id=%s, label='%s', sign='%s', name='%s', price=%s, url='%s', ticketLabel='%s' ]",
                id, label, sign, name, price, url, ticketLabel);    }

}
