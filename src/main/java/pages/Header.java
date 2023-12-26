package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Header {

    private WebDriver driver;
    private By orderButton = By.xpath("(.//button[text()='Заказать'])[1]");
    private By scooterLogo = By.xpath(".//a[contains(@class, 'LogoScooter')]");
    private By yandexLogo = By.xpath(".//a[contains(@class, 'LogoYandex')]");
    private By orderStatusButton = By.xpath(".//button[text()='Статус заказа']");
    private By orderNumberInput = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private By enterOrderNumberButton = By.xpath(".//button[text()='Go!']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void enterOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
        driver.findElement(enterOrderNumberButton).click();

    }

    public void waitForHeaderDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'Home_Header')]")));
    }

    public void switchToNewTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
