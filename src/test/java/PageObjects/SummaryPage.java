package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {
    private WebDriver driver;
    private Waits waits;

    public SummaryPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getSummaryPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/h1"));
    }

    public WebElement getPaymentMethod(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/form/div/h3"));
    }

    public WebElement getConfirmOrderButton(){
        return waits.visibilityOfElement(By.xpath("//*[@id='cart_navigation']/button"));
    }
}
