import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.PropertiesReader.getProperties;

public class DriverTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(getProperties().getProperty("home.page"));
    }

    @Test
    public void checkIfTitleIsCorrect() {
        assertThat(driver.getTitle(), is(equalTo("Online shop – acodemy – Just another WordPress site")));
    }

    @Test
    public void productsTest() {
        mainPage.getAllProducts().size();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
