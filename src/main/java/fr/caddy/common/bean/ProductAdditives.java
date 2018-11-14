package fr.caddy.common.bean;

import java.util.List;

public class ProductAdditives {

    private Integer riskLevel;

    private List<Additives> additives;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<Additives> getAdditives() {
        return additives;
    }

    public void setAdditives(List<Additives> additives) {
        this.additives = additives;
    }

    @Override
    public String toString() {
        return String.format(
                "ProductAdditives[riskLevel=%s, additives=%s ]",
                riskLevel, additives );
    }

}
