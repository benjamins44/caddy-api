package fr.caddy.core;

import com.google.gson.Gson;
import fr.caddy.common.bean.*;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.OrderService;
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

    @RequestMapping(value="{customer}", method = RequestMethod.GET)
    public List<Order> get(@PathVariable("customer") String customer) {
        return orderService.getAll(customer);
    }

    @RequestMapping(value="{customer}/{id}", method = RequestMethod.GET)
    public Order getById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }


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
}