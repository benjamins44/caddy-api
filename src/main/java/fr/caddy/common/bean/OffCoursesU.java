package fr.caddy.common.bean;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

public class OffCoursesU {

    public static final String COLLECTION_NAME = "offCoursesU";

    private String code;

    @Id
    private Long id;

    private Long idCoursesU;

    private String label;

    private String url;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String gtin) {
        this.code = gtin;
    }

    public Long getIdCoursesU() {
        return idCoursesU;
    }

    public void setIdCoursesU(Long idCoursesU) {
        this.idCoursesU = idCoursesU;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, code='%s', idCoursesU=%s, label=%s, url=%s, category=%s ]",
                COLLECTION_NAME, id, code, idCoursesU, label, url, category);
    }
}
