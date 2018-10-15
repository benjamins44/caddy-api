
package fr.caddy.common.bean;

import java.util.List;

public class Consumption {

    private List<DayQuantity> dayQuantity = null;
    private List<WeeklyQuantity> weeklyQuantity = null;
    private Float frequency;
    private Integer nbWeekOfLastBuy;
    private Float probalilityBuy;
    private Float probalilityQuantityBuy;
    private List<Average> averages = null;
    private List<Integer> month = null;

    public List<DayQuantity> getDayQuantity() {
        return dayQuantity;
    }
    public void setDayQuantity(List<DayQuantity> dates) {
        this.dayQuantity = dates;
    }

    public List<WeeklyQuantity> getWeeklyQuantity() {
        return weeklyQuantity;
    }
    public void setWeeklyQuantity(List<WeeklyQuantity> weeklyQuantity) {
        this.weeklyQuantity = weeklyQuantity;
    }

    public Float getFrequency() {
        return frequency;
    }
    public void setFrequency(Float frequency) {
        this.frequency = frequency;
    }

    public List<Integer> getMonth() {
        return month;
    }
    public void setMonth(List<Integer> mont) {
        this.month = mont;
    }

    public List<Average> getAverages() {
        return averages;
    }

    public void setAverages(List<Average> averages) {
        this.averages = averages;
    }

    public Integer getNbWeekOfLastBuy() {
        return nbWeekOfLastBuy;
    }

    public void setNbWeekOfLastBuy(Integer nbWeekOfLastBuy) {
        this.nbWeekOfLastBuy = nbWeekOfLastBuy;
    }

    public Float getProbalilityBuy() {
        return probalilityBuy;
    }

    public void setProbalilityBuy(Float probalilityBuy) {
        this.probalilityBuy = probalilityBuy;
    }

    public Float getProbalilityQuantityBuy() {
        return probalilityQuantityBuy;
    }

    public void setProbalilityQuantityBuy(Float probalilityQuantityBuy) {
        this.probalilityQuantityBuy = probalilityQuantityBuy;
    }

    @Override
    public String toString() {
        return String.format(
                "Consumption[dayQuantity=%s, weeklyQuantity=%s, frequency=%s, averages=%s, month=%s, nbWeekOfLastBuy=%s, probalilityBuy=%s, probalilityQuantityBuy=%s ]",
                dayQuantity, weeklyQuantity, frequency, averages, month, nbWeekOfLastBuy, probalilityBuy, probalilityQuantityBuy);
    }
}
