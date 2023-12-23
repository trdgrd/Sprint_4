package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationWindow {

    private WebDriver driver;
    private By confirmButton = By.xpath(".//button[text()='Да']");

    public OrderConfirmationWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void waitForFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Хотите оформить заказ?']")));
    }

}
