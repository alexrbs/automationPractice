package Tasks;

import PageObjects.AuthenticationPage;
import PageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ShoppingCartTask {
    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;
    private AuthenticationPage authenticationPage;

    public ShoppingCartTask(WebDriver driver){
        this.driver = driver;
        shoppingCartPage = new ShoppingCartPage(driver);
        authenticationPage = new AuthenticationPage(driver);
    }

    public void validateNextPage(){
        String expectedText = authenticationPage.getAuthenticationPageName().getText().toUpperCase();
        Assertions.assertEquals("AUTHENTICATION", expectedText);
    }

    public void validateProductOnCart(){
        String productName = shoppingCartPage.getNameProductOnCart().getText();
        Assertions.assertEquals("Faded Short Sleeve T-shirts", productName);
    }

    public void shoppingCartCheckout(){
        validateProductOnCart();
        shoppingCartPage.getShoppingCartCheckoutButton().click();
        validateNextPage();
    }
}
