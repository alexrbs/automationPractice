package Tasks;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;

    public HomeTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    public void validateNextPage(){
        String extractedText = searchPage.getSearchPageName().getText();
        Assertions.assertEquals("Search", extractedText);
    }

    public void selectSearchTextField(){
        homePage.getSearchBox().sendKeys("Faded Short Sleeve T-shirts");
        homePage.getSearchButton().click();
        validateNextPage();
    }

    public void selectLogin(){
        homePage.getLogin().click();
    }
}
