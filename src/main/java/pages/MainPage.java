package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private By questionItem = By.xpath(".//div[contains(@id, 'accordion__heading')]");
    private By questionItemText = By.xpath(".//div[@class='accordion__panel']//p");
    private By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");
    private By orderButton = By.xpath("(.//button[text()='Заказать'])[2]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openQuestionItem(int itemNumber) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElements(questionItem).get(itemNumber));
        driver.findElements(questionItem).get(itemNumber).click();
    }

    public String getQuestionItemText(int itemNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElements(questionItemText).get(itemNumber)));
        return driver.findElements(questionItemText).get(itemNumber).getText();
    }

    public void clickAcceptCookie() {
        driver.findElement(acceptCookieButton).click();
    }

    public void clickOrderButton() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButton));
        driver.findElement(orderButton).click();
    }

}
