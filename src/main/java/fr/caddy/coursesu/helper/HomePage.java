package fr.caddy.coursesu.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public static String PAGE = "https://www.coursesu.com/home";

    private ChromeDriver driver;
    private WebDriverWait wait;

    private static String PATH_LOGIN = "//input[@id='connect_email_input']";
    private static String PATH_PASSWORD = "//input[@id='connect_password_input']";
    private static String PATH_SUBMIT = "//input[@id='submitIdentif']";
    private static String PATH_CONFIRM = "//a[@id='eventlink_1']";

    public HomePage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WelcomePage login(String login, String password) {
        final WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_LOGIN)));
        final WebElement elementPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_PASSWORD)));
        final WebElement elementSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_SUBMIT)));

        elementLogin.sendKeys(login);
        elementPassword.sendKeys(password);

        elementSubmit.click();

        final WebElement elementConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_CONFIRM)));
        elementConfirm.click();

        return new WelcomePage(this.driver, this.wait);
    }

}
