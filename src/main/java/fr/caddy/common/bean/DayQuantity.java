
package fr.caddy.common.bean;

import java.time.LocalDate;

public class DayQuantity {

    private LocalDate day;
    private Long orderId;
    private Float quantity;
    private String sign;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
                "DayQuantity[day=%s, orderId=%s, quantity=%s, sign='%s' ]",
                day, orderId, quantity, sign);
    }
}
