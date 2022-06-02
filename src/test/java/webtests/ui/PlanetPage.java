package webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetPage {
    private WebDriver driver;
    public  PlanetPage(WebDriver driver){
      this.driver=driver;

    }
     public PlanetTile findPlanetTileByName(String name){
        var tiles=driver.findElements(By.className("planet"));
        for(WebElement tile:tiles){
            if(tile.findElement(By.tagName("h2")).getText().equalsIgnoreCase(name)){
                return new PlanetTile(tile);
            }

        }
        return null;


    }





}