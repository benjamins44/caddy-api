package fr.caddy.core;

import fr.caddy.common.bean.*;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.PreOrderService;
import fr.caddy.coursesu.basket.service.BasketUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("preorders")
public class PreOrderRest {

    private static final Logger LOG = Logger.getLogger(PreOrderRest.class.getName());

    @Autowired
    private PreOrderService preOrderService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BasketUService basketUService;

    @RequestMapping(value="{customer}", method = RequestMethod.GET)
    public List<PreOrder > get(@PathVariable("customer") String customer) {
        return preOrderService.getAll(customer);
    }

    @RequestMapping(value="{customer}/last", method = RequestMethod.GET)
    public PreOrder getLast(@PathVariable("customer") String customer) {
        return preOrderService.getLastByCustomer(customer);
    }


    @RequestMapping(value="{customer}/{id}", method = RequestMethod.GET)
    public PreOrder getById(@PathVariable("id") Long id) {
        return preOrderService.getById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public PreOrder update(@PathVariable("id") Long id, @RequestBody PreOrder preOrder) {
        return preOrderService.save(preOrder);
    }

    @RequestMapping(value="{customer}/prepare", method = RequestMethod.GET)
    public PreOrder prepare(@PathVariable("customer") String customer) {
        return preOrderService.prepareOrder(customer);
    }

    @GetMapping("{id}/order")
    public PreOrder order(@PathVariable("id") Long id) {
        final User user = userDao.findByLogin("bcorre");
        final PreOrder preOrder = this.getById(id);
        if (preOrder != null) {
            final List<BasketPurchase> basket = new ArrayList<>();
            for (Product product : preOrder.getProducts()) {
                BasketPurchase basketPurchase = new BasketPurchase();
                ProductShop productShop = product.getFavorite().getProductShops().get(0);
                basketPurchase.setIdProduct(productShop.getId());
                basketPurchase.setLabel(productShop.getLabel());
                basketPurchase.setQuantity(product.getQuantity());
                basketPurchase.setSign(productShop.getSign());
                basket.add(basketPurchase);
            }
            // prepare basket on coursesu
            basketUService.basket(basket, user.getLoginCoursesU(), user.getPasswordCoursesU());
            // update order
            preOrder.setOrdered(true);
            this.update(preOrder.getId(), preOrder);
        }
        return preOrder;
    }

}