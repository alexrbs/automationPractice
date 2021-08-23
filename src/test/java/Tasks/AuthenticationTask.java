package Tasks;

import PageObjects.AuthenticationPage;
import PageObjects.PersonalInformationPage;
import Utils.FakerGenerator;
import Utils.UserFileManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AuthenticationTask {
    private WebDriver driver;
    private AuthenticationPage authenticationPage;
    private PersonalInformationPage personalInformationPage;

    public AuthenticationTask(WebDriver driver){
        this.driver = driver;
        authenticationPage = new AuthenticationPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
    }

    public void validateNextPage(){
        String expectedText = personalInformationPage.getPersonalInformationPageName().getText();
        Assertions.assertEquals("Authentication", expectedText);
    }

    public void provideEmail(){
        String email = FakerGenerator.getEmailAddress();
        UserFileManager.setUserInformationFile("userInformation","userEmail=", email);
        authenticationPage.getEmailTextField().sendKeys(email);
        authenticationPage.getCreateAccountButton().click();
        validateNextPage();
    }
}
