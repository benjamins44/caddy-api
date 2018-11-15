package fr.caddy.core.service.impl;

import fr.caddy.common.bean.ProductInstance;
import fr.caddy.common.bean.ProductsGrouping;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.ProductsGroupingDao;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductsGroupingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ProductsGroupingServiceImpl implements ProductsGroupingService {

    private static final Logger LOG = Logger.getLogger(ProductsGroupingServiceImpl.class.getName());

    @Autowired
    private ProductsGroupingDao productsGroupingDao;

    @Autowired
    private CounterDao counterDao;

    @Autowired
    private ProductInstanceService productInstanceService;


    @Override
    public List<ProductsGrouping> getAll() {
        return productsGroupingDao.findAll();
    }

    @Override
    public ProductsGrouping getById(Long id) {
        return productsGroupingDao.findById(id).get();
    }

    @Override
    public Optional<ProductsGrouping> getByCategories(List<String> categories) {
        return productsGroupingDao.findByCategories(categories);
    }

    @Override
    public ProductsGrouping update(ProductsGrouping productsGrouping) {
        return productsGroupingDao.save(productsGrouping);
    }

    @Override
    public void delete(ProductsGrouping productsGrouping) {
        productsGroupingDao.delete(productsGrouping);
    }

    @Override
    public List<ProductsGrouping> save(List<ProductsGrouping> productsGroupings) {
        return productsGroupingDao.saveAll(productsGroupings);
    }

    @Override
    public ProductsGrouping save(ProductsGrouping productsGrouping) {
        return productsGroupingDao.save(productsGrouping);
    }

    @Override
    public ProductsGrouping create(ProductsGrouping productsGrouping) {
        // generate id
        productsGrouping.setId(counterDao.getNextSequence(ProductsGrouping.COLLECTION_NAME));
        return this.productsGroupingDao.save(productsGrouping);
    }

    @Override
    public void deleteAll() {
        this.productsGroupingDao.deleteAll();
    }

    @Override
    public void autoCreateAll() {
        // delete all old
        this.deleteAll();
        // refresh productInstances
        productInstanceService.refreshAll();
        // grouping by categories
        final List<ProductInstance> productInstances = productInstanceService.getAll();
        for (ProductInstance productInstance: productInstances) {
            if (!StringUtils.isEmpty(productInstance.getCategories()) && productInstance.getFoodScore() != null && productInstance.getFoodScore().getTotal() != null) {
                // group by categories
                Optional<ProductsGrouping> optProductsGrouping = this.productsGroupingDao.findByCategories(productInstance.getCategories());
                ProductsGrouping productsGrouping = null;
                if (!optProductsGrouping.isPresent()) {
                    productsGrouping = new ProductsGrouping();
                    productsGrouping.setProductInstance(new ArrayList<>());
                    productsGrouping.setCategories(productInstance.getCategories());
                    productsGrouping = this.create(productsGrouping);
                } else {
                    productsGrouping = optProductsGrouping.get();
                }
                productsGrouping.getProductInstance().add(productInstance);
                productsGrouping.setDate(LocalDate.now());
                this.save(productsGrouping);
            }
        }
        // for each productsGrouping
        for (ProductsGrouping productsGrouping: this.productsGroupingDao.findAll()) {
            // sort productInstances by foodscore
            productsGrouping.setProductInstance(
                productsGrouping.getProductInstance().stream().sorted((o1, o2) -> o1.getFoodScore().getTotal() - o2.getFoodScore().getTotal()).collect(Collectors.toList())
            );
            ProductInstance best = productsGrouping.getProductInstance().get(0);
            Integer bestScore = best.getFoodScore().getTotal();
            Double maxScore = bestScore * 1.5;
            // add best products by foodscore
            List<ProductInstance> bests = new ArrayList<>();
            for (ProductInstance productInstance: productsGrouping.getProductInstance()) {
                if (productInstance.getFoodScore().getTotal() <= maxScore) {
                    bests.add(productInstance);
                }
            }
            productsGrouping.setBestProductInstance(bests);
            this.save(productsGrouping);
        }
    }

}
