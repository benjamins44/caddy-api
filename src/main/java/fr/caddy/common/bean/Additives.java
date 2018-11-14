package fr.caddy.common.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Additives {

    @Id
    private ObjectId id;

    private String code;

    private String label;

    private String risks;

    private Integer riskLevel;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return String.format(
                "Additives[id=%s, code='%s', label='%s', risks='%s', riskLevel=%s ]",
                id, code, label, risks,riskLevel);
    }
}
