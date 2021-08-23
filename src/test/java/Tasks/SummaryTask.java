package Tasks;

import PageObjects.SummaryPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

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
}
