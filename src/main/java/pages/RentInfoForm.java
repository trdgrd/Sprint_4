package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentInfoForm {

    private WebDriver driver;
    private By dateInput = By.xpath(".//input[contains(@placeholder, 'Когда')]");
    private By durationInput = By.xpath(".//div[contains(text(), 'Срок')]");
    private By commentInput = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    private By orderButton = By.xpath("(.//button[contains(text(), 'Заказать')])[2]");

    public RentInfoForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).sendKeys(date, Keys.ENTER);
    }

    public void selectDuration(int number) {
        driver.findElement(durationInput).click();
        driver.findElements(By.xpath(".//div[contains(@class, 'Dropdown-menu')]/div")).get(number).click();
    }

    public void selectColour(String color) {
        driver.findElement(By.xpath(".//input[@id='" + color + "']"));
    }

    public void enterComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));
    }

}
