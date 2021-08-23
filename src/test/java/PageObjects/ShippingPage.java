package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {
    private WebDriver driver;
    private Waits waits;

    public ShippingPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getShippingPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='carrier_area']/h1"));
    }

    public WebElement getTermsOfServiceCheckBox(){
        return waits.visibilityOfElement(By.xpath("//*[@id='uniform-cgv']/span"));
    }

    public WebElement getProceedToCheckoutButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='form']/p/button"));
    }
}
