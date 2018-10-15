package fr.caddy.coursesu.history.service.impl;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.core.dao.ProductDao;
import fr.caddy.core.dao.ProductInstanceDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import fr.caddy.coursesu.helper.HomePage;
import fr.caddy.coursesu.helper.OrderPage;
import fr.caddy.coursesu.helper.OrdersPage;
import fr.caddy.coursesu.helper.WelcomePage;
import fr.caddy.coursesu.history.dao.HistoryOrderDao;
import fr.caddy.coursesu.history.service.HistoryUService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryUServiceImpl implements HistoryUService {

    @Autowired
    private HistoryOrderDao historyOrderDao;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInstanceService productInstanceService;

    @Autowired
    private ProductInstanceDao productInstanceDao;

    @Autowired
    private ProductDao productDao;

    private static DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());

    @Override
    public List<HistoryOrder> getNewHistory(final String login, final String password, final Long lastOtder) {
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\developpement\\chromedriver.exe");
        try {
            ChromeDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 4);
            driver.get("https://www.coursesu.com/home");

            WelcomePage welcomePage =  new HomePage(driver, wait).login(login, password);
            OrdersPage ordersPage = welcomePage.orders();
            List<HistoryOrder> historyOrders = ordersPage.ordersId(login);
            List<HistoryOrder> newHistoryOrders = new ArrayList<>();
            for (HistoryOrder historyOrder : historyOrders) {
                if (historyOrder.getId() > lastOtder) {
                    newHistoryOrders.add(historyOrder);
                    OrderPage orderPage = ordersPage.order(historyOrder.getId());
                    historyOrder.setProductOrders(orderPage.orderProducts());
                }
            }
            historyOrderDao.saveAll(newHistoryOrders);
            driver.quit();
            return newHistoryOrders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<HistoryOrder> findAll(String customer) {
        return historyOrderDao.findByCustomer(customer);
    }

    @Override
    public List<HistoryOrder> findAllByDate(String customer, LocalDate date) {
        return historyOrderDao.findByCustomerAndDateGreaterThan(customer, date);
    }

    @Override
    public List<HistoryOrder> findAllByDate(String customer, String date) {
        final ZonedDateTime aDate = ZonedDateTime.parse(date,parser);
        return historyOrderDao.findByCustomerAndDateGreaterThan(customer, aDate.toLocalDate());
    }

}
