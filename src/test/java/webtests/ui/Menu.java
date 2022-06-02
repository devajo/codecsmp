package webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menu {
    private final WebDriver driver;

    public Menu(WebDriver driver){
        this.driver=driver;

    }

    public void navigateForm(){
        WebElement formUrl =driver.findElement(By.cssSelector("[aria-label='forms']"));
        formUrl.click();

    }


    public void navigatePlanet(){
            WebElement formUrl =driver.findElement(By.cssSelector("[aria-label='planets']"));
        formUrl.click();

    }


}
