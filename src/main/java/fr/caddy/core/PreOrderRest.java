package fr.caddy.core;

import com.google.gson.Gson;
import fr.caddy.common.bean.*;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.PreOrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
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

    @RequestMapping(value="{customer}/{id}", method = RequestMethod.GET)
    public PreOrder getById(@PathVariable("id") Long id) {
        return preOrderService.getById(id);
    }

    @RequestMapping(value="{customer}/prepare", method = RequestMethod.GET)
    public PreOrder prepare(@PathVariable("customer") String customer) {
        return preOrderService.prepareOrder(customer);
    }

  /*  @GetMapping("/calculate")
    public void calculate() {
        final User user = userDao.findByLogin("bcorre");
        final String customer = user.getLoginCoursesU();
        final List<Product> products = productService.getAll(customer);
        productService.calculateConsumptions(products);
        productService.calculateAverage(products);
        productService.calculateProbabilities(products);
        Order order = productService.prepareOrder(customer);
        LOG.info(""+order.getProducts().size());
        LOG.info(new Gson().toJson(order));

        final List<BasketPurchase> basket = new ArrayList<>();
        for (Product product: order.getProducts()) {
            BasketPurchase basketPurchase = new BasketPurchase();
            ProductShop productShop = product.getProductInstances().get(0).getProductShops().get(0);
            basketPurchase.setIdProduct(productShop.getId());
            basketPurchase.setLabel(productShop.getLabel());
            basketPurchase.setQuantity(product.getQuantity());
            basketPurchase.setSign(productShop.getSign());
            basket.add(basketPurchase);
        }

        //basketUService.basket(basket, customer, user.getPasswordCoursesU());
    }*/

}