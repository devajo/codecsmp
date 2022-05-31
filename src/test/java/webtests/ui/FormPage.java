package webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage{
    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;

    }
    public void setName(String name){
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public String getName(){
        return driver.findElement(By.id("name")).getText();
    }

    public void setEmail(String email){
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public String getEmail(){
        return driver.findElement(By.id("email")).getText();
    }

    public void setState(String state){
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void clickAgree(){
        driver.findElement(By.className("v-input--selection-controls__ripple")).click();
    }

    public void clickSubmit() {
        var buttons = driver.findElements(By.tagName("button"));
        for (WebElement but : buttons) {
            if (but.getText().equalsIgnoreCase("submit")) {
                but.click();
            }

        }
    }



    public String getPopUpText(){
        WebElement message=driver.findElement(By.cssSelector(".snackbar"));
        new WebDriverWait(driver,10).until(d->message.isDisplayed());
        return message.getText();

    }

    public String getNameError(){
        WebElement error=driver.findElement(By.id("name-err"));
        return error.getText();

    }

    public String getEmailError(){
        WebElement emailError=driver.findElement(By.id("email-err"));
        return emailError.getText();

    }

    public String getAgreeError(){
        WebElement agreeError=driver.findElement(By.id("agree-err"));
        return  agreeError.getText();
    }



}
