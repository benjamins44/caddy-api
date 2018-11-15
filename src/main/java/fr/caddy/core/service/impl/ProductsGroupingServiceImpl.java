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
            if (!StringUtils.isEmpty(productInstance.getCategories())) {
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
        // for each productsµGrouping
        for (ProductsGrouping productsGrouping: this.productsGroupingDao.findAll()) {
            // add best products
            List<ProductInstance> bests = new ArrayList<>();
            Integer bestLetterScore = 5;
            for (ProductInstance productInstance: productsGrouping.getProductInstance()) {
                if (!StringUtils.isEmpty(productInstance.getNutriscore())) {
                    Integer letterScore = 5;
                    switch (productInstance.getNutriscore()) {
                        case "a":
                            letterScore = 1;
                            break;
                        case "b":
                            letterScore = 2;
                            break;
                        case "c":
                            letterScore = 3;
                            break;
                        case "d":
                            letterScore = 4;
                            break;
                    }
                    if (letterScore < bestLetterScore) {
                        bests = new ArrayList<>();
                    }
                    if (letterScore <= bestLetterScore) {
                        bests.add(productInstance);
                        bestLetterScore = letterScore;
                    }
                }
            }
            productsGrouping.setBestProductInstance(bests);
            this.save(productsGrouping);
        }
    }

}
