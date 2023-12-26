package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderTrackPage {

    private WebDriver driver;
    private By lookButton = By.xpath(".//button[text()='Посмотреть']");
    private By trackNotFoundImage = By.xpath(".//div[contains(@class, 'Track_NotFound')]");

    public OrderTrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(lookButton));
    }

    public boolean checkTrackNotFoundImageDisplayed() {
        return driver.findElement(trackNotFoundImage).isDisplayed();
    }
}
