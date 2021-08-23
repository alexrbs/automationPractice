package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;
    private Waits waits;

    public ProductPage (WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getProductPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/div/section[1]/h3"));
    }

    public WebElement getProductName(){
        return driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/h1"));
    }

    public WebElement getAddToCartButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='add_to_cart']/button"));
    }

    public WebElement getProceedCheckout(){
        return waits.visibilityOfElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
    }
}
