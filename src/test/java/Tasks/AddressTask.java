package Tasks;

import PageObjects.AddressPage;
import PageObjects.ShippingPage;
import Utils.UserFileManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddressTask {
    private WebDriver driver;
    private AddressPage addressPage;
    private ShippingPage shippingPage;

    public AddressTask(WebDriver driver){
        this.driver = driver;
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
    }

    public void validateNextPage(){
        String expectedText = shippingPage.getShippingPageName().getText().toUpperCase();
        Assertions.assertEquals("SHIPPING", expectedText);
    }

    public void checkFirstAndLastName(){
        String firstName = UserFileManager.getUserInformationFile("userInformation").getProperty("userFirstName=");
        String lastName = UserFileManager.getUserInformationFile("userInformation").getProperty("userLastName=");
        String firstLineSaved = firstName + " " + lastName;
        String firstLineListed = addressPage.getAddressFirstAndLastName().getText();

        Assertions.assertEquals(firstLineListed, firstLineSaved);
    }

    public void checkStreetAddress(){
        String streetAddressSaved = UserFileManager.getUserInformationFile("userInformation").getProperty("userStreetAddress=");
        String streetAddressListed = addressPage.getAddressStreet().getText();

        Assertions.assertEquals(streetAddressListed, streetAddressSaved);
    }

    public void checkCityStateAndPostalCode(){
        String city = UserFileManager.getUserInformationFile("userInformation").getProperty("userCityAddress=");;
        String state = UserFileManager.getUserInformationFile("userInformation").getProperty("userStateAddress=");;;
        String postalCode = UserFileManager.getUserInformationFile("userInformation").getProperty("userPostalAddress=");;;;
        String thirdLineSaved = city + ", " + state + " " + postalCode;
        String thirdLineListed = addressPage.getAddressCityStatePostalCode().getText();

        Assertions.assertEquals(thirdLineListed, thirdLineSaved);
    }

    public void checkCountryAddress(){
        String countrySaved = UserFileManager.getUserInformationFile("userInformation").getProperty("userCountryAddress=");;;
        String countryListed = addressPage.getAddressCountry().getText();

        Assertions.assertEquals(countryListed, countrySaved);
    }

    public void checkMobilePhoneNumber(){
        String mobilePhoneSaved = UserFileManager.getUserInformationFile("userInformation").getProperty("userMobilePhone=");;;;
        String mobilePhoneListed = addressPage.getMobilePhone().getText();

        Assertions.assertEquals(mobilePhoneListed, mobilePhoneSaved);
    }

    public void confirmAddressInformation(){
        checkFirstAndLastName();
        checkStreetAddress();
        checkCityStateAndPostalCode();
        checkCountryAddress();
        checkMobilePhoneNumber();

        addressPage.getProceedToCheckoutButton().click();
        validateNextPage();
    }
}
