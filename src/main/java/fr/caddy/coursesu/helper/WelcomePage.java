package fr.caddy.coursesu.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private static String PATH_CANCEL = "//a[@data-powertour-action='start']";
    private static String PATH_ORDERS = "//a[@title='Accéder à mes commandes']";
    private static String PATH_CLOSE = "//div[@id='tour1-step1']//a[@data-powertour-action='stop']";
    private static String PATH_SEARCH = "//input[@id='search-text']";

    private static String URL_SEARCH = "https://www.coursesu.com/product/Catalogue/136248?productId=%s";



    public WelcomePage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        final WebElement elementStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_CANCEL)));
        elementStart.click();
        final WebElement elementClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_CLOSE)));
        elementClose.click();
    }

    public OrdersPage orders() {
        final WebElement elementOrders = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_ORDERS)));
        elementOrders.click();
        return new OrdersPage(this.driver, this.wait);
    }

    public ResultPage search(String label) {
        final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_SEARCH)));
        element.sendKeys(label);
        element.sendKeys(Keys.ENTER);
        return new ResultPage(this.driver, this.wait);
    }

    public ResultPage search(Long id) {
        this.driver.navigate().to(String.format(URL_SEARCH, id));
        return new ResultPage(this.driver, this.wait);
    }



}
