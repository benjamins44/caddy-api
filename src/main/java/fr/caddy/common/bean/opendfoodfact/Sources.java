/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Sources {

    private List<String> images;
    private String url;
    private String id;
    @JsonProperty("import_t")
    private int importT;
    private List<String> fields;
    public void setImages(List<String> images) {
         this.images = images;
     }
     public List<String> getImages() {
         return images;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setImportT(int importT) {
         this.importT = importT;
     }
     public int getImportT() {
         return importT;
     }

    public void setFields(List<String> fields) {
         this.fields = fields;
     }
     public List<String> getFields() {
         return fields;
     }

}