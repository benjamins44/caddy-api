/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;
import com.google.gson.annotations.SerializedName;

/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Images {


    private Front front;
    private Nutrition nutrition;
    @SerializedName("front_fr")
    private FrontFr frontFr;
    @SerializedName("ingredients_fr")
    private IngredientsFr ingredientsFr;
    @SerializedName("nutrition_fr")
    private NutritionFr nutritionFr;
    private Ingredients ingredients;


    public void setFront(Front front) {
         this.front = front;
     }
     public Front getFront() {
         return front;
     }

    public void setNutrition(Nutrition nutrition) {
         this.nutrition = nutrition;
     }
     public Nutrition getNutrition() {
         return nutrition;
     }

    public void setFrontFr(FrontFr frontFr) {
         this.frontFr = frontFr;
     }
     public FrontFr getFrontFr() {
         return frontFr;
     }

    public void setIngredientsFr(IngredientsFr ingredientsFr) {
         this.ingredientsFr = ingredientsFr;
     }
     public IngredientsFr getIngredientsFr() {
         return ingredientsFr;
     }

    public void setNutritionFr(NutritionFr nutritionFr) {
         this.nutritionFr = nutritionFr;
     }
     public NutritionFr getNutritionFr() {
         return nutritionFr;
     }

    public void setIngredients(Ingredients ingredients) {
         this.ingredients = ingredients;
     }
     public Ingredients getIngredients() {
         return ingredients;
     }

}