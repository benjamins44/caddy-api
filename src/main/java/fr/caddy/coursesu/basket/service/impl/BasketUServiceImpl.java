package fr.caddy.coursesu.basket.service.impl;

import fr.caddy.common.bean.BasketPurchase;
import fr.caddy.coursesu.basket.service.BasketUService;
import fr.caddy.coursesu.helper.ResultPage;
import fr.caddy.coursesu.helper.HomePage;
import fr.caddy.coursesu.helper.WelcomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketUServiceImpl implements BasketUService {
    @Override
    public void basket(List<BasketPurchase> basketPurchases, String login, String password) {
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\developpement\\chromedriver.exe");
        try {
            ChromeDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            driver.get("https://www.coursesu.com/home");

            WelcomePage welcomePage =  new HomePage(driver, wait).login(login, password);

            for (BasketPurchase basketPurchase : basketPurchases) {
                ResultPage resultPage = welcomePage.search(basketPurchase.getIdProduct());
                resultPage.addProduct( basketPurchase.getQuantity());
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
