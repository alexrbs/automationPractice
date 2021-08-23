package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private WebDriver driver;
    private Waits waits;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getPaymentPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='center_column']/h1"));
    }

    public WebElement getProductName(){
        return driver.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/table/tbody/tr/td[2]/p/a")
        );
    }

    public WebElement getPayBankWire(){
        return waits.visibilityOfElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
    }

    public WebElement getPayCheck(){
        return waits.visibilityOfElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a"));
    }
}
