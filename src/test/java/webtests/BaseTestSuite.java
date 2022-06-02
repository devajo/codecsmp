package webtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestSuite {

    protected static WebDriver driver;

    @BeforeAll
    public static void Setup() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver102\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void Start() {
        try {
            //ChromeOptions.setCapacity();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void Quit()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}


