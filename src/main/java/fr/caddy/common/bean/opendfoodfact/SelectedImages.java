/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;

/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class SelectedImages {

    private Front front;
    private Nutrition nutrition;
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

    public void setIngredients(Ingredients ingredients) {
         this.ingredients = ingredients;
     }
     public Ingredients getIngredients() {
         return ingredients;
     }

}