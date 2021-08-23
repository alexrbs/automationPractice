package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;
    private Waits waits;

    public ShoppingCartPage (WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getShoppingCartPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='columns']/div[1]/span[2]"));
    }

    public WebElement getNameProductOnCart(){
        return waits.visibilityOfElement(By.xpath("//*[@id='product_1_1_0_0']/td[2]/p/a"));
    }

    public WebElement getShoppingCartCheckoutButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/p[2]/a[1]"));
    }
}
