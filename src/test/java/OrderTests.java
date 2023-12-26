import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.*;

import static org.junit.Assert.assertTrue;

@RunWith(Enclosed.class)
public class OrderTests extends Base {

    @RunWith(Parameterized.class)
    public static class ParametrizedTests extends Base {

        private final String errorMessage;

        public ParametrizedTests(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Parameterized.Parameters
        public static Object[][] getText() {
            return new Object[][] {
                    {"Введите корректное имя"},
                    {"Введите корректную фамилию"},
                    {"Введите корректный адрес"},
                    {"Введите корректный номер"}
            };
        }

        @Test
        public void checkOrderFormInputsErrors() {
            String testData = "blabla";
            Header header = new Header(driver);
            header.waitForHeaderDisplayed();
            MainPage mainPage = new MainPage(driver);
            mainPage.clickAcceptCookie();
            header.clickOrderButton();
            ClientInfoForm clientInfoForm = new ClientInfoForm(driver);
            clientInfoForm.waitForFormDisplayed();
            clientInfoForm.enterName(testData);
            clientInfoForm.enterSurname(testData);
            clientInfoForm.enterAddress(testData);
            clientInfoForm.enterPhone(testData);
            clientInfoForm.clickNextButton();

            assertTrue(clientInfoForm.checkErrorMessageDisplayed(errorMessage));
        }
    }

    public static class NotParametrizedTests extends Base {
        @Test
        public void checkOrderSuccessfulByHeaderButtonClick() {

            Header header = new Header(driver);
            header.waitForHeaderDisplayed();
            MainPage mainPage = new MainPage(driver);
            mainPage.clickAcceptCookie();
            header.clickOrderButton();
            ClientInfoForm clientInfoForm = new ClientInfoForm(driver);
            clientInfoForm.waitForFormDisplayed();
            clientInfoForm.enterName("Джон");
            clientInfoForm.enterSurname("Доу");
            clientInfoForm.enterAddress("Какой-то адрес");
            clientInfoForm.selectStation("Сокольники");
            clientInfoForm.enterPhone("123456789012");
            clientInfoForm.clickNextButton();
            RentInfoForm rentInfoForm = new RentInfoForm(driver);
            rentInfoForm.waitForFormDisplayed();
            rentInfoForm.enterDate("23.12.23");
            rentInfoForm.selectDuration(0);
            rentInfoForm.selectColour("black");
            rentInfoForm.enterComment("Какой-то комментарий");
            rentInfoForm.clickOrderButton();
            OrderConfirmationWindow orderConfirmationWindow = new OrderConfirmationWindow(driver);
            orderConfirmationWindow.waitForFormDisplayed();
            orderConfirmationWindow.clickConfirmButton();
            OrderInfoWindow orderInfoWindow = new OrderInfoWindow(driver);

            assertTrue(orderInfoWindow.checkWindowDisplayed());
        }

        @Test
        public void checkOrderSuccessfulByMainPageButtonClick() {

            Header header = new Header(driver);
            header.waitForHeaderDisplayed();
            MainPage mainPage = new MainPage(driver);
            mainPage.clickAcceptCookie();
            mainPage.clickOrderButton();
            ClientInfoForm clientInfoForm = new ClientInfoForm(driver);
            clientInfoForm.waitForFormDisplayed();
            clientInfoForm.enterName("Джон");
            clientInfoForm.enterSurname("Доу");
            clientInfoForm.enterAddress("Какой-то адрес");
            clientInfoForm.selectStation("Сокольники");
            clientInfoForm.enterPhone("123456789012");
            clientInfoForm.clickNextButton();
            RentInfoForm rentInfoForm = new RentInfoForm(driver);
            rentInfoForm.waitForFormDisplayed();
            rentInfoForm.enterDate("23.12.23");
            rentInfoForm.selectDuration(0);
            rentInfoForm.selectColour("black");
            rentInfoForm.enterComment("Какой-то комментарий");
            rentInfoForm.clickOrderButton();
            OrderConfirmationWindow orderConfirmationWindow = new OrderConfirmationWindow(driver);
            orderConfirmationWindow.waitForFormDisplayed();
            orderConfirmationWindow.clickConfirmButton();
            OrderInfoWindow orderInfoWindow = new OrderInfoWindow(driver);

            assertTrue(orderInfoWindow.checkWindowDisplayed());
        }
    }

}
