package Tasks;

import PageObjects.SearchPage;
import PageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchTask {
    private WebDriver driver;
    private SearchPage searchPage;
    private ShoppingCartPage shoppingCartPage;

    public SearchTask(WebDriver driver){
        this.driver = driver;
        searchPage = new SearchPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public void validateNextPage(){
        String extractedText = shoppingCartPage.getShoppingCartPageName().getText();
        Assertions.assertEquals("Your shopping cart", extractedText);
    }

    public void addToCartFromSearch(){
        searchPage.getAddToCartButton().click();
        searchPage.getSearchCheckoutButton().click();
        validateNextPage();
    }
}
