
package webtests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webtests.ui.FormPage;
import webtests.ui.Menu;


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

        Menu menu=new Menu(driver);
        menu.navigateForm();

        //Arrange
        FormPage forms=new FormPage(driver);
        forms.setName("Dev");
        forms.setEmail("dev@test.com");
        forms.setState("VIC");
        forms.clickAgree();
        forms.clickSubmit();





        String expectedMessage = "Thanks for your feedback Dev";
        Assertions.assertEquals(expectedMessage, forms.getPopUpText());
    }






    @Test
    public void EmptyForm(){
        Menu menu=new Menu(driver);
        menu.navigateForm();

        //Arrange
        FormPage forms=new FormPage(driver);
        forms.clickSubmit();

        String nameError="Your name is required";
        Assertions.assertEquals(nameError,forms.getNameError());

        String emailError="Your email is required";
        Assertions.assertEquals(emailError,forms.getEmailError());


    }



}
