package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
    private WebDriver driver;
    private Waits waits;

    public AddressPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getAddressPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/h1"));
    }

    public WebElement getAddressFirstAndLastName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='address_delivery']/li[2]"));
    }

    public WebElement getAddressStreet(){
        return waits.visibilityOfElement(By.xpath("//*[@id='address_delivery']/li[3]"));
    }

    public WebElement getAddressCityStatePostalCode(){
        return waits.visibilityOfElement(By.xpath("//*[@id='address_delivery']/li[4]"));
    }

    public WebElement getAddressCountry(){
        return waits.visibilityOfElement(By.xpath("//*[@id='address_delivery']/li[5]"));
    }

    public WebElement getMobilePhone(){
        return waits.visibilityOfElement(By.xpath("//*[@id='address_delivery']/li[6]"));
    }

    public WebElement getProceedToCheckoutButton(){
        return waits.visibilityOfElement(By.name("processAddress"));
    }
}
