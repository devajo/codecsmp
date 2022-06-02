package webtests.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile{
    private WebElement element;

    public PlanetTile(WebElement tile){
        this.element=tile;

    }
    
    public String getPlanetName(){
        return element.findElement(By.tagName("h2")).getText();
        
    }

    public String getNameDistanceFromSun(){
        return element.findElement(By.className("distance")).getText();
    }



    public String getDistance() {
        return element.findElement(By.className("distance")).getText();
    }
}
