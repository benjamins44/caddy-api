package fr.caddy.common.bean;

public class PreOrder extends Order {

    public static final String COLLECTION_NAME = "PreOrder";

    private Boolean ordered = false;

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, date=%s, sign='%s', price=%s, customer='%s', products=%s, ordered=%s ]",
                COLLECTION_NAME, this.getId(), this.getDate(), this.getSign(), this.getCustomer(), this.getProducts(), ordered);
    }

}
