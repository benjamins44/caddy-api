
package fr.caddy.common.bean;

import fr.caddy.common.constants.Constants;
import org.springframework.data.annotation.Id;

import java.util.List;

public class ProductInstance {

    public static final String COLLECTION_NAME = "ProductInstance";

    @Id
    private Long id;

    private String brand;
    private String label;
    private List<String> category;
    private Integer priority;
    private Long openFoodFactId;
    private Integer nova;
    private String nutriscore;
    private Float quantity;
    private String unit = Constants.DEFAULT_UNIT;
    private String image;
    private List<ProductShop> productShops = null;
    private Integer unitWeight;
    private Integer totalWeight;
    private Integer unitCount;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getOpenFoodFactId() {
        return openFoodFactId;
    }
    public void setOpenFoodFactId(Long openFoodFactId) {
        this.openFoodFactId = openFoodFactId;
    }

    public Integer getNova() {
        return nova;
    }
    public void setNova(Integer nova) {
        this.nova = nova;
    }

    public String getNutriscore() {
        return nutriscore;
    }
    public void setNutriscore(String nutriscore) {
        this.nutriscore = nutriscore;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductShop> getProductShops() {
        return productShops;
    }
    public void setProductShops(List<ProductShop> productShops) {
        this.productShops = productShops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Integer unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, quantity=%s, unit='%s', brand='%s', label='%s', priority=%s, openFoodFactId=%s, nova=%s, nutriscore='%s', image='%s', productShops=%s, category=%s, unitWeight=%s, totalWeight=%s, unitCount=%s ]",
                COLLECTION_NAME, id, quantity, unit, brand, label, priority, openFoodFactId, nova, nutriscore, image, productShops, category, unitWeight, totalWeight, unitCount);
    }
}
