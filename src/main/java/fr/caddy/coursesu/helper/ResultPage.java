package fr.caddy.coursesu.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private static String PATH_PRODUCT_MODAL = "//div[@class='modal-content']//a[@class='btn-basket-add btn-produit']";
    private static String PATH_PRODUCT_MORE_MODAL = "//div[@class='modal-content']//a[@class='more']";
    private static String PATH_PRODUCT_LESS_MODAL = "//div[@class='modal-content']//a[@class='less']";
    private static String PATH_PRODUCT_QTE = "//div[@class='modal-content']//span[@class='label']";

    public ResultPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addProduct(Float quantity) {
        Long current = 0L;
        try {
            final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_PRODUCT_MODAL)));
            element.click();
            current++;
        } catch(Exception e) {
            // there is a quantity
            final WebElement elementQte = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_PRODUCT_QTE)));
            current = Long.valueOf(elementQte.getText());
        }

        if (current < quantity) {
            final WebElement elementMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_PRODUCT_MORE_MODAL)));
            for (; current < quantity; current++) {
                elementMore.click();
            }
        } else if (current > quantity) {
            final WebElement elementLess = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_PRODUCT_LESS_MODAL)));
            for (; current > quantity; current--) {
                elementLess.click();
            }
        }
    }
}
