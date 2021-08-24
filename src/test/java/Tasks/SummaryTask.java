package Tasks;

import PageObjects.SummaryPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryTask {
    private WebDriver driver;
    private SummaryPage summaryPage;

    public SummaryTask(WebDriver driver){
        this.driver = driver;
        summaryPage = new SummaryPage(driver);
    }

    public void validateNextPage(){
        String expectedText = summaryPage.getSummaryPageName().getText();
        Assertions.assertEquals("ORDER SUMMARY", expectedText);
    }

    public void validatePaymentMethodBankWire(){
        String expectedText = summaryPage.getPaymentMethod().getText();
        Assertions.assertEquals("BANK-WIRE PAYMENT.", expectedText);
    }

    public void validatePaymentMethodCheck(){
        String expectedText = summaryPage.getPaymentMethod().getText();
        Assertions.assertEquals("CHECK PAYMENT", expectedText);
    }

    public void confirmOrder(){
        validateNextPage();
        if (summaryPage.getPaymentMethod().getText().equals("BANK-WIRE PAYMENT.")){
            validatePaymentMethodBankWire();
            summaryPage.getConfirmOrderButton().click();
        } else {
            validatePaymentMethodCheck();
            summaryPage.getConfirmOrderButton().click();
        }
    }

    public void moveCenterPage(){
        WebElement box = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div"));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", box);
    }
}
