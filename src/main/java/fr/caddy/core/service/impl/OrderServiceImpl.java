package fr.caddy.core.service.impl;

import fr.caddy.common.bean.*;
import fr.caddy.common.constants.Constants;
import fr.caddy.core.dao.CounterDao;
import fr.caddy.core.dao.OrderDao;
import fr.caddy.core.service.OrderService;
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
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class.getName());

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductInstanceService productInstanceService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CounterDao counterDao;

    @Autowired
    private HistoryUServiceImpl historyUService;

    /**
     * Return the order of the history order
     * Save it if not exists
     * @param historyOrder
     * @return
     */
    public Order getOrSave(HistoryOrder historyOrder) {
        // test to get it
        Order order = orderDao.findByIdExtAndSign(historyOrder.getId(), historyOrder.getSign());
        if (order == null) {
            // create it
            order = new Order();
            order.setProducts(new ArrayList<>());
            // copy property
            BeanUtils.copyProperties(historyOrder, order);
            // generate Id
            order.setId(counterDao.getNextSequence(Order.COLLECTION_NAME));
            // id ext
            order.setIdExt(historyOrder.getId());
            // get and save product instances
            for (HistoryOrderProduct historyOrderProduct : historyOrder.getProductOrders()) {
                final ProductInstance productInstance = productInstanceService.getOrSave(historyOrderProduct, historyOrder.getSign());
                final Product product = productService.getOrSave(productInstance, order.getCustomer());
                // set quantity
                product.setQuantity(historyOrderProduct.getQuantity());
                order.getProducts().add(product);
            }
            // save it
            orderDao.save(order);
        }
        return order;
    }

    /**
     * Return the list of order of the list of history order
     * @param historyOrders
     * @return
     */
    public List<Order> getOrSave(List<HistoryOrder> historyOrders) {
        List<Order> list = new ArrayList<Order>();
        for (HistoryOrder historyOrder: historyOrders) {
            list.add(this.getOrSave(historyOrder));
        }
        return list;
    }

    /**
     * Extract new orders from CoursesU, ...
     * @param customer
     */
    public List<Order> getNewOrders(final String customer, final String password) {
        // courses U, get last order
        final Order order = this.orderDao.findFirstBySignAndCustomerOrderByIdExtDesc(Constants.SIGN_U, customer);
        Long id = 0L;
        if (order != null) {
            id = order.getIdExt();
        }
        LOG.info(String.format("last order U : %s", id));
        // extract last orders
        final List<HistoryOrder> historyOrders = this.historyUService.getNewHistory(customer, password, id);
        // save them
        final List<Order> orders = this.getOrSave(historyOrders);
        return orders;
    }

    @Override
    public List<Order> getAll(String customer) {
        return orderDao.findByCustomer(customer);
    }

    @Override
    public Order getById(Long id) {
        return orderDao.findById(id).get();
    }

    /**
     * Refresh product instance of all products
     * @param productInstance
     */
    @Override
    public void refreshProductInstance(ProductInstance productInstance) {
        List<Order> orders = orderDao.findByIdProductInstance(productInstance.getId());
        for (Order order: orders) {
            for (Product product: order.getProducts()) {
                if (product.getFavorite().getId().equals(productInstance.getId())) {
                    // refresh productInstance into product
                    product.setFavorite(productInstance);
                }
            }
            // save it
            orderDao.save(order);
        }
    }

}
