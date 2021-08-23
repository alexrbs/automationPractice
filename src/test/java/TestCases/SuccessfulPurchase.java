package TestCases;

import Framework.TestBase;
import ExtentReport.Report;
import ExtentReport.ReportType;
import ExtentReport.Screenshot;
import Tasks.*;
import Utils.UserFileManager;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SuccessfulPurchase extends TestBase {
    private WebDriver driver = getDriver();
    private HomeTask homeTask = new HomeTask(driver);
    private SearchTask searchTask = new SearchTask(driver);
    private ShoppingCartTask shoppingCartTask = new ShoppingCartTask(driver);
    private AuthenticationTask authenticationTask = new AuthenticationTask(driver);
    private PersonalInformationTask personalInformationTask = new PersonalInformationTask(driver);
    private AddressTask addressTask = new AddressTask(driver);
    private ShippingTask shippingTask = new ShippingTask(driver);
    private PaymentTask paymentTask = new PaymentTask(driver);
    private SummaryTask summaryTask = new SummaryTask(driver);
    private ProductTask productTask = new ProductTask(driver);

    @Test
    public void successfulPurchase(){
        try{
            Report.createTest("Single Product Successful Purchase", ReportType.SINGLE);

            UserFileManager.createUserInformationFile("userInformation");

            homeTask.selectSearchTextField();
            searchTask.goToProductFromSearch();
            productTask.addProductToCart();
            shoppingCartTask.shoppingCartCheckout();
            authenticationTask.provideEmail();
            personalInformationTask.setPersonalInformation();
            addressTask.confirmAddressInformation();
            shippingTask.confirmShipping();
            paymentTask.selectPaymentBankWire();
            summaryTask.confirmOrder();

            Report.log(Status.PASS, "Test Successful", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.fullPageBase64(driver));
        }
    }

    @Test
    public void noReportPurchase(){
        homeTask.selectSearchTextField();
        searchTask.goToProductFromSearch();
        productTask.addProductToCart();
        shoppingCartTask.shoppingCartCheckout();
        authenticationTask.provideEmail();
        personalInformationTask.setPersonalInformation();
        addressTask.confirmAddressInformation();
        shippingTask.confirmShipping();
        paymentTask.selectPaymentBankWire();
        summaryTask.confirmOrder();
    }
}
