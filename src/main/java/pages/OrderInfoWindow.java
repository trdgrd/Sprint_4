package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInfoWindow {

    private WebDriver driver;
    private By windowHeader = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderInfoWindow(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkWindowDisplayed() {
        return driver.findElement(windowHeader).isDisplayed();
    }

}
