package Tasks;

import PageObjects.PaymentPage;
import PageObjects.ShippingPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ShippingTask {
    private WebDriver driver;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;

    public ShippingTask(WebDriver driver){
        this.driver = driver;
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    public void validateNextPage(){
        String expectedText = paymentPage.getPaymentPageName().getText().toUpperCase();
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", expectedText);
    }

    public void confirmShipping(){
        shippingPage.getTermsOfServiceCheckBox().click();
        shippingPage.getProceedToCheckoutButton().click();
        validateNextPage();
    }
}
