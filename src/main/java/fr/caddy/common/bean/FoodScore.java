package fr.caddy.common.bean;

public class FoodScore {

    private Integer nutriscoreScore;

    private Integer novaScore;

    private Integer additivesScore;

    private Integer total;

    public Integer getNutriscoreScore() {
        return nutriscoreScore;
    }

    public void setNutriscoreScore(Integer nutriscoreScore) {
        this.nutriscoreScore = nutriscoreScore;
    }

    public Integer getNovaScore() {
        return novaScore;
    }

    public void setNovaScore(Integer novaScore) {
        this.novaScore = novaScore;
    }

    public Integer getAdditivesScore() {
        return additivesScore;
    }

    public void setAdditivesScore(Integer additivesScore) {
        this.additivesScore = additivesScore;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format(
                "FoodScore[nutriscoreScore=%s, novaScore=%s, additivesScore=%s, total=%s ]",
                nutriscoreScore, novaScore, additivesScore, total);
    }
}
