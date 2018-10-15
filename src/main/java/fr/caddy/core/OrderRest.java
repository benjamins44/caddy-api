package fr.caddy.core;

import com.google.gson.Gson;
import fr.caddy.common.bean.Order;
import fr.caddy.common.bean.Product;
import fr.caddy.common.bean.ProductInstance;
import fr.caddy.common.bean.User;
import fr.caddy.core.dao.UserDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/refresh")
    public void extract() {

        final User user = userDao.findByLogin("bcorre");
        final String customer = user.getLoginCoursesU();
        final String password = user.getPasswordCoursesU();
        final List<Order> orders = orderService.getNewOrders(customer, password);

        final List<Product> products = productService.calculateConsumptions(orders);
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
        productService.calculateAverage(products);
        productService.calculateProbabilities(products);
        Order order = productService.prepareOrder(customer);
        LOG.info(""+order.getProductInstances().size());
        LOG.info(new Gson().toJson(order));
    }

}