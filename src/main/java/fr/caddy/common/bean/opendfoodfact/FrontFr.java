/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;
import com.google.gson.annotations.SerializedName;

/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class FrontFr {

    @SerializedName("white_magic")
    private String whiteMagic;
    private String geometry;
    private String rev;
    private String imgid;
    private String normalize;
    private Sizes sizes;
    public void setWhiteMagic(String whiteMagic) {
         this.whiteMagic = whiteMagic;
     }
     public String getWhiteMagic() {
         return whiteMagic;
     }

    public void setGeometry(String geometry) {
         this.geometry = geometry;
     }
     public String getGeometry() {
         return geometry;
     }

    public void setRev(String rev) {
         this.rev = rev;
     }
     public String getRev() {
         return rev;
     }

    public void setImgid(String imgid) {
         this.imgid = imgid;
     }
     public String getImgid() {
         return imgid;
     }

    public void setNormalize(String normalize) {
         this.normalize = normalize;
     }
     public String getNormalize() {
         return normalize;
     }

    public void setSizes(Sizes sizes) {
         this.sizes = sizes;
     }
     public Sizes getSizes() {
         return sizes;
     }

}