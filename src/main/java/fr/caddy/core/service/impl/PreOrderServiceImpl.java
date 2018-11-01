package fr.caddy.core.service.impl;

import fr.caddy.common.bean.*;
import fr.caddy.common.constants.Constants;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.OrderDao;
import fr.caddy.core.dao.PreOrderDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.PreOrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import fr.caddy.coursesu.history.service.impl.HistoryUServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PreOrderServiceImpl implements PreOrderService {

    private static final Logger LOG = Logger.getLogger(PreOrderServiceImpl.class.getName());

    @Autowired
    private PreOrderDao preOrderDao;

    @Autowired
    private CounterDao counterDao;

    @Autowired
    private ProductService productService;

    @Override
    public List<PreOrder> getAll(String customer) {
        return preOrderDao.findByCustomer(customer);
    }

    @Override
    public PreOrder getById(Long id) {
        return preOrderDao.findById(id).get();
    }

    @Override
    public PreOrder create(PreOrder preOrder) {
        // generate id
        preOrder.setId(counterDao.getNextSequence(PreOrder.COLLECTION_NAME));
        return this.preOrderDao.save(preOrder);
    }
    @Override
    public PreOrder prepareOrder(String customer) {
        // get all of the customers
        final List<Product> products = productService.getAll(customer);
        final PreOrder preOrder = new PreOrder();
        for (Product product: products) {
            final Float propability = product.getConsumption().getProbalilityBuy();
            // test with seuil 90%
            if (propability > ProductServiceImpl.PERCENT_TO_ORDER) {
                // cast to int the quantity (pas de gestion des produits au poids)
                final Integer quantity = product.getConsumption().getProbalilityQuantityBuy().intValue();
                product.setQuantity(quantity.floatValue());
                preOrder.getProducts().add(product);
            }
        }
        this.create(preOrder);
        return preOrder;
    }
}
