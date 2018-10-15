package fr.caddy.common.bean;

public class Average {

    private Integer nbOccurences;
    private Float quantity;
    private Float nbWeek;

    public Integer getNbOccurences() {
        return nbOccurences;
    }

    public void setNbOccurences(Integer nbOccurences) {
        this.nbOccurences = nbOccurences;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getNbWeek() {
        return nbWeek;
    }

    public void setNbWeek(Float nbWeek) {
        this.nbWeek = nbWeek;
    }

    @Override
    public String toString() {
        return String.format(
                "Average[nbOccurences=%s, nbOccurences=%s, quantity=%s ]",
                nbOccurences, nbOccurences, quantity);
    }
}
