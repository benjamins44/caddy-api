package fr.caddy.coursesu.history.service.impl;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.common.bean.OffCoursesU;
import fr.caddy.core.dao.OffCoursesUDao;
import fr.caddy.core.dao.ProductDao;
import fr.caddy.core.dao.ProductInstanceDao;
import fr.caddy.core.dao.ProductsUDao;
import fr.caddy.core.service.OrderService;
import fr.caddy.core.service.ProductInstanceService;
import fr.caddy.core.service.ProductService;
import fr.caddy.coursesu.helper.*;
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
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private ProductsUDao productsUDao;

    @Autowired
    private OffCoursesUDao offCoursesUDao;


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

    public void offCoursesUId(final String login, final String password) {
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\developpement\\chromedriver.exe");
        try {

            List<OffCoursesU> listOffCoursesU =  offCoursesUDao.findByIdCoursesU(null);
            //List<OffCoursesU> listOffCoursesU =  offCoursesUDao.findByCode("3329770041196");

            ChromeDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 4);
            driver.get("https://www.coursesu.com/home");


            WelcomePage welcomePage =  new HomePage(driver, wait).login(login, password);
            int i = 1;
            int found = 0;
            int total = listOffCoursesU.size();
            for (OffCoursesU offCoursesU : listOffCoursesU) {
                List<OffCoursesU> test =  offCoursesUDao.findByCode(offCoursesU.getCode());
                if (test.size() == 1) {
                    ResultPage resultPage = welcomePage.search(offCoursesU.getCode());
                    final OffCoursesU aOffCoursesU = resultPage.getFirstResultProduct();
                    if (aOffCoursesU != null) {
                        offCoursesUDao.delete(offCoursesU);
                    /*
                    offCoursesU.setIdCoursesU(aOffCoursesU.getIdCoursesU());
                    offCoursesU.setUrl(aOffCoursesU.getUrl());
                    offCoursesU.setLabel(aOffCoursesU.getLabel());
                    offCoursesU.setCategory(aOffCoursesU.getCategory());
*/
                        aOffCoursesU.setId(offCoursesU.getId());
                        aOffCoursesU.setCode(offCoursesU.getCode());
                        offCoursesUDao.save(aOffCoursesU);
                        found++;
                        TimeUnit.SECONDS.sleep(4);

                    } else {
                        offCoursesUDao.save(offCoursesU);
                    }
                    System.out.println(String.format("%s/%s, %s, %s, %s", i, total, found, offCoursesU.getCode(), i * 1000 / total));
                } else {
                    if (test.get(0).getLabel() != null || test.get(1).getLabel() != null) {
                        found++;
                    }
                }
                i++;

            }

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
