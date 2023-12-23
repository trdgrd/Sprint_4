package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientInfoForm {

    private WebDriver driver;
    private By nameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private By surnameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private By addressInput = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    private By stationInput = By.xpath(".//input[@class='select-search__input']");
    private By phoneInput = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public ClientInfoForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectStation(String stationName) {
        driver.findElement(stationInput).click();
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//button[div[text()='" + stationName + "']]")));
        driver.findElement(By.xpath(".//button[div[text()='" + stationName + "']]")).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void waitForFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));

    }

}
