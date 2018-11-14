package fr.caddy.core.service.impl;

import fr.caddy.common.bean.*;
import fr.caddy.common.bean.ext.ProductU;
import fr.caddy.common.bean.opendfoodfact.ProductsU;
import fr.caddy.common.bean.opendfoodfact.ProductOpenFoodFact;
import fr.caddy.common.constants.Constants;
import fr.caddy.core.dao.*;
import fr.caddy.core.service.OpenFoodFactService;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ProductInstanceServiceImpl implements ProductInstanceService {

    private static final Logger LOG = Logger.getLogger(ProductInstanceServiceImpl.class.getName());

    @Autowired
    private ProductInstanceDao productInstanceDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OpenFoodFactService openFoodFactService;

    @Autowired
    private CounterDao counterDao;

    @Autowired
    private ProductsUDao productsUDao;

    @Autowired
    private OffCoursesUDao offCoursesUDao;

    @Autowired
    private AdditiveDao additiveDao;

    /**
     * Return the product instance of the history order product
     * Save it if not exists
     * @param historyOrderproduct
     * @return
     */
    public ProductInstance getOrSave(HistoryOrderProduct historyOrderproduct, String sign) {
        Boolean saveDone = false;
        // test to get it
        List<ProductInstance> productsInstance = productInstanceDao.findByIdExtAndSign(historyOrderproduct.getId(), sign);
        ProductInstance productInstance = null;
        if (productsInstance.size() > 0) {
            productInstance = productsInstance.get(0);
        }
        if (productInstance == null) {
            // create it
            productInstance = new ProductInstance();
            productInstance.setCategory(historyOrderproduct.getCategory());
            productInstance.setProductShops(new ArrayList<ProductShop>());
            // copy property
            BeanUtils.copyProperties(historyOrderproduct, productInstance);
            productInstance.setQuantity(null);
            productInstance.setImage(historyOrderproduct.getUrl());
            // generate Id
            productInstance.setId(counterDao.getNextSequence(ProductInstance.COLLECTION_NAME));
            // create product shop
            ProductShop productShop = new ProductShop();
            // copy property
            BeanUtils.copyProperties(historyOrderproduct, productShop);
            productShop.setSign(sign);
            productInstance.getProductShops().add(productShop);
            final List<OffCoursesU> offCoursesU  = offCoursesUDao.findByIdCoursesU(productShop.getId());
            if (offCoursesU != null && offCoursesU.size() > 0) {
                productInstance.setOpenFoodFactId(offCoursesU.get(0).getId());
                final Optional<ProductsU> productU = productsUDao.findByCode(offCoursesU.get(0).getCode());
                if (productU.isPresent()) {
                    this.refresh(productInstance, productU.get());
                    saveDone = true;
                }
            }
            // save it
            if (!saveDone) {
                productInstanceDao.save(productInstance);
            }
        }
        return productInstance;
    }

    /**
     * Refresh informations from openfodofact
     * @param productInstance
     */
    public Integer refresh(ProductInstance productInstance) {
        Integer result = 0;
        // get open food fact product
        if (productInstance.getOpenFoodFactId() != null) {
            ProductOpenFoodFact productOpen = openFoodFactService.getById(productInstance.getOpenFoodFactId());
            result += this.refresh(productInstance, productOpen.getProduct());
        }
        return result;
    }
    public Integer refresh(ProductInstance productInstance, ProductsU productOpen) {
        Integer result = 0;
        // get open food fact product
        if (productInstance.getOpenFoodFactId() != null) {
            //LOG.info(String.format("Refresh %s productInstanceId with %s openFoodFactId", productInstance.getId(), productInstance.getOpenFoodFactId()));
            //TODO bug à corriger
            if ("Carte U".equals(productInstance.getLabel())) {
                productInstance.setLabel(productOpen.getProductName());
                result++;
            }
            // category
            if (!StringUtils.isEmpty(productOpen.getCategories())
                && !productOpen.getCategories().equals(productInstance.getCategory())) {
                productInstance.setCategory(productOpen.getCategories());
                result++;
            }
            // nova
            if (!StringUtils.isEmpty(productOpen.getNovaGroup())
                    && !productOpen.getNovaGroup().equals(productInstance.getNova())) {
                productInstance.setNova(Integer.valueOf(productOpen.getNovaGroup()));
                result++;
            }
            // nutriscore
            if (!StringUtils.isEmpty(productOpen.getNutritionGradeFr())
                && !productOpen.getNutritionGradeFr().equals(productInstance.getNutriscore())) {
                productInstance.setNutriscore(productOpen.getNutritionGradeFr());
                result++;
            }
            // image
            if (!StringUtils.isEmpty(productOpen.getImageUrl())
                && !productOpen.getImageUrl().equals(productInstance.getImage())) {
                productInstance.setImage(productOpen.getImageUrl());
                result++;
            }
            // unit weight
            if (productOpen.getServingQuantity() > 0
                 && (productInstance.getUnitWeight() == null ||
                     productOpen.getServingQuantity() != productInstance.getUnitWeight())) {
                productInstance.setUnitWeight(Integer.valueOf(productOpen.getServingQuantity()));
                result++;
            }
            // total weight
            if (productOpen.getProductQuantity() > 0
                && (productInstance.getUnitWeight() == null ||
                    productOpen.getProductQuantity() != productInstance.getUnitWeight())) {
                productInstance.setTotalWeight(productOpen.getProductQuantity());
                result++;
            }
            // unit
            if (!StringUtils.isEmpty(productOpen.getServingSize())
                && !productOpen.getServingSize().equals(productInstance.getUnit())) {
                final String[] servingSize = productOpen.getServingSize().split(" ");
                if (servingSize != null && servingSize.length > 1) {
                    productInstance.setUnit(servingSize[1]);
                }
                result++;
            }
            // unit count
            if (productInstance.getTotalWeight() != null && productInstance.getUnitWeight() != null &&
                    (productInstance.getUnitCount() == null ||
                    (productInstance.getTotalWeight() / productInstance.getUnitWeight()) != productInstance.getUnitCount())) {
                productInstance.setUnitCount(productInstance.getTotalWeight() / productInstance.getUnitWeight());
                result++;
            }
            if (!StringUtils.isEmpty(productOpen.getProductName())) {
                productInstance.setLabel2(productOpen.getProductName());
                result++;
            }
            if (!StringUtils.isEmpty(productOpen.getIngredientsTextWithAllergens())) {
                productInstance.setIngredientsList(productOpen.getIngredientsTextWithAllergens());
                result++;
            }
            if (!StringUtils.isEmpty(productOpen.getTracesHierarchy())) {
                productInstance.setTraces(productOpen.getTracesHierarchy());
                result++;
            }
            if (productOpen.getAllergensTags() != null && productOpen.getAllergensTags().size() > 0) {
                productInstance.setAllergens(productOpen.getAllergensTags());
                result++;
            }
            if (!StringUtils.isEmpty(productOpen.getNutrientLevels())) {
                //productInstance.setNutrientsLevel(productOpen.getNutrientLevels());
                result++;
            }
            if (productOpen.getAdditivesTags() != null && productOpen.getAdditivesTags().size() > 0) {
                productInstance.setAdditives(this.getAdditives(productOpen.getAdditivesTags()));
                result++;
            }
            if (!StringUtils.isEmpty(productOpen.getComplete())) {
                productInstance.setComplete(productOpen.getComplete());
                result++;
            }

            //LOG.info(String.format("End Refresh, %s datas modified", result));
        }
        // set default image
        if (StringUtils.isEmpty(productInstance.getImage()) && productInstance.getProductShops().size() > 0) {
            productInstance.setImage(productInstance.getProductShops().get(0).getUrl());
            result++;
        }
        if (result > 0) {
            this.calculateFoodScore(productInstance);
            // save it
            productInstanceDao.save(productInstance);
        }
        return result;
    }

    private void calculateFoodScore(ProductInstance product) {
        // no calculate if not completed
        if (product.getComplete() != 1) {
            return;
        }
        if (product.getFoodScore() == null) {
            product.setFoodScore(new FoodScore());
        }
        final FoodScore foodScore = product.getFoodScore();
        // additives
        Integer score = 0;
        if (product.getAdditives() != null) {
            for (ProductAdditives productAdditives : product.getAdditives()) {
                Integer factor = 1;
                switch (productAdditives.getRiskLevel()) {
                    case 2:
                        factor = 10;
                        break;
                    case 3:
                        factor = 50;
                        break;
                    case 4:
                        factor = 100;
                        break;
                    case 5:
                        factor = 500;
                        break;
                    case 6:
                        factor = 1000;
                        break;
                }

                score += factor * productAdditives.getAdditives().size();
            }
        }
        foodScore.setAdditivesScore(score);
        // nutriscore
        score = null;
        if (product.getNutriscore() != null) {
            switch (product.getNutriscore()) {
                case "a":
                    score = 1;
                    break;
                case "b":
                    score = 10;
                    break;
                case "c":
                    score = 100;
                    break;
                case "d":
                    score = 1000;
                    break;
                case "e":
                    score = 10000;
                    break;
            }
        }
        foodScore.setNutriscoreScore(score);
        // novascore
        score = null;
        if (product.getNova() != null) {
            switch (product.getNova()) {
                case 1:
                    score = 1;
                    break;
                case 2:
                    score = 10;
                    break;
                case 3:
                    score = 100;
                    break;
                case 4:
                    score = 1000;
                    break;
                case 5:
                    score = 10000;
                    break;
            }
        }
        foodScore.setNovaScore(score);
        // total
        if (foodScore.getAdditivesScore() != null && foodScore.getNovaScore() != null && foodScore.getNutriscoreScore() != null) {
            final Integer total = foodScore.getAdditivesScore() + foodScore.getNovaScore() + foodScore.getNutriscoreScore();
            foodScore.setTotal(total);
        }
    }

    private List<ProductAdditives> getAdditives(List<String> additivesTags) {
        final Map<Integer, ProductAdditives> mapAdditives = new HashMap<>();
        for (String additivesTag:additivesTags) {
            final String tag = additivesTag.split(":")[1].toUpperCase();
            final Optional<Additives> opAdditive = this.additiveDao.findByCodeIgnoreCase(tag);
            if (opAdditive.isPresent()) {
                final Additives additive = opAdditive.get();
                ProductAdditives productAdditives = mapAdditives.get(additive.getRiskLevel());
                if (productAdditives == null) {
                    productAdditives = new ProductAdditives();
                    productAdditives.setAdditives(new ArrayList<>());
                    productAdditives.setRiskLevel(additive.getRiskLevel());
                }
                productAdditives.getAdditives().add(additive);
                mapAdditives.put(additive.getRiskLevel(), productAdditives);
            }
        }
        return mapAdditives.values().stream().collect(Collectors.toList());
    }

    /**
     * Refresh product instance and all depedencies
     * @param productInstance
     */
    public void refreshAndUpdateDepedencies(ProductInstance productInstance, ProductsU productsU) {
        final Integer nbChg = this.refresh(productInstance, productsU);
        if (nbChg > 0) {
            // change product instance of all products
            productService.refreshProductInstance(productInstance);
            orderService.refreshProductInstance(productInstance);
        }
    }
    public void refreshAndUpdateDepedencies(ProductInstance productInstance) {
        final Integer nbChg = this.refresh(productInstance);
        if (nbChg > 0) {
            // change product instance of all products
            productService.refreshProductInstance(productInstance);
            orderService.refreshProductInstance(productInstance);
        }
    }

    public void refreshAll() {
        final List<OffCoursesU> offCoursesUs =  offCoursesUDao.findAll();
        for (OffCoursesU offCoursesU: offCoursesUs) {
            final Long idCoursesU = offCoursesU.getIdCoursesU();
            if (idCoursesU != null) {
                ProductInstance productInstance = productInstanceDao.findByOpenFoodFactId(offCoursesU.getId());
                if (productInstance == null) {
                    productInstance = new ProductInstance();
                    // generate Id
                    productInstance.setId(counterDao.getNextSequence(ProductInstance.COLLECTION_NAME));
                    productInstance.setOpenFoodFactId(offCoursesU.getId());
                    productInstance.setLabel(offCoursesU.getLabel());
                    productInstance.setImage(offCoursesU.getUrl());
                    List<ProductShop> productShops = new ArrayList<>();
                    ProductShop productShop = new ProductShop();
                    productShop.setSign(Constants.SIGN_U);
                    productShop.setLabel(offCoursesU.getLabel());
                    productShop.setId(offCoursesU.getIdCoursesU());
                    productShop.setUrl(offCoursesU.getUrl());
                    productShops.add(productShop);
                    productInstance.setProductShops(productShops);
                }
                final Optional<ProductsU> productU = productsUDao.findByCode(offCoursesU.getCode());
                if (productU.isPresent()) {
                    this.refreshAndUpdateDepedencies(productInstance, productU.get());
                }
                productInstanceDao.save(productInstance);
            }
        }
    }

    @Override
    public List<ProductInstance> getAll() {
        return productInstanceDao.findAll();
    }

    @Override
    public ProductInstance getById(Long id) {
        return productInstanceDao.findById(id).get();
    }

    /**
     * Return all products instance like label
     * @return
     */
    @Override
    public List<ProductInstance> getByLabeLike(String label) {
        return productInstanceDao.findByLabelContainingIgnoreCase(label);
    }

    @Override
    public ProductInstance update(ProductInstance productInstance) {
        productInstanceDao.save(productInstance);
        return productInstance;
    }

    @Override
    public ProductInstance create(ProductInstance productInstance) {
        // generate id
        productInstance.setId(counterDao.getNextSequence(ProductInstance.COLLECTION_NAME));
        productInstanceDao.save(productInstance);
        return productInstance;
    }

    @Override
    public void delete(ProductInstance productInstance) {
        productInstanceDao.delete(productInstance);
    }
}
