package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage {
    private WebDriver driver;
    private Waits waits;

    public SearchPage (WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getSearchPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='columns']/div[1]/span[2]"));
    }

    public WebElement getAddToCartButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]"));
    }

    public WebElement getSearchCheckoutButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
    }
}
