package Tasks;

import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ProductTask {
    private WebDriver driver;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    public ProductTask(WebDriver driver){
        this.driver = driver;
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public void validateNextPage(){
        String extractedText = shoppingCartPage.getShoppingCartPageName().getText();
        Assertions.assertEquals("Your shopping cart", extractedText);
    }

    public void validateProductName(){
        String expectedText = productPage.getProductName().getText();
        Assertions.assertEquals("Faded Short Sleeve T-shirts", expectedText);
    }

    public void addProductToCart(){
        validateProductName();
        productPage.getAddToCartButton().click();
        productPage.getProceedCheckout().click();
        validateNextPage();
    }
}
