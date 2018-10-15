/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;

/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class NutrientLevels {

    private String sugars;
    private String saturatedFat;
    private String salt;
    private String fat;
    public void setSugars(String sugars) {
         this.sugars = sugars;
     }
     public String getSugars() {
         return sugars;
     }

    public void setSaturatedFat(String saturatedFat) {
         this.saturatedFat = saturatedFat;
     }
     public String getSaturatedFat() {
         return saturatedFat;
     }

    public void setSalt(String salt) {
         this.salt = salt;
     }
     public String getSalt() {
         return salt;
     }

    public void setFat(String fat) {
         this.fat = fat;
     }
     public String getFat() {
         return fat;
     }

}