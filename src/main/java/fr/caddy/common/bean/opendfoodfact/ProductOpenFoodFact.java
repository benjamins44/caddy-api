/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;

import com.google.gson.annotations.SerializedName;

/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class ProductOpenFoodFact {

    private Product product;
    private String code;
    private int status;
    @SerializedName("status_verbose")
    private String statusVerbose;
    public void setProduct(Product product) {
         this.product = product;
     }
     public Product getProduct() {
         return product;
     }

    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setStatusVerbose(String statusVerbose) {
         this.statusVerbose = statusVerbose;
     }
     public String getStatusVerbose() {
         return statusVerbose;
     }

}