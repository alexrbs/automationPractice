package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getLogin(){
        return waits.visibilityOfElement(By.className("login"));
    }

    public WebElement getSearchBox(){
        return waits.visibilityOfElement(By.id("search_query_top"));
    }

    public WebElement getSearchButton(){
        return waits.visibilityOfElement(By.name("submit_search"));
    }
}
