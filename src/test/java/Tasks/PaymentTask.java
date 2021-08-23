package Tasks;

import PageObjects.PaymentPage;
import PageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class PaymentTask {
    private WebDriver driver;
    private PaymentPage paymentPage;

    public PaymentTask(WebDriver driver){
        this.driver = driver;
        paymentPage = new PaymentPage(driver);
    }
    public void validateNextPage(){
        String expectedText = paymentPage.getPaymentPageName().getText();
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", expectedText);
    }

    public void validateProductCart(){
        String expectedText = paymentPage.getProductName().getText();
        Assertions.assertEquals("Faded Short Sleeve T-shirts", expectedText);
    }

    public void selectPaymentBankWire(){
        validateNextPage();
        validateProductCart();
        paymentPage.getPayBankWire().click();
    }

    public void selectPaymentCheck(){
        validateNextPage();
        validateProductCart();
        paymentPage.getPayCheck().click();
    }

}
