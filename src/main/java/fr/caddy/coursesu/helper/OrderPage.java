package fr.caddy.coursesu.helper;

import fr.caddy.common.bean.HistoryOrderProduct;
import fr.caddy.common.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    private static String PATH_PRODUCT = "//div[@class='contour']/form/table/tbody/tr";

    public OrderPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<HistoryOrderProduct> orderProducts() {
        final List<HistoryOrderProduct> list = new ArrayList<>();
        int i = 1;
        String xpath = PATH_PRODUCT + "[" + i + "]";
        try {
            WebElement elementProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            while (elementProduct != null) {
                // work product line only
                final String id = elementProduct.getAttribute("data-ref");
                if (!StringUtils.isEmpty(id)) {
                    final HistoryOrderProduct productOrder = new HistoryOrderProduct();
                    productOrder.setCategory(elementProduct.getAttribute("data-category"));
                    productOrder.setId(Long.valueOf(id));

                    WebElement elementQte = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + "/td[3]")));
                    String[] quantityUnit = elementQte.getText().split(" ");
                    productOrder.setQuantity(Float.valueOf(quantityUnit[0].replace(",", ".")));
                    if (quantityUnit.length > 1)
                    productOrder.setUnit(quantityUnit[1]);

                    WebElement elementLibelle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + "/td[2]//td[2]")));
                    productOrder.setLabel(elementLibelle.getText());

                    WebElement elementUrl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + "/td[2]//td[1]/img")));
                    productOrder.setUrl(elementUrl.getAttribute("src"));

                    productOrder.setSign(Constants.SIGN_U);

                    list.add(productOrder);
                }
                i++;
                xpath = PATH_PRODUCT + "[" + i + "]";
                elementProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            }
        } catch (Exception e) {
            // element not found
            //e.printStackTrace();
        }
        return list;
    }


}
