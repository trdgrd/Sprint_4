import org.junit.Test;
import pages.Header;
import pages.OrderTrackPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeaderTests extends Base {

    @Test
    public void checkMainPageOpenedByLogoClick() {

        Header header = new Header(driver);
        header.waitForHeaderDisplayed();
        header.clickOrderButton();
        header.clickScooterLogo();
        header.waitForHeaderDisplayed();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void checkYandexPageOpenedByLogoClick() {

        Header header = new Header(driver);
        header.waitForHeaderDisplayed();
        header.clickYandexLogo();
        header.switchToNewTab();
        String expectedUrl = "https://ya.ru/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void checkNoSuchOrderPageDisplayed() {

        Header header = new Header(driver);
        header.waitForHeaderDisplayed();
        header.clickOrderStatusButton();
        header.enterOrderNumber("000");
        OrderTrackPage orderTrackPage = new OrderTrackPage(driver);
        orderTrackPage.waitForPageDisplayed();

        assertTrue(orderTrackPage.checkTrackNotFoundImageDisplayed());
    }

}
