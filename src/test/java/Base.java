import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Base {
    WebDriver driver;
    private String url = "https://qa-scooter.praktikum-services.ru/";

    @BeforeClass
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
