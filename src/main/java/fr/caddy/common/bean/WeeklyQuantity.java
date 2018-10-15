
package fr.caddy.common.bean;

public class WeeklyQuantity {

    private Integer week;
    private Integer year;
    private Float quantity;

    public Integer getWeek() {
        return week;
    }
    public void setWeek(Integer week) {
        this.week = week;
    }

    public Float getQuantity() {
        return quantity;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format(
                "WeeklyQuantity[week=%s, year=%s, quantity=%s ]",
                week, year, quantity);
    }
}
