package fr.caddy.common.bean.ext;

import org.springframework.data.annotation.Id;

public class ProductU {

    @Id
    private Long id;
    private String libelle;
    private String quantite;
    private String url;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
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
                "HistoryOrder[id=%s, libelle='%s', quantite=%s, url='%s', category='%s']",
                id, libelle, quantite, url, category);
    }
}
