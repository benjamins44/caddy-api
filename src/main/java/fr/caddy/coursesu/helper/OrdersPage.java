package fr.caddy.coursesu.helper;

import fr.caddy.common.bean.HistoryOrder;
import fr.caddy.common.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdersPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private static String URL_ORDER = "https://www.coursesu.com/detailcommande?order=";
    private static String PATH_ORDER = "//div[@class='contour']/table/tbody/tr";

    private static DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());

    public OrdersPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<HistoryOrder> ordersId(String customer) {
        final List<HistoryOrder> list = new ArrayList<>();
        int i = 1;
        String xpath = PATH_ORDER + "[" + i + "]/td[1]";
        String xpathDate = PATH_ORDER + "[" + i + "]/td[2]";
        String xpathPrice = PATH_ORDER + "[" + i + "]/td[3]";
        try {
            WebElement elementOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement elementDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathDate)));
            WebElement elementPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathPrice)));
            while (elementOrder != null) {
                final HistoryOrder historyOrder = new HistoryOrder();
                historyOrder.setId(Long.valueOf(elementOrder.getText()));
                historyOrder.setSign(Constants.SIGN_U);
                String date = elementDate.getText().split("\n")[0];
                LocalDate aDate = LocalDate.parse(date, parser);
                historyOrder.setDate(aDate);
                String price = elementPrice.getText().replace("€", "").replace(",", ".");
                historyOrder.setPrice(Float.valueOf(price));
                historyOrder.setCustomer(customer);
                list.add(historyOrder);
                i++;
                xpath = PATH_ORDER + "[" + i + "]/td[1]";
                xpathDate = PATH_ORDER + "[" + i + "]/td[2]";
                xpathPrice = PATH_ORDER + "[" + i + "]/td[3]";
                elementOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                elementDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathDate)));
                elementPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathPrice)));
            }
        } catch (Exception e) {
            // element not found
        }
        return list;
    }

    public OrderPage order(Long id) {
        this.driver.navigate().to(URL_ORDER + id);
       // this.wait.until(ExpectedConditions.titleIs(URL_ORDER + id));
        return new OrderPage(this.driver, this.wait);
    }

}
