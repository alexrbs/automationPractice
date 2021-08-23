package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    private WebDriver driver;
    private Waits waits;

    public AuthenticationPage (WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getAuthenticationPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='columns']/div[1]/span[2]"));
    }

    public WebElement getEmailTextField(){
        return waits.visibilityOfElement(By.id("email_create"));
    }

    public WebElement getCreateAccountButton(){
        return waits.visibilityOfElement(By.id("SubmitCreate"));
    }
}
