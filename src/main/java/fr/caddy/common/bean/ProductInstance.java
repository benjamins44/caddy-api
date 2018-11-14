
package fr.caddy.common.bean;

import fr.caddy.common.constants.Constants;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

public class ProductInstance {

    public static final String COLLECTION_NAME = "ProductInstance";

    @Id
    private Long id;

    private String brand; // brands
    private String label;
    private String label2; // product_name
    private String category; // categories
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
    private String ingredientsList; // ingredients_text_with_allergens
    private List<String> allergens; // allergens_tags:[ "en:gluten", "en:sesame-seeds" ]
    private List<String> traces; // traces_hierarchy: [ "en:eggs","en:milk" ]
    private List<String> nutrientsLevel; //nutrient_levels: { "saturated-fat" : "low", "sugars" : "moderate", "fat" : "moderate", "salt" : "moderate" }
    private List<ProductAdditives> additives; // additives_tags: [ "en:e282" ]
    private FoodScore foodScore;
    private Integer complete;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public List<String> getTraces() {
        return traces;
    }

    public void setTraces(List<String> traces) {
        this.traces = traces;
    }

    public List<String> getNutrientsLevel() {
        return nutrientsLevel;
    }

    public void setNutrientsLevel(List<String> nutrientsLevel) {
        this.nutrientsLevel = nutrientsLevel;
    }

    public List<ProductAdditives> getAdditives() {
        return additives;
    }

    public void setAdditives(List<ProductAdditives> additives) {
        this.additives = additives;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public FoodScore getFoodScore() {
        return foodScore;
    }

    public void setFoodScore(FoodScore foodScore) {
        this.foodScore = foodScore;
    }

    @Override
    public String toString() {
        return String.format(
                "%s[id=%s, quantity=%s, unit='%s', brand='%s', label='%s', label2='%s', priority=%s, openFoodFactId=%s, nova=%s, nutriscore='%s', image='%s', productShops=%s, category=%s, unitWeight=%s, totalWeight=%s, unitCount=%s, " +
                        "ingredientsList='%s', allergens=%s, traces=%s, nutrientsLevel=%s, additives=%s, foodScore=%s, complete=%s ]",
                COLLECTION_NAME, id, quantity, unit, brand, label, label2, priority, openFoodFactId, nova, nutriscore, image, productShops, category, unitWeight, totalWeight, unitCount,
                ingredientsList, allergens, traces, nutrientsLevel, additives, foodScore, complete);
    }
}
