package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private WebDriver driver ;
    private WebDriverWait wait;

    public Waits(WebDriver driver){
        this.driver = driver;
    }

    public WebElement visibilityOfElement(By by){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement loadElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
