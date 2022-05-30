package webtests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestSuite {

    private static WebDriver driver;


    @BeforeAll
    public static void Setup()
    {
        driver=new ChromeDriver();
    }

    @BeforeEach
    public void Start()
    {
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
    }

    @Test
    public void FormTest(){
       WebElement form =driver.findElement(By.cssSelector("[aria-label='forms']"));
       form.click();
       Assertions.assertEquals("https://d18u5zoaatmpxx.cloudfront.net/#/forms",driver.getCurrentUrl());
   }

    @Test
    public void PlanetTest(){
        WebElement planetUrl=driver.findElement(By.cssSelector("[aria-label='planets']"));
        planetUrl.click();
        Assertions.assertEquals("https://d18u5zoaatmpxx.cloudfront.net/#/planets",driver.getCurrentUrl());
    }


    @AfterAll
    public  static void Quit()
    {
        if (driver != null){
           driver.quit();
        }

    }

}
