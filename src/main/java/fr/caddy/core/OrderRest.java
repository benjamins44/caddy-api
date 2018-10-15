package fr.caddy.core;

import com.google.gson.Gson;
import fr.caddy.common.bean.*;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import fr.caddy.coursesu.basket.service.BasketUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("orders")
public class OrderRest {

    private static final Logger LOG = Logger.getLogger(OrderRest.class.getName());

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInstanceService productInstanceService;

    @Autowired
    private BasketUService basketUService;

    @GetMapping("/refresh")
    public void extract() {

        final User user = userDao.findByLogin("bcorre");
        final String customer = user.getLoginCoursesU();
        final String password = user.getPasswordCoursesU();
        final List<Order> orders = orderService.getNewOrders(customer, password);

        final List<Product> products = productService.calculateConsumptionsOfOrders(orders);
        productService.calculateAverage(products);
    }

    @GetMapping("/open")
    public void open() {

        final User user = userDao.findByLogin("bcorre");
        final String customer = user.getLoginCoursesU();

        final List<Product> products = productService.getAll(customer);
        for (Product product: products) {
            productInstanceService.refresh(product.getProductInstances().get(0));
        }
    }


    @GetMapping("/calculate")
    public void calculate() {
        final User user = userDao.findByLogin("bcorre");
        final String customer = user.getLoginCoursesU();
        final List<Product> products = productService.getAll(customer);
        productService.calculateConsumptions(products);
        productService.calculateAverage(products);
        productService.calculateProbabilities(products);
        Order order = productService.prepareOrder(customer);
        LOG.info(""+order.getProductInstances().size());
        LOG.info(new Gson().toJson(order));

        final List<BasketPurchase> basket = new ArrayList<>();
        for (ProductInstance productInstance: order.getProductInstances()) {
            BasketPurchase basketPurchase = new BasketPurchase();
            ProductShop productShop = productInstance.getProductShops().get(0);
            basketPurchase.setIdProduct(productShop.getId());
            basketPurchase.setLabel(productShop.getLabel());
            basketPurchase.setQuantity(productInstance.getQuantity());
            basketPurchase.setSign(productShop.getSign());
            basket.add(basketPurchase);
        }

        //basketUService.basket(basket, customer, user.getPasswordCoursesU());
    }

}