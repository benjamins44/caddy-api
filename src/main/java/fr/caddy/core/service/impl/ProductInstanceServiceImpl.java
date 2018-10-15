package fr.caddy.core.service.impl;

import com.google.common.collect.Lists;
import fr.caddy.common.bean.HistoryOrderProduct;
import fr.caddy.common.bean.ProductInstance;
import fr.caddy.common.bean.ProductShop;
import fr.caddy.common.bean.opendfoodfact.ProductOpenFoodFact;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.ProductInstanceDao;
import fr.caddy.core.service.OpenFoodFactService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductInstanceServiceImpl implements ProductInstanceService {

    private static final Logger LOG = Logger.getLogger(ProductInstanceServiceImpl.class.getName());

    @Autowired
    private ProductInstanceDao productInstanceDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private OpenFoodFactService openFoodFactService;

    @Autowired
    private CounterDao counterDao;

    /**
     * Return the product instance of the history order product
     * Save it if not exists
     * @param historyOrderproduct
     * @return
     */
    public ProductInstance getOrSave(HistoryOrderProduct historyOrderproduct, String sign) {
        // test to get it
        List<ProductInstance> productsInstance = productInstanceDao.findByIdExtAndSign(historyOrderproduct.getId(), sign);
        ProductInstance productInstance = null;
        if (productsInstance.size() > 0) {
            productInstance = productsInstance.get(0);
        }
        if (productInstance == null) {
            // create it
            productInstance = new ProductInstance();
            productInstance.setProductShops(new ArrayList<ProductShop>());
            // copy property
            BeanUtils.copyProperties(historyOrderproduct, productInstance);
            productInstance.setQuantity(null);
            // generate Id
            productInstance.setId(counterDao.getNextSequence(ProductInstance.COLLECTION_NAME));
            // create product shop
            ProductShop productShop = new ProductShop();
            // copy property
            BeanUtils.copyProperties(historyOrderproduct, productShop);
            productShop.setSign(sign);
            productInstance.getProductShops().add(productShop);
            // save it
            productInstanceDao.save(productInstance);
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
            LOG.info(String.format("Refresh %s productInstanceId with %s openFoodFactId", productInstance.getId(), productInstance.getOpenFoodFactId()));
            ProductOpenFoodFact productOpen = openFoodFactService.getById(productInstance.getOpenFoodFactId());
            LOG.info(productOpen.toString());
            // label
            if (!StringUtils.isEmpty(productOpen.getProduct().getProductName())
                && !productOpen.getProduct().getProductName().equals(productInstance.getLabel())) {
                productInstance.setLabel(productOpen.getProduct().getProductName());
                result++;
            }
            // category
            if (!StringUtils.isEmpty(productOpen.getProduct().getCategories())
                && !productOpen.getProduct().getCategories().equals(productInstance.getCategory())) {
                productInstance.setCategory(Lists.newArrayList(productOpen.getProduct().getCategories().split(",")));
                result++;
            }
            // nova
            if (!StringUtils.isEmpty(productOpen.getProduct().getNovaGroup())
                    && !productOpen.getProduct().getNovaGroup().equals(productInstance.getNova())) {
                productInstance.setNova(Integer.valueOf(productOpen.getProduct().getNovaGroup()));
                result++;
            }
            // nutriscore
            if (!StringUtils.isEmpty(productOpen.getProduct().getNutritionGradeFr())
                && !productOpen.getProduct().getNutritionGradeFr().equals(productInstance.getNutriscore())) {
                productInstance.setNutriscore(productOpen.getProduct().getNutritionGradeFr());
                result++;
            }
            // image
            if (!StringUtils.isEmpty(productOpen.getProduct().getImageUrl())
                && !productOpen.getProduct().getImageUrl().equals(productInstance.getImage())) {
                productInstance.setImage(productOpen.getProduct().getImageUrl());
                result++;
            }
            // unit weight
            if (productOpen.getProduct().getServingQuantity() > 0
                && productOpen.getProduct().getServingQuantity() != productInstance.getUnitWeight()) {
                productInstance.setUnitWeight(Integer.valueOf(productOpen.getProduct().getServingQuantity()));
                result++;
            }
            // total weight
            if (productOpen.getProduct().getProductQuantity() > 0
                && productOpen.getProduct().getProductQuantity() != productInstance.getUnitWeight()) {
                productInstance.setTotalWeight(productOpen.getProduct().getProductQuantity());
                result++;
            }
            // unit
            if (!StringUtils.isEmpty(productOpen.getProduct().getServingSize())
                && !productOpen.getProduct().getServingSize().equals(productInstance.getUnit())) {
                productInstance.setUnit(productOpen.getProduct().getServingSize().split(" ")[1]);
                result++;
            }
            // unit count
            if (productInstance.getTotalWeight() > 0 && productInstance.getUnitWeight() > 0
                && (productInstance.getTotalWeight() / productInstance.getUnitWeight()) != productInstance.getUnitCount()) {
                productInstance.setUnitCount(productInstance.getTotalWeight() / productInstance.getUnitWeight());
                result++;
            }
            LOG.info(String.format("End Refresh, %s datas modified", result));
        }
        if (result > 0) {
            // save it
            productInstanceDao.save(productInstance);
        }
        return result;
    }

    /**
     * Refresh product instance and all depedencies
     * @param productInstance
     */
    public void refreshAndUpdateDepedencies(ProductInstance productInstance) {
        final Integer nbChg = this.refresh(productInstance);
        if (nbChg > 0) {
            // change product instance of all products
            productService.refreshProductInstance(productInstance);
        }
    }
}
