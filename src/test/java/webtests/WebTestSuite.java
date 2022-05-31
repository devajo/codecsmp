
package webtests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webtests.ui.FormPage;
import webtests.ui.Menu;
import webtests.ui.PlanetPage;


import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


public class WebTestSuite extends BaseTestSuite
{



    @Test
    public void FormTest(){
        //Arrange
       WebElement form =driver.findElement(By.cssSelector("[aria-label='forms']"));
        //Act
        form.click();
        //Assert
       Assertions.assertEquals("https://d18u5zoaatmpxx.cloudfront.net/#/forms",driver.getCurrentUrl());
   }

    @Test
    public void PlanetTest(){
        WebElement planetUrl=driver.findElement(By.cssSelector("[aria-label='planets']"));
        planetUrl.click();
        Assertions.assertEquals("https://d18u5zoaatmpxx.cloudfront.net/#/planets",driver.getCurrentUrl());
    }

    @Test
    public void FullFormTest() {
        //Arrange
        Menu menu=new Menu(driver);
        menu.navigateForm();

        //Act
        FormPage forms=new FormPage(driver);
        forms.setName("Dev");
        forms.setEmail("dev@test.com");
        forms.setState("VIC");
        forms.clickAgree();
        forms.clickSubmit();

        //Assert
        String expectedMessage = "Thanks for your feedback Dev";
        Assertions.assertEquals(expectedMessage, forms.getPopUpText());
    }

    @Test
    public void EmptyForm(){

        //Arrange
        Menu menu=new Menu(driver);
        menu.navigateForm();

        //Act
        FormPage forms=new FormPage(driver);
        forms.clickSubmit();

        //Assert
        String nameError="Your name is required";
        Assertions.assertEquals(nameError,forms.getNameError());

        String emailError="Your email is required";
        Assertions.assertEquals(emailError,forms.getEmailError());

        String agreeError="You must agree to continue";
        Assertions.assertEquals(agreeError,forms.getAgreeError());


    }






    @Test
    public void distancetoJuipterTest(){
        //Arrange
        var menu =new Menu(driver);
        menu.navigatePlanet();
        //Act
        var planets=new PlanetPage(driver);
        //Assert
        var jupiter= planets.findPlanetTileByName("jupiter");
        Assertions.assertEquals("778,500,000 km",jupiter.getDistance());


    }






    }