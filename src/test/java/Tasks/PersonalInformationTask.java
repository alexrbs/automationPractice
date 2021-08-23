package Tasks;

import PageObjects.AddressPage;
import PageObjects.PersonalInformationPage;
import Utils.FakerGenerator;
import Utils.UserFileManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class PersonalInformationTask {
    private WebDriver driver;
    private PersonalInformationPage personalInformationPage;
    private AddressPage addressPage;

    public PersonalInformationTask(WebDriver driver){
        this.driver = driver;
        personalInformationPage = new PersonalInformationPage(driver);
        addressPage = new AddressPage(driver);
    }

    public void validateNextPage(){
        String expectedText = addressPage.getAddressPageName().getText().toUpperCase();
        Assertions.assertEquals("ADDRESSES", expectedText);
    }

    public void setPersonalInformationForm(){
        String firstName = FakerGenerator.getFirstName();
        String lastName = FakerGenerator.getLastName();
        String password = FakerGenerator.getUserPassword().substring(0, 8);
        String address = FakerGenerator.getHomeAddress();
        String city = FakerGenerator.getCityAddress();
        String state = "California";
        String postalCode = FakerGenerator.getPostalCode().substring(0, 5);
        String country = "United States";
        String mobilePhone = FakerGenerator.getMobilePhoneNumber();

        UserFileManager.setUserInformationFile("userInformation", "userFirstName=", firstName);
        UserFileManager.setUserInformationFile("userInformation", "userLastName=", lastName);
        UserFileManager.setUserInformationFile("userInformation", "userPassword=", password);
        UserFileManager.setUserInformationFile("userInformation", "userStreetAddress=", address);
        UserFileManager.setUserInformationFile("userInformation", "userCityAddress=", city);
        UserFileManager.setUserInformationFile("userInformation", "userStateAddress=", state);
        UserFileManager.setUserInformationFile("userInformation", "userPostalAddress=", postalCode);
        UserFileManager.setUserInformationFile("userInformation", "userCountryAddress=", country);
        UserFileManager.setUserInformationFile("userInformation", "userMobilePhone=", mobilePhone);
        UserFileManager.setUserInformationFile("userInformation", "userAliasAddress=", "House");
    }

    public void setPersonalInformation(){
        setPersonalInformationForm();
        personalInformationPage.getFirstNameTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userFirstName=")
        );
        personalInformationPage.getLastNameTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userLastName=")
        );
        personalInformationPage.getPasswordTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userPassword=")
        );
        personalInformationPage.getAddressStreetTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userStreetAddress=")
        );
        personalInformationPage.getAddressCityTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userCityAddress=")
        );
        personalInformationPage.getAddressStateSelectField().selectByVisibleText(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userStateAddress=")
        );
        personalInformationPage.getAddressPostalCodeTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userPostalAddress=")
        );
        personalInformationPage.getAddressCountrySelectField().selectByVisibleText(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userCountryAddress=")
        );
        personalInformationPage.getAddressMobilePhoneNumberTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userMobilePhone=")
        );
        personalInformationPage.getAddressAliasTextField().clear();
        personalInformationPage.getAddressAliasTextField().sendKeys(
                UserFileManager.getUserInformationFile("userInformation").getProperty("userAliasAddress=")
        );
        personalInformationPage.getRegisterButton().click();
        validateNextPage();
    }
}
