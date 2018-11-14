/* Copyright 2018 freecodeformat.com */
package fr.caddy.common.bean.opendfoodfact;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


import java.util.List;
/* Time: 2018-10-07 17:37:11 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class ProductsU {

    @Id
    private Long id;
    @JsonProperty("ingredients_n_tags")

    private List<String> ingredientsNTags;
    @Field("product_name")
    @JsonProperty("product_name")
    private String productName;
    @Field("image_nutrition_url")
    @JsonProperty("image_nutrition_url")
    private String imageNutritionUrl;
    @Field("image_front_url")
    @JsonProperty("image_front_url")
    private String imageFrontUrl;
    @Field("manufacturing_places_tags")
    @JsonProperty("manufacturing_places_tags")
    private List<String> manufacturingPlacesTags;
    @Field("emb_codes_debug_tags")
    @JsonProperty("emb_codes_debug_tags")
    private List<String> embCodesDebugTags;
    @Field("additives_old_n")
    @JsonProperty("additives_old_n")
    private int additivesOldN;
    @Field("nucleotides_prev_tags")
    @JsonProperty("nucleotides_prev_tags")
    private List<String> nucleotidesPrevTags;
    @Field("purchase_places")
    @JsonProperty("purchase_places")
    private String purchasePlaces;
    @Field("nutrition_score_debug")
    @JsonProperty("nutrition_score_debug")
    private String nutritionScoreDebug;
    @Field("languages_hierarchy")
    @JsonProperty("languages_hierarchy")
    private List<String> languagesHierarchy;
    @Field("created_t")
    @JsonProperty("created_t")
    private int createdT;
    @Field("max_imgid")
    @JsonProperty("max_imgid")
    private String maxImgid;
    @Field("packaging_tags")
    @JsonProperty("packaging_tags")
    private List<String> packagingTags;
    @Field("informers_tags")
    @JsonProperty("informers_tags")
    private List<String> informersTags;
    @Field("categories_prev_hierarchy")
    @JsonProperty("categories_prev_hierarchy")
    private List<String> categoriesPrevHierarchy;
    @Field("ingredients_hierarchy")
    @JsonProperty("ingredients_hierarchy")
    private List<String> ingredientsHierarchy;
    @Field("cities_tags")
    @JsonProperty("cities_tags")
    private List<String> citiesTags;
    @Field("image_nutrition_small_url")
    @JsonProperty("image_nutrition_small_url")
    private String imageNutritionSmallUrl;
    @Field("nutrient_levels_tags")
    @JsonProperty("nutrient_levels_tags")
    private List<String> nutrientLevelsTags;
    private String code;
    @Field("entry_dates_tags")
    @JsonProperty("entry_dates_tags")
    private List<String> entryDatesTags;
    @Field("traces_hierarchy")
    @JsonProperty("traces_hierarchy")
    private List<String> tracesHierarchy;
    @Field("additives_prev_tags")
    @JsonProperty("additives_prev_tags")
    private List<String> additivesPrevTags;
    @Field("nutrition_data_per_debug_tags")
    @JsonProperty("nutrition_data_per_debug_tags")
    private List<String> nutritionDataPerDebugTags;
    private String countries;
    @Field("nova_group_debug")
    @JsonProperty("nova_group_debug")
    private String novaGroupDebug;
    private String lang;
    @Field("serving_size_debug_tags")
    @JsonProperty("serving_size_debug_tags")
    private List<String> servingSizeDebugTags;
    @Field("brands_tags")
    @JsonProperty("brands_tags")
    private List<String> brandsTags;
    @Field("photographers_tags")
    @JsonProperty("photographers_tags")
    private List<String> photographersTags;
    @Field("generic_name_fr")
    @JsonProperty("generic_name_fr")
    private String genericNameFr;
    @Field("stores_tags")
    @JsonProperty("stores_tags")
    private List<String> storesTags;
    @Field("link_debug_tags")
    @JsonProperty("link_debug_tags")
    private List<String> linkDebugTags;
    @Field("minerals_prev_tags")
    @JsonProperty("minerals_prev_tags")
    private List<String> mineralsPrevTags;
    @Field("nova_groups_tags")
    @JsonProperty("nova_groups_tags")
    private List<String> novaGroupsTags;
    @Field("nova_group")
    @JsonProperty("nova_group")
    private String novaGroup;
    @Field("nucleotides_tags")
    @JsonProperty("nucleotides_tags")
    private List<String> nucleotidesTags;
    @Field("no_nutrition_data")
    @JsonProperty("no_nutrition_data")
    private String noNutritionData;
    @Field("expiration_date_debug_tags")
    @JsonProperty("expiration_date_debug_tags")
    private List<String> expirationDateDebugTags;
    @Field("languages_codes")
    @JsonProperty("languages_codes")
    private LanguagesCodes languagesCodes;
    @Field("ingredients_ids_debug")
    @JsonProperty("ingredients_ids_debug")
    private List<String> ingredientsIdsDebug;
    @Field("image_url")
    @JsonProperty("image_url")
    private String imageUrl;
    @Field("ingredients_text_with_allergens_fr")
    @JsonProperty("ingredients_text_with_allergens_fr")
    private String ingredientsTextWithAllergensFr;
    private List<Sources> sources;
    @Field("quantity_debug_tags")
    @JsonProperty("quantity_debug_tags")
    private List<String> quantityDebugTags;
    @Field("serving_size")
    @JsonProperty("serving_size")
    private String servingSize;
    @Field("nutrition_score_warning_no_fruits_vegetables_nuts")
    @JsonProperty("nutrition_score_warning_no_fruits_vegetables_nuts")
    private int nutritionScoreWarningNoFruitsVegetablesNuts;
    @Field("ingredients_text_fr_debug_tags")
    @JsonProperty("ingredients_text_fr_debug_tags")
    private List<String> ingredientsTextFrDebugTags;
    @Field("nutrition_grade_fr")
    @JsonProperty("nutrition_grade_fr")
    private String nutritionGradeFr;
    @Field("generic_name")
    @JsonProperty("generic_name")
    private String genericName;
    @Field("editors_tags")
    @JsonProperty("editors_tags")
    private List<String> editorsTags;
    @Field("additives_old_tags")
    @JsonProperty("additives_old_tags")
    private List<String> additivesOldTags;
    @Field("additives_debug_tags")
    @JsonProperty("additives_debug_tags")
    private List<String> additivesDebugTags;
    @Field("product_name_fr_debug_tags")
    @JsonProperty("product_name_fr_debug_tags")
    private List<String> productNameFrDebugTags;
    @Field("categories_prev_tags")
    @JsonProperty("categories_prev_tags")
    private List<String> categoriesPrevTags;
    private String allergens;
    @Field("countries_hierarchy")
    @JsonProperty("countries_hierarchy")
    private List<String> countriesHierarchy;
    @Field("quality_tags")
    @JsonProperty("quality_tags")
    private List<String> qualityTags;
    @Field("ingredients_that_may_be_from_palm_oil_n")
    @JsonProperty("ingredients_that_may_be_from_palm_oil_n")
    private int ingredientsThatMayBeFromPalmOilN;
    @Field("emb_codes_tags")
    @JsonProperty("emb_codes_tags")
    private List<String> embCodesTags;
    @Field("last_image_dates_tags")
    @JsonProperty("last_image_dates_tags")
    private List<String> lastImageDatesTags;
    @Field("additives_prev_original_tags")
    @JsonProperty("additives_prev_original_tags")
    private List<String> additivesPrevOriginalTags;
    @Field("brands_debug_tags")
    @JsonProperty("brands_debug_tags")
    private List<String> brandsDebugTags;
    @Field("states_hierarchy")
    @JsonProperty("states_hierarchy")
    private List<String> statesHierarchy;
    @Field("nutrition_grades")
    @JsonProperty("nutrition_grades")
    private String nutritionGrades;
    @Field("nutrient_levels")
    @JsonProperty("nutrient_levels")
    private NutrientLevels nutrientLevels;
    @Field("traces_tags")
    @JsonProperty("traces_tags")
    private List<String> tracesTags;
    private String additives;
    @Field("new_additives_n")
    @JsonProperty("new_additives_n")
    private int newAdditivesN;
    @Field("labels_prev_tags")
    @JsonProperty("labels_prev_tags")
    private List<String> labelsPrevTags;
    private String origins;
    @Field("ingredients_text_fr")
    @JsonProperty("ingredients_text_fr")
    private String ingredientsTextFr;
    private String brands;
    @Field("pnns_groups_2")
    @JsonProperty("pnns_groups_2")
    private String pnnsGroups2;
    @Field("image_small_url")
    @JsonProperty("image_small_url")
    private String imageSmallUrl;
    @Field("vitamins_prev_tags")
    @JsonProperty("vitamins_prev_tags")
    private List<String> vitaminsPrevTags;
    @Field("last_modified_t")
    @JsonProperty("last_modified_t")
    private int lastModifiedT;
    @Field("misc_tags")
    @JsonProperty("misc_tags")
    private List<String> miscTags;
    @Field("labels_debug_tags")
    @JsonProperty("labels_debug_tags")
    private List<String> labelsDebugTags;
    @Field("image_ingredients_thumb_url")
    @JsonProperty("image_ingredients_thumb_url")
    private String imageIngredientsThumbUrl;
    private List<String> editors;
    private String labels;
    private String packaging;
    @Field("lang_debug_tags")
    @JsonProperty("lang_debug_tags")
    private List<String> langDebugTags;
    @Field("selected_images")
    @JsonProperty("selected_images")
    private SelectedImages selectedImages;
    private String creator;
    private List<Ingredients> ingredients;
    @Field("additives_prev_n")
    @JsonProperty("additives_prev_n")
    private int additivesPrevN;
    @Field("purchase_places_tags")
    @JsonProperty("purchase_places_tags")
    private List<String> purchasePlacesTags;
    @Field("pnns_groups_1")
    @JsonProperty("pnns_groups_1")
    private String pnnsGroups1;
    @Field("scans_n")
    @JsonProperty("scans_n")
    private int scansN;
    @Field("ingredients_tags")
    @JsonProperty("ingredients_tags")
    private List<String> ingredientsTags;
    @Field("allergens_tags")
    @JsonProperty("allergens_tags")
    private List<String> allergensTags;

    @Field("traces_from_ingredients")
    @JsonProperty("traces_from_ingredients")
    private String tracesFromIngredients;
    @Field("pnns_groups_1_tags")
    @JsonProperty("pnns_groups_1_tags")
    private List<String> pnnsGroups1Tags;
    @Field("states_tags")
    @JsonProperty("states_tags")
    private List<String> statesTags;
    @Field("image_ingredients_small_url")
    @JsonProperty("image_ingredients_small_url")
    private String imageIngredientsSmallUrl;
    @Field("labels_prev_hierarchy")
    @JsonProperty("labels_prev_hierarchy")
    private List<String> labelsPrevHierarchy;
    private String traces;
    @Field("origins_tags")
    @JsonProperty("origins_tags")
    private List<String> originsTags;
    private String stores;
    @Field("ingredients_that_may_be_from_palm_oil_tags")
    @JsonProperty("ingredients_that_may_be_from_palm_oil_tags")
    private List<String> ingredientsThatMayBeFromPalmOilTags;
    @Field("expiration_date")
    @JsonProperty("expiration_date")
    private String expirationDate;
    @Field("generic_name_fr_debug_tags")
    @JsonProperty("generic_name_fr_debug_tags")
    private List<String> genericNameFrDebugTags;
    @Field("amino_acids_prev_tags")
    @JsonProperty("amino_acids_prev_tags")
    private List<String> aminoAcidsPrevTags;
    @Field("_keywords")
    @JsonProperty("_keywords")
    private List<String> Keywords;
    private int complete;
    @Field("manufacturing_places")
    @JsonProperty("manufacturing_places")
    private String manufacturingPlaces;
    @Field("ingredients_debug")
    @JsonProperty("ingredients_debug")
    private List<String> ingredientsDebug;
    @Field("last_editor")
    @JsonProperty("last_editor")
    private String lastEditor;
    @Field("nutrition_data_per")
    @JsonProperty("nutrition_data_per")
    private String nutritionDataPer;
    @Field("correctors_tags")
    @JsonProperty("correctors_tags")
    private List<String> correctorsTags;
    @Field("serving_quantity")
    @JsonProperty("serving_quantity")
    private int servingQuantity;
    @Field("stores_debug_tags")
    @JsonProperty("stores_debug_tags")
    private List<String> storesDebugTags;
    @Field("debug_param_sorted_langs")
    @JsonProperty("debug_param_sorted_langs")
    private List<String> debugParamSortedLangs;
    private int rev;
    private Languages languages;
    @Field("product_name_fr")
    @JsonProperty("product_name_fr")
    private String productNameFr;
    @Field("additives_prev")
    @JsonProperty("additives_prev")
    private String additivesPrev;
    @Field("manufacturing_places_debug_tags")
    @JsonProperty("manufacturing_places_debug_tags")
    private List<String> manufacturingPlacesDebugTags;
    @Field("countries_debug_tags")
    @JsonProperty("countries_debug_tags")
    private List<String> countriesDebugTags;
    @Field("purchase_places_debug_tags")
    @JsonProperty("purchase_places_debug_tags")
    private List<String> purchasePlacesDebugTags;
    @Field("last_edit_dates_tags")
    @JsonProperty("last_edit_dates_tags")
    private List<String> lastEditDatesTags;
    @Field("unique_scans_n")
    @JsonProperty("unique_scans_n")
    private int uniqueScansN;
    @Field("interface_version_modified")
    @JsonProperty("interface_version_modified")
    private String interfaceVersionModified;
    @Field("debug_tags")
    @JsonProperty("debug_tags")
    private List<String> debugTags;
    @Field("ingredients_original_tags")
    @JsonProperty("ingredients_original_tags")
    private List<String> ingredientsOriginalTags;
    @Field("vitamins_tags")
    @JsonProperty("vitamins_tags")
    private List<String> vitaminsTags;
    @Field("image_front_thumb_url")
    @JsonProperty("image_front_thumb_url")
    private String imageFrontThumbUrl;
    @Field("update_key")
    @JsonProperty("update_key")
    private String updateKey;
    @Field("interface_version_created")
    @JsonProperty("interface_version_created")
    private String interfaceVersionCreated;
    @Field("ingredients_from_palm_oil_n")
    @JsonProperty("ingredients_from_palm_oil_n")
    private int ingredientsFromPalmOilN;
    private String link;
    @Field("categories_hierarchy")
    @JsonProperty("categories_hierarchy")
    private List<String> categoriesHierarchy;
    @Field("unknown_ingredients_n")
    @JsonProperty("unknown_ingredients_n")
    private int unknownIngredientsN;
    @Field("nutrition_grades_tags")
    @JsonProperty("nutrition_grades_tags")
    private List<String> nutritionGradesTags;
    @Field("emb_codes_20141016")
    @JsonProperty("emb_codes_20141016")
    private String embCodes20141016;
    @Field("nova_groups")
    @JsonProperty("nova_groups")
    private String novaGroups;
    private String quantity;
    @Field("ingredients_text")
    @JsonProperty("ingredients_text")
    private String ingredientsText;
    @Field("ingredients_from_or_that_may_be_from_palm_oil_n")
    @JsonProperty("ingredients_from_or_that_may_be_from_palm_oil_n")
    private int ingredientsFromOrThatMayBeFromPalmOilN;
    @Field("codes_tags")
    @JsonProperty("codes_tags")
    private List<String> codesTags;
    private Nutriments nutriments;
    @Field("nutrition_data_prepared_per")
    @JsonProperty("nutrition_data_prepared_per")
    private String nutritionDataPreparedPer;
    private String lc;
    @Field("countries_tags")
    @JsonProperty("countries_tags")
    private List<String> countriesTags;
    @Field("emb_codes_orig")
    @JsonProperty("emb_codes_orig")
    private String embCodesOrig;
    @Field("additives_tags")
    @JsonProperty("additives_tags")
    private List<String> additivesTags;
    @Field("ingredients_text_with_allergens")
    @JsonProperty("ingredients_text_with_allergens")
    private String ingredientsTextWithAllergens;
    @Field("image_thumb_url")
    @JsonProperty("image_thumb_url")
    private String imageThumbUrl;
    @Field("ingredients_n")
    @JsonProperty("ingredients_n")
    private String ingredientsN;
    @Field("additives_original_tags")
    @JsonProperty("additives_original_tags")
    private List<String> additivesOriginalTags;
    @JsonProperty("_id")
    private String Id;
    @Field("pnns_groups_2_tags")
    @JsonProperty("pnns_groups_2_tags")
    private List<String> pnnsGroups2Tags;
    @Field("fruitNvegetableNnuts_100g_estimate")
    @JsonProperty("fruitNvegetableNnuts_100g_estimate")
    private int fruitNvegetableNnuts100gEstimate;
    @Field("minerals_tags")
    @JsonProperty("minerals_tags")
    private List<String> mineralsTags;
    private Images images;
    @Field("completed_t")
    @JsonProperty("completed_t")
    private int completedT;
    @Field("origins_debug_tags")
    @JsonProperty("origins_debug_tags")
    private List<String> originsDebugTags;
    @Field("ingredients_text_debug")
    @JsonProperty("ingredients_text_debug")
    private String ingredientsTextDebug;
    private String states;
    @Field("labels_tags")
    @JsonProperty("labels_tags")
    private List<String> labelsTags;
    @Field("labels_hierarchy")
    @JsonProperty("labels_hierarchy")
    private List<String> labelsHierarchy;
    @Field("amino_acids_tags")
    @JsonProperty("amino_acids_tags")
    private List<String> aminoAcidsTags;
    @Field("emb_codes")
    @JsonProperty("emb_codes")
    private String embCodes;
    @Field("image_nutrition_thumb_url")
    @JsonProperty("image_nutrition_thumb_url")
    private String imageNutritionThumbUrl;
    private int sortkey;
    @Field("image_front_small_url")
    @JsonProperty("image_front_small_url")
    private String imageFrontSmallUrl;
    @Field("packaging_debug_tags")
    @JsonProperty("packaging_debug_tags")
    private List<String> packagingDebugTags;
    @Field("image_ingredients_url")
    @JsonProperty("image_ingredients_url")
    private String imageIngredientsUrl;
    @Field("additives_n")
    @JsonProperty("additives_n")
    private int additivesN;
    @Field("traces_debug_tags")
    @JsonProperty("traces_debug_tags")
    private List<String> tracesDebugTags;
    @Field("checkers_tags")
    @JsonProperty("checkers_tags")
    private List<String> checkersTags;
    @Field("last_image_t")
    @JsonProperty("last_image_t")
    private int lastImageT;
    @Field("categories_debug_tags")
    @JsonProperty("categories_debug_tags")
    private List<String> categoriesDebugTags;
    @Field("allergens_from_ingredients")
    @JsonProperty("allergens_from_ingredients")
    private String allergensFromIngredients;
    @Field("categories_tags")
    @JsonProperty("categories_tags")
    private List<String> categoriesTags;
    @Field("product_quantity")
    @JsonProperty("product_quantity")
    private int productQuantity;
    private String categories;
    @Field("allergens_hierarchy")
    @JsonProperty("allergens_hierarchy")
    private List<String> allergensHierarchy;
    @Field("last_modified_by")
    @JsonProperty("last_modified_by")
    private String lastModifiedBy;
    @Field("ingredients_from_palm_oil_tags")
    @JsonProperty("ingredients_from_palm_oil_tags")
    private List<String> ingredientsFromPalmOilTags;
    @Field("unknown_nutrients_tags")
    @JsonProperty("unknown_nutrients_tags")
    private List<String> unknownNutrientsTags;
    public void setIngredientsNTags(List<String> ingredientsNTags) {
         this.ingredientsNTags = ingredientsNTags;
     }
     public List<String> getIngredientsNTags() {
         return ingredientsNTags;
     }

    public void setProductName(String productName) {
         this.productName = productName;
     }
     public String getProductName() {
         return productName;
     }

    public void setImageNutritionUrl(String imageNutritionUrl) {
         this.imageNutritionUrl = imageNutritionUrl;
     }
     public String getImageNutritionUrl() {
         return imageNutritionUrl;
     }

    public void setImageFrontUrl(String imageFrontUrl) {
         this.imageFrontUrl = imageFrontUrl;
     }
     public String getImageFrontUrl() {
         return imageFrontUrl;
     }

    public void setManufacturingPlacesTags(List<String> manufacturingPlacesTags) {
         this.manufacturingPlacesTags = manufacturingPlacesTags;
     }
     public List<String> getManufacturingPlacesTags() {
         return manufacturingPlacesTags;
     }

    public void setEmbCodesDebugTags(List<String> embCodesDebugTags) {
         this.embCodesDebugTags = embCodesDebugTags;
     }
     public List<String> getEmbCodesDebugTags() {
         return embCodesDebugTags;
     }

    public void setAdditivesOldN(int additivesOldN) {
         this.additivesOldN = additivesOldN;
     }
     public int getAdditivesOldN() {
         return additivesOldN;
     }

    public void setNucleotidesPrevTags(List<String> nucleotidesPrevTags) {
         this.nucleotidesPrevTags = nucleotidesPrevTags;
     }
     public List<String> getNucleotidesPrevTags() {
         return nucleotidesPrevTags;
     }

    public void setPurchasePlaces(String purchasePlaces) {
         this.purchasePlaces = purchasePlaces;
     }
     public String getPurchasePlaces() {
         return purchasePlaces;
     }

    public void setNutritionScoreDebug(String nutritionScoreDebug) {
         this.nutritionScoreDebug = nutritionScoreDebug;
     }
     public String getNutritionScoreDebug() {
         return nutritionScoreDebug;
     }

    public void setLanguagesHierarchy(List<String> languagesHierarchy) {
         this.languagesHierarchy = languagesHierarchy;
     }
     public List<String> getLanguagesHierarchy() {
         return languagesHierarchy;
     }

    public void setCreatedT(int createdT) {
         this.createdT = createdT;
     }
     public int getCreatedT() {
         return createdT;
     }

    public void setMaxImgid(String maxImgid) {
         this.maxImgid = maxImgid;
     }
     public String getMaxImgid() {
         return maxImgid;
     }

    public void setPackagingTags(List<String> packagingTags) {
         this.packagingTags = packagingTags;
     }
     public List<String> getPackagingTags() {
         return packagingTags;
     }

    public void setInformersTags(List<String> informersTags) {
         this.informersTags = informersTags;
     }
     public List<String> getInformersTags() {
         return informersTags;
     }

    public void setCategoriesPrevHierarchy(List<String> categoriesPrevHierarchy) {
         this.categoriesPrevHierarchy = categoriesPrevHierarchy;
     }
     public List<String> getCategoriesPrevHierarchy() {
         return categoriesPrevHierarchy;
     }

    public void setIngredientsHierarchy(List<String> ingredientsHierarchy) {
         this.ingredientsHierarchy = ingredientsHierarchy;
     }
     public List<String> getIngredientsHierarchy() {
         return ingredientsHierarchy;
     }

    public void setCitiesTags(List<String> citiesTags) {
         this.citiesTags = citiesTags;
     }
     public List<String> getCitiesTags() {
         return citiesTags;
     }

    public void setImageNutritionSmallUrl(String imageNutritionSmallUrl) {
         this.imageNutritionSmallUrl = imageNutritionSmallUrl;
     }
     public String getImageNutritionSmallUrl() {
         return imageNutritionSmallUrl;
     }

    public void setNutrientLevelsTags(List<String> nutrientLevelsTags) {
         this.nutrientLevelsTags = nutrientLevelsTags;
     }
     public List<String> getNutrientLevelsTags() {
         return nutrientLevelsTags;
     }

    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setEntryDatesTags(List<String> entryDatesTags) {
         this.entryDatesTags = entryDatesTags;
     }
     public List<String> getEntryDatesTags() {
         return entryDatesTags;
     }

    public void setTracesHierarchy(List<String> tracesHierarchy) {
         this.tracesHierarchy = tracesHierarchy;
     }
     public List<String> getTracesHierarchy() {
         return tracesHierarchy;
     }

    public void setAdditivesPrevTags(List<String> additivesPrevTags) {
         this.additivesPrevTags = additivesPrevTags;
     }
     public List<String> getAdditivesPrevTags() {
         return additivesPrevTags;
     }

    public void setNutritionDataPerDebugTags(List<String> nutritionDataPerDebugTags) {
         this.nutritionDataPerDebugTags = nutritionDataPerDebugTags;
     }
     public List<String> getNutritionDataPerDebugTags() {
         return nutritionDataPerDebugTags;
     }

    public void setCountries(String countries) {
         this.countries = countries;
     }
     public String getCountries() {
         return countries;
     }

    public void setNovaGroupDebug(String novaGroupDebug) {
         this.novaGroupDebug = novaGroupDebug;
     }
     public String getNovaGroupDebug() {
         return novaGroupDebug;
     }

    public void setLang(String lang) {
         this.lang = lang;
     }
     public String getLang() {
         return lang;
     }

    public void setServingSizeDebugTags(List<String> servingSizeDebugTags) {
         this.servingSizeDebugTags = servingSizeDebugTags;
     }
     public List<String> getServingSizeDebugTags() {
         return servingSizeDebugTags;
     }

    public void setBrandsTags(List<String> brandsTags) {
         this.brandsTags = brandsTags;
     }
     public List<String> getBrandsTags() {
         return brandsTags;
     }

    public void setPhotographersTags(List<String> photographersTags) {
         this.photographersTags = photographersTags;
     }
     public List<String> getPhotographersTags() {
         return photographersTags;
     }

    public void setGenericNameFr(String genericNameFr) {
         this.genericNameFr = genericNameFr;
     }
     public String getGenericNameFr() {
         return genericNameFr;
     }

    public void setStoresTags(List<String> storesTags) {
         this.storesTags = storesTags;
     }
     public List<String> getStoresTags() {
         return storesTags;
     }

    public void setLinkDebugTags(List<String> linkDebugTags) {
         this.linkDebugTags = linkDebugTags;
     }
     public List<String> getLinkDebugTags() {
         return linkDebugTags;
     }

    public void setMineralsPrevTags(List<String> mineralsPrevTags) {
         this.mineralsPrevTags = mineralsPrevTags;
     }
     public List<String> getMineralsPrevTags() {
         return mineralsPrevTags;
     }

    public void setNovaGroupsTags(List<String> novaGroupsTags) {
         this.novaGroupsTags = novaGroupsTags;
     }
     public List<String> getNovaGroupsTags() {
         return novaGroupsTags;
     }

    public void setNovaGroup(String novaGroup) {
         this.novaGroup = novaGroup;
     }
     public String getNovaGroup() {
         return novaGroup;
     }

    public void setNucleotidesTags(List<String> nucleotidesTags) {
         this.nucleotidesTags = nucleotidesTags;
     }
     public List<String> getNucleotidesTags() {
         return nucleotidesTags;
     }

    public void setNoNutritionData(String noNutritionData) {
         this.noNutritionData = noNutritionData;
     }
     public String getNoNutritionData() {
         return noNutritionData;
     }

    public void setExpirationDateDebugTags(List<String> expirationDateDebugTags) {
         this.expirationDateDebugTags = expirationDateDebugTags;
     }
     public List<String> getExpirationDateDebugTags() {
         return expirationDateDebugTags;
     }

    public void setLanguagesCodes(LanguagesCodes languagesCodes) {
         this.languagesCodes = languagesCodes;
     }
     public LanguagesCodes getLanguagesCodes() {
         return languagesCodes;
     }

    public void setIngredientsIdsDebug(List<String> ingredientsIdsDebug) {
         this.ingredientsIdsDebug = ingredientsIdsDebug;
     }
     public List<String> getIngredientsIdsDebug() {
         return ingredientsIdsDebug;
     }

    public void setImageUrl(String imageUrl) {
         this.imageUrl = imageUrl;
     }
     public String getImageUrl() {
         return imageUrl;
     }

    public void setIngredientsTextWithAllergensFr(String ingredientsTextWithAllergensFr) {
         this.ingredientsTextWithAllergensFr = ingredientsTextWithAllergensFr;
     }
     public String getIngredientsTextWithAllergensFr() {
         return ingredientsTextWithAllergensFr;
     }

    public void setSources(List<Sources> sources) {
         this.sources = sources;
     }
     public List<Sources> getSources() {
         return sources;
     }

    public void setQuantityDebugTags(List<String> quantityDebugTags) {
         this.quantityDebugTags = quantityDebugTags;
     }
     public List<String> getQuantityDebugTags() {
         return quantityDebugTags;
     }

    public void setServingSize(String servingSize) {
         this.servingSize = servingSize;
     }
     public String getServingSize() {
         return servingSize;
     }

    public void setNutritionScoreWarningNoFruitsVegetablesNuts(int nutritionScoreWarningNoFruitsVegetablesNuts) {
         this.nutritionScoreWarningNoFruitsVegetablesNuts = nutritionScoreWarningNoFruitsVegetablesNuts;
     }
     public int getNutritionScoreWarningNoFruitsVegetablesNuts() {
         return nutritionScoreWarningNoFruitsVegetablesNuts;
     }

    public void setIngredientsTextFrDebugTags(List<String> ingredientsTextFrDebugTags) {
         this.ingredientsTextFrDebugTags = ingredientsTextFrDebugTags;
     }
     public List<String> getIngredientsTextFrDebugTags() {
         return ingredientsTextFrDebugTags;
     }

    public void setNutritionGradeFr(String nutritionGradeFr) {
         this.nutritionGradeFr = nutritionGradeFr;
     }
     public String getNutritionGradeFr() {
         return nutritionGradeFr;
     }

    public void setGenericName(String genericName) {
         this.genericName = genericName;
     }
     public String getGenericName() {
         return genericName;
     }

    public void setEditorsTags(List<String> editorsTags) {
         this.editorsTags = editorsTags;
     }
     public List<String> getEditorsTags() {
         return editorsTags;
     }

    public void setAdditivesOldTags(List<String> additivesOldTags) {
         this.additivesOldTags = additivesOldTags;
     }
     public List<String> getAdditivesOldTags() {
         return additivesOldTags;
     }

    public void setAdditivesDebugTags(List<String> additivesDebugTags) {
         this.additivesDebugTags = additivesDebugTags;
     }
     public List<String> getAdditivesDebugTags() {
         return additivesDebugTags;
     }

    public void setProductNameFrDebugTags(List<String> productNameFrDebugTags) {
         this.productNameFrDebugTags = productNameFrDebugTags;
     }
     public List<String> getProductNameFrDebugTags() {
         return productNameFrDebugTags;
     }

    public void setCategoriesPrevTags(List<String> categoriesPrevTags) {
         this.categoriesPrevTags = categoriesPrevTags;
     }
     public List<String> getCategoriesPrevTags() {
         return categoriesPrevTags;
     }

    public void setAllergens(String allergens) {
         this.allergens = allergens;
     }
     public String getAllergens() {
         return allergens;
     }

    public void setCountriesHierarchy(List<String> countriesHierarchy) {
         this.countriesHierarchy = countriesHierarchy;
     }
     public List<String> getCountriesHierarchy() {
         return countriesHierarchy;
     }

    public void setQualityTags(List<String> qualityTags) {
         this.qualityTags = qualityTags;
     }
     public List<String> getQualityTags() {
         return qualityTags;
     }

    public void setIngredientsThatMayBeFromPalmOilN(int ingredientsThatMayBeFromPalmOilN) {
         this.ingredientsThatMayBeFromPalmOilN = ingredientsThatMayBeFromPalmOilN;
     }
     public int getIngredientsThatMayBeFromPalmOilN() {
         return ingredientsThatMayBeFromPalmOilN;
     }

    public void setEmbCodesTags(List<String> embCodesTags) {
         this.embCodesTags = embCodesTags;
     }
     public List<String> getEmbCodesTags() {
         return embCodesTags;
     }

    public void setLastImageDatesTags(List<String> lastImageDatesTags) {
         this.lastImageDatesTags = lastImageDatesTags;
     }
     public List<String> getLastImageDatesTags() {
         return lastImageDatesTags;
     }

    public void setAdditivesPrevOriginalTags(List<String> additivesPrevOriginalTags) {
         this.additivesPrevOriginalTags = additivesPrevOriginalTags;
     }
     public List<String> getAdditivesPrevOriginalTags() {
         return additivesPrevOriginalTags;
     }

    public void setBrandsDebugTags(List<String> brandsDebugTags) {
         this.brandsDebugTags = brandsDebugTags;
     }
     public List<String> getBrandsDebugTags() {
         return brandsDebugTags;
     }

    public void setStatesHierarchy(List<String> statesHierarchy) {
         this.statesHierarchy = statesHierarchy;
     }
     public List<String> getStatesHierarchy() {
         return statesHierarchy;
     }

    public void setNutritionGrades(String nutritionGrades) {
         this.nutritionGrades = nutritionGrades;
     }
     public String getNutritionGrades() {
         return nutritionGrades;
     }

    public void setNutrientLevels(NutrientLevels nutrientLevels) {
         this.nutrientLevels = nutrientLevels;
     }
     public NutrientLevels getNutrientLevels() {
         return nutrientLevels;
     }

    public void setTracesTags(List<String> tracesTags) {
         this.tracesTags = tracesTags;
     }
     public List<String> getTracesTags() {
         return tracesTags;
     }

    public void setAdditives(String additives) {
         this.additives = additives;
     }
     public String getAdditives() {
         return additives;
     }

    public void setNewAdditivesN(int newAdditivesN) {
         this.newAdditivesN = newAdditivesN;
     }
     public int getNewAdditivesN() {
         return newAdditivesN;
     }

    public void setLabelsPrevTags(List<String> labelsPrevTags) {
         this.labelsPrevTags = labelsPrevTags;
     }
     public List<String> getLabelsPrevTags() {
         return labelsPrevTags;
     }

    public void setOrigins(String origins) {
         this.origins = origins;
     }
     public String getOrigins() {
         return origins;
     }

    public void setIngredientsTextFr(String ingredientsTextFr) {
         this.ingredientsTextFr = ingredientsTextFr;
     }
     public String getIngredientsTextFr() {
         return ingredientsTextFr;
     }

    public void setBrands(String brands) {
         this.brands = brands;
     }
     public String getBrands() {
         return brands;
     }

    public void setPnnsGroups2(String pnnsGroups2) {
         this.pnnsGroups2 = pnnsGroups2;
     }
     public String getPnnsGroups2() {
         return pnnsGroups2;
     }

    public void setImageSmallUrl(String imageSmallUrl) {
         this.imageSmallUrl = imageSmallUrl;
     }
     public String getImageSmallUrl() {
         return imageSmallUrl;
     }

    public void setVitaminsPrevTags(List<String> vitaminsPrevTags) {
         this.vitaminsPrevTags = vitaminsPrevTags;
     }
     public List<String> getVitaminsPrevTags() {
         return vitaminsPrevTags;
     }

    public void setLastModifiedT(int lastModifiedT) {
         this.lastModifiedT = lastModifiedT;
     }
     public int getLastModifiedT() {
         return lastModifiedT;
     }

    public void setMiscTags(List<String> miscTags) {
         this.miscTags = miscTags;
     }
     public List<String> getMiscTags() {
         return miscTags;
     }

    public void setLabelsDebugTags(List<String> labelsDebugTags) {
         this.labelsDebugTags = labelsDebugTags;
     }
     public List<String> getLabelsDebugTags() {
         return labelsDebugTags;
     }

    public void setImageIngredientsThumbUrl(String imageIngredientsThumbUrl) {
         this.imageIngredientsThumbUrl = imageIngredientsThumbUrl;
     }
     public String getImageIngredientsThumbUrl() {
         return imageIngredientsThumbUrl;
     }

    public void setEditors(List<String> editors) {
         this.editors = editors;
     }
     public List<String> getEditors() {
         return editors;
     }

    public void setLabels(String labels) {
         this.labels = labels;
     }
     public String getLabels() {
         return labels;
     }

    public void setPackaging(String packaging) {
         this.packaging = packaging;
     }
     public String getPackaging() {
         return packaging;
     }

    public void setLangDebugTags(List<String> langDebugTags) {
         this.langDebugTags = langDebugTags;
     }
     public List<String> getLangDebugTags() {
         return langDebugTags;
     }

    public void setSelectedImages(SelectedImages selectedImages) {
         this.selectedImages = selectedImages;
     }
     public SelectedImages getSelectedImages() {
         return selectedImages;
     }

    public void setCreator(String creator) {
         this.creator = creator;
     }
     public String getCreator() {
         return creator;
     }

    public void setIngredients(List<Ingredients> ingredients) {
         this.ingredients = ingredients;
     }
     public List<Ingredients> getIngredients() {
         return ingredients;
     }

    public void setAdditivesPrevN(int additivesPrevN) {
         this.additivesPrevN = additivesPrevN;
     }
     public int getAdditivesPrevN() {
         return additivesPrevN;
     }

    public void setPurchasePlacesTags(List<String> purchasePlacesTags) {
         this.purchasePlacesTags = purchasePlacesTags;
     }
     public List<String> getPurchasePlacesTags() {
         return purchasePlacesTags;
     }

    public void setPnnsGroups1(String pnnsGroups1) {
         this.pnnsGroups1 = pnnsGroups1;
     }
     public String getPnnsGroups1() {
         return pnnsGroups1;
     }

    public void setScansN(int scansN) {
         this.scansN = scansN;
     }
     public int getScansN() {
         return scansN;
     }

    public void setIngredientsTags(List<String> ingredientsTags) {
         this.ingredientsTags = ingredientsTags;
     }
     public List<String> getIngredientsTags() {
         return ingredientsTags;
     }

    public void setAllergensTags(List<String> allergensTags) {
         this.allergensTags = allergensTags;
     }
     public List<String> getAllergensTags() {
         return allergensTags;
     }

    public void setTracesFromIngredients(String tracesFromIngredients) {
         this.tracesFromIngredients = tracesFromIngredients;
     }
     public String getTracesFromIngredients() {
         return tracesFromIngredients;
     }

    public void setPnnsGroups1Tags(List<String> pnnsGroups1Tags) {
         this.pnnsGroups1Tags = pnnsGroups1Tags;
     }
     public List<String> getPnnsGroups1Tags() {
         return pnnsGroups1Tags;
     }

    public void setStatesTags(List<String> statesTags) {
         this.statesTags = statesTags;
     }
     public List<String> getStatesTags() {
         return statesTags;
     }

    public void setImageIngredientsSmallUrl(String imageIngredientsSmallUrl) {
         this.imageIngredientsSmallUrl = imageIngredientsSmallUrl;
     }
     public String getImageIngredientsSmallUrl() {
         return imageIngredientsSmallUrl;
     }

    public void setLabelsPrevHierarchy(List<String> labelsPrevHierarchy) {
         this.labelsPrevHierarchy = labelsPrevHierarchy;
     }
     public List<String> getLabelsPrevHierarchy() {
         return labelsPrevHierarchy;
     }

    public void setTraces(String traces) {
         this.traces = traces;
     }
     public String getTraces() {
         return traces;
     }

    public void setOriginsTags(List<String> originsTags) {
         this.originsTags = originsTags;
     }
     public List<String> getOriginsTags() {
         return originsTags;
     }

    public void setStores(String stores) {
         this.stores = stores;
     }
     public String getStores() {
         return stores;
     }

    public void setIngredientsThatMayBeFromPalmOilTags(List<String> ingredientsThatMayBeFromPalmOilTags) {
         this.ingredientsThatMayBeFromPalmOilTags = ingredientsThatMayBeFromPalmOilTags;
     }
     public List<String> getIngredientsThatMayBeFromPalmOilTags() {
         return ingredientsThatMayBeFromPalmOilTags;
     }

    public void setExpirationDate(String expirationDate) {
         this.expirationDate = expirationDate;
     }
     public String getExpirationDate() {
         return expirationDate;
     }

    public void setGenericNameFrDebugTags(List<String> genericNameFrDebugTags) {
         this.genericNameFrDebugTags = genericNameFrDebugTags;
     }
     public List<String> getGenericNameFrDebugTags() {
         return genericNameFrDebugTags;
     }

    public void setAminoAcidsPrevTags(List<String> aminoAcidsPrevTags) {
         this.aminoAcidsPrevTags = aminoAcidsPrevTags;
     }
     public List<String> getAminoAcidsPrevTags() {
         return aminoAcidsPrevTags;
     }

    public void setKeywords(List<String> Keywords) {
         this.Keywords = Keywords;
     }
     public List<String> getKeywords() {
         return Keywords;
     }

    public void setComplete(int complete) {
         this.complete = complete;
     }
     public int getComplete() {
         return complete;
     }

    public void setManufacturingPlaces(String manufacturingPlaces) {
         this.manufacturingPlaces = manufacturingPlaces;
     }
     public String getManufacturingPlaces() {
         return manufacturingPlaces;
     }

    public void setIngredientsDebug(List<String> ingredientsDebug) {
         this.ingredientsDebug = ingredientsDebug;
     }
     public List<String> getIngredientsDebug() {
         return ingredientsDebug;
     }

    public void setLastEditor(String lastEditor) {
         this.lastEditor = lastEditor;
     }
     public String getLastEditor() {
         return lastEditor;
     }

    public void setNutritionDataPer(String nutritionDataPer) {
         this.nutritionDataPer = nutritionDataPer;
     }
     public String getNutritionDataPer() {
         return nutritionDataPer;
     }

    public void setCorrectorsTags(List<String> correctorsTags) {
         this.correctorsTags = correctorsTags;
     }
     public List<String> getCorrectorsTags() {
         return correctorsTags;
     }

    public void setServingQuantity(int servingQuantity) {
         this.servingQuantity = servingQuantity;
     }
     public int getServingQuantity() {
         return servingQuantity;
     }

    public void setStoresDebugTags(List<String> storesDebugTags) {
         this.storesDebugTags = storesDebugTags;
     }
     public List<String> getStoresDebugTags() {
         return storesDebugTags;
     }

    public void setDebugParamSortedLangs(List<String> debugParamSortedLangs) {
         this.debugParamSortedLangs = debugParamSortedLangs;
     }
     public List<String> getDebugParamSortedLangs() {
         return debugParamSortedLangs;
     }

    public void setRev(int rev) {
         this.rev = rev;
     }
     public int getRev() {
         return rev;
     }

    public void setLanguages(Languages languages) {
         this.languages = languages;
     }
     public Languages getLanguages() {
         return languages;
     }

    public void setProductNameFr(String productNameFr) {
         this.productNameFr = productNameFr;
     }
     public String getProductNameFr() {
         return productNameFr;
     }

    public void setAdditivesPrev(String additivesPrev) {
         this.additivesPrev = additivesPrev;
     }
     public String getAdditivesPrev() {
         return additivesPrev;
     }

    public void setManufacturingPlacesDebugTags(List<String> manufacturingPlacesDebugTags) {
         this.manufacturingPlacesDebugTags = manufacturingPlacesDebugTags;
     }
     public List<String> getManufacturingPlacesDebugTags() {
         return manufacturingPlacesDebugTags;
     }

    public void setCountriesDebugTags(List<String> countriesDebugTags) {
         this.countriesDebugTags = countriesDebugTags;
     }
     public List<String> getCountriesDebugTags() {
         return countriesDebugTags;
     }

    public void setPurchasePlacesDebugTags(List<String> purchasePlacesDebugTags) {
         this.purchasePlacesDebugTags = purchasePlacesDebugTags;
     }
     public List<String> getPurchasePlacesDebugTags() {
         return purchasePlacesDebugTags;
     }

    public void setLastEditDatesTags(List<String> lastEditDatesTags) {
         this.lastEditDatesTags = lastEditDatesTags;
     }
     public List<String> getLastEditDatesTags() {
         return lastEditDatesTags;
     }

    public void setUniqueScansN(int uniqueScansN) {
         this.uniqueScansN = uniqueScansN;
     }
     public int getUniqueScansN() {
         return uniqueScansN;
     }

    public void setInterfaceVersionModified(String interfaceVersionModified) {
         this.interfaceVersionModified = interfaceVersionModified;
     }
     public String getInterfaceVersionModified() {
         return interfaceVersionModified;
     }

    public void setDebugTags(List<String> debugTags) {
         this.debugTags = debugTags;
     }
     public List<String> getDebugTags() {
         return debugTags;
     }

    public void setIngredientsOriginalTags(List<String> ingredientsOriginalTags) {
         this.ingredientsOriginalTags = ingredientsOriginalTags;
     }
     public List<String> getIngredientsOriginalTags() {
         return ingredientsOriginalTags;
     }

    public void setVitaminsTags(List<String> vitaminsTags) {
         this.vitaminsTags = vitaminsTags;
     }
     public List<String> getVitaminsTags() {
         return vitaminsTags;
     }

    public void setImageFrontThumbUrl(String imageFrontThumbUrl) {
         this.imageFrontThumbUrl = imageFrontThumbUrl;
     }
     public String getImageFrontThumbUrl() {
         return imageFrontThumbUrl;
     }

    public void setUpdateKey(String updateKey) {
         this.updateKey = updateKey;
     }
     public String getUpdateKey() {
         return updateKey;
     }

    public void setInterfaceVersionCreated(String interfaceVersionCreated) {
         this.interfaceVersionCreated = interfaceVersionCreated;
     }
     public String getInterfaceVersionCreated() {
         return interfaceVersionCreated;
     }

    public void setIngredientsFromPalmOilN(int ingredientsFromPalmOilN) {
         this.ingredientsFromPalmOilN = ingredientsFromPalmOilN;
     }
     public int getIngredientsFromPalmOilN() {
         return ingredientsFromPalmOilN;
     }

    public void setLink(String link) {
         this.link = link;
     }
     public String getLink() {
         return link;
     }

    public void setCategoriesHierarchy(List<String> categoriesHierarchy) {
         this.categoriesHierarchy = categoriesHierarchy;
     }
     public List<String> getCategoriesHierarchy() {
         return categoriesHierarchy;
     }

    public void setUnknownIngredientsN(int unknownIngredientsN) {
         this.unknownIngredientsN = unknownIngredientsN;
     }
     public int getUnknownIngredientsN() {
         return unknownIngredientsN;
     }

    public void setNutritionGradesTags(List<String> nutritionGradesTags) {
         this.nutritionGradesTags = nutritionGradesTags;
     }
     public List<String> getNutritionGradesTags() {
         return nutritionGradesTags;
     }

    public void setEmbCodes20141016(String embCodes20141016) {
         this.embCodes20141016 = embCodes20141016;
     }
     public String getEmbCodes20141016() {
         return embCodes20141016;
     }

    public void setNovaGroups(String novaGroups) {
         this.novaGroups = novaGroups;
     }
     public String getNovaGroups() {
         return novaGroups;
     }

    public void setQuantity(String quantity) {
         this.quantity = quantity;
     }
     public String getQuantity() {
         return quantity;
     }

    public void setIngredientsText(String ingredientsText) {
         this.ingredientsText = ingredientsText;
     }
     public String getIngredientsText() {
         return ingredientsText;
     }

    public void setIngredientsFromOrThatMayBeFromPalmOilN(int ingredientsFromOrThatMayBeFromPalmOilN) {
         this.ingredientsFromOrThatMayBeFromPalmOilN = ingredientsFromOrThatMayBeFromPalmOilN;
     }
     public int getIngredientsFromOrThatMayBeFromPalmOilN() {
         return ingredientsFromOrThatMayBeFromPalmOilN;
     }

    public void setCodesTags(List<String> codesTags) {
         this.codesTags = codesTags;
     }
     public List<String> getCodesTags() {
         return codesTags;
     }

    public void setNutriments(Nutriments nutriments) {
         this.nutriments = nutriments;
     }
     public Nutriments getNutriments() {
         return nutriments;
     }

    public void setNutritionDataPreparedPer(String nutritionDataPreparedPer) {
         this.nutritionDataPreparedPer = nutritionDataPreparedPer;
     }
     public String getNutritionDataPreparedPer() {
         return nutritionDataPreparedPer;
     }

    public void setLc(String lc) {
         this.lc = lc;
     }
     public String getLc() {
         return lc;
     }

    public void setCountriesTags(List<String> countriesTags) {
         this.countriesTags = countriesTags;
     }
     public List<String> getCountriesTags() {
         return countriesTags;
     }

    public void setEmbCodesOrig(String embCodesOrig) {
         this.embCodesOrig = embCodesOrig;
     }
     public String getEmbCodesOrig() {
         return embCodesOrig;
     }

    public void setAdditivesTags(List<String> additivesTags) {
         this.additivesTags = additivesTags;
     }
     public List<String> getAdditivesTags() {
         return additivesTags;
     }

    public void setIngredientsTextWithAllergens(String ingredientsTextWithAllergens) {
         this.ingredientsTextWithAllergens = ingredientsTextWithAllergens;
     }
     public String getIngredientsTextWithAllergens() {
         return ingredientsTextWithAllergens;
     }

    public void setImageThumbUrl(String imageThumbUrl) {
         this.imageThumbUrl = imageThumbUrl;
     }
     public String getImageThumbUrl() {
         return imageThumbUrl;
     }

    public void setIngredientsN(String ingredientsN) {
         this.ingredientsN = ingredientsN;
     }
     public String getIngredientsN() {
         return ingredientsN;
     }

    public void setAdditivesOriginalTags(List<String> additivesOriginalTags) {
         this.additivesOriginalTags = additivesOriginalTags;
     }
     public List<String> getAdditivesOriginalTags() {
         return additivesOriginalTags;
     }

    public void setId(String Id) {
         this.Id = Id;
     }
     public String getId() {
         return Id;
     }

    public void setPnnsGroups2Tags(List<String> pnnsGroups2Tags) {
         this.pnnsGroups2Tags = pnnsGroups2Tags;
     }
     public List<String> getPnnsGroups2Tags() {
         return pnnsGroups2Tags;
     }

    public void setFruitNvegetableNnuts100gEstimate(int fruitNvegetableNnuts100gEstimate) {
         this.fruitNvegetableNnuts100gEstimate = fruitNvegetableNnuts100gEstimate;
     }
     public int getFruitNvegetableNnuts100gEstimate() {
         return fruitNvegetableNnuts100gEstimate;
     }

    public void setMineralsTags(List<String> mineralsTags) {
         this.mineralsTags = mineralsTags;
     }
     public List<String> getMineralsTags() {
         return mineralsTags;
     }

    public void setImages(Images images) {
         this.images = images;
     }
     public Images getImages() {
         return images;
     }

    public void setCompletedT(int completedT) {
         this.completedT = completedT;
     }
     public int getCompletedT() {
         return completedT;
     }

    public void setOriginsDebugTags(List<String> originsDebugTags) {
         this.originsDebugTags = originsDebugTags;
     }
     public List<String> getOriginsDebugTags() {
         return originsDebugTags;
     }

    public void setIngredientsTextDebug(String ingredientsTextDebug) {
         this.ingredientsTextDebug = ingredientsTextDebug;
     }
     public String getIngredientsTextDebug() {
         return ingredientsTextDebug;
     }

    public void setStates(String states) {
         this.states = states;
     }
     public String getStates() {
         return states;
     }

    public void setLabelsTags(List<String> labelsTags) {
         this.labelsTags = labelsTags;
     }
     public List<String> getLabelsTags() {
         return labelsTags;
     }

    public void setLabelsHierarchy(List<String> labelsHierarchy) {
         this.labelsHierarchy = labelsHierarchy;
     }
     public List<String> getLabelsHierarchy() {
         return labelsHierarchy;
     }

    public void setAminoAcidsTags(List<String> aminoAcidsTags) {
         this.aminoAcidsTags = aminoAcidsTags;
     }
     public List<String> getAminoAcidsTags() {
         return aminoAcidsTags;
     }

    public void setEmbCodes(String embCodes) {
         this.embCodes = embCodes;
     }
     public String getEmbCodes() {
         return embCodes;
     }

    public void setImageNutritionThumbUrl(String imageNutritionThumbUrl) {
         this.imageNutritionThumbUrl = imageNutritionThumbUrl;
     }
     public String getImageNutritionThumbUrl() {
         return imageNutritionThumbUrl;
     }

    public void setSortkey(int sortkey) {
         this.sortkey = sortkey;
     }
     public int getSortkey() {
         return sortkey;
     }

    public void setImageFrontSmallUrl(String imageFrontSmallUrl) {
         this.imageFrontSmallUrl = imageFrontSmallUrl;
     }
     public String getImageFrontSmallUrl() {
         return imageFrontSmallUrl;
     }

    public void setPackagingDebugTags(List<String> packagingDebugTags) {
         this.packagingDebugTags = packagingDebugTags;
     }
     public List<String> getPackagingDebugTags() {
         return packagingDebugTags;
     }

    public void setImageIngredientsUrl(String imageIngredientsUrl) {
         this.imageIngredientsUrl = imageIngredientsUrl;
     }
     public String getImageIngredientsUrl() {
         return imageIngredientsUrl;
     }

    public void setAdditivesN(int additivesN) {
         this.additivesN = additivesN;
     }
     public int getAdditivesN() {
         return additivesN;
     }

    public void setTracesDebugTags(List<String> tracesDebugTags) {
         this.tracesDebugTags = tracesDebugTags;
     }
     public List<String> getTracesDebugTags() {
         return tracesDebugTags;
     }

    public void setCheckersTags(List<String> checkersTags) {
         this.checkersTags = checkersTags;
     }
     public List<String> getCheckersTags() {
         return checkersTags;
     }

    public void setLastImageT(int lastImageT) {
         this.lastImageT = lastImageT;
     }
     public int getLastImageT() {
         return lastImageT;
     }

    public void setCategoriesDebugTags(List<String> categoriesDebugTags) {
         this.categoriesDebugTags = categoriesDebugTags;
     }
     public List<String> getCategoriesDebugTags() {
         return categoriesDebugTags;
     }

    public void setAllergensFromIngredients(String allergensFromIngredients) {
         this.allergensFromIngredients = allergensFromIngredients;
     }
     public String getAllergensFromIngredients() {
         return allergensFromIngredients;
     }

    public void setCategoriesTags(List<String> categoriesTags) {
         this.categoriesTags = categoriesTags;
     }
     public List<String> getCategoriesTags() {
         return categoriesTags;
     }

    public void setProductQuantity(int productQuantity) {
         this.productQuantity = productQuantity;
     }
     public int getProductQuantity() {
         return productQuantity;
     }

    public void setCategories(String categories) {
         this.categories = categories;
     }
     public String getCategories() {
         return categories;
     }

    public void setAllergensHierarchy(List<String> allergensHierarchy) {
         this.allergensHierarchy = allergensHierarchy;
     }
     public List<String> getAllergensHierarchy() {
         return allergensHierarchy;
     }

    public void setLastModifiedBy(String lastModifiedBy) {
         this.lastModifiedBy = lastModifiedBy;
     }
     public String getLastModifiedBy() {
         return lastModifiedBy;
     }

    public void setIngredientsFromPalmOilTags(List<String> ingredientsFromPalmOilTags) {
         this.ingredientsFromPalmOilTags = ingredientsFromPalmOilTags;
     }
     public List<String> getIngredientsFromPalmOilTags() {
         return ingredientsFromPalmOilTags;
     }

    public void setUnknownNutrientsTags(List<String> unknownNutrientsTags) {
         this.unknownNutrientsTags = unknownNutrientsTags;
     }
     public List<String> getUnknownNutrientsTags() {
         return unknownNutrientsTags;
     }

    public void setId(Long id) {
        this.id = id;
    }
}