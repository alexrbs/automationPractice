package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationPage {
    private WebDriver driver;
    private Waits waits;

    public PersonalInformationPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement getPersonalInformationPageName(){
        return waits.visibilityOfElement(By.xpath("//*[@id='columns']/div[1]/span[2]"));
    }

    public WebElement getUserTitleMr(){
        return waits.visibilityOfElement(By.id("id_gender1"));
    }

    public WebElement getFirstNameTextField(){
        return waits.visibilityOfElement(By.id("customer_firstname"));
    }

    public WebElement getLastNameTextField(){
        return waits.visibilityOfElement(By.id("customer_lastname"));
    }

    public WebElement getEmailTextField(){
        return waits.visibilityOfElement(By.id("email"));
    }

    public WebElement getPasswordTextField(){
        return waits.visibilityOfElement(By.id("passwd"));
    }

    public Select getDayDateOfBirthSelectField(){
        Select select = new Select(waits.visibilityOfElement(By.id("days")));
        return select;
    }

    public Select getMonthDateOfBirthSelectField(){
        Select select = new Select(waits.visibilityOfElement(By.id("months")));
        return select;
    }

    public Select getYearDateOfBirthSelectField(){
        Select select = new Select(waits.visibilityOfElement(By.id("years")));
        return select;
    }

    public WebElement getNewsletterCheckBox(){
        return waits.visibilityOfElement(By.id("newsletter"));
    }

    public WebElement getSpecialOffersCheckBox(){
        return waits.visibilityOfElement(By.id("optin"));
    }

    public WebElement getAddressFirstNameTextField(){
        return waits.visibilityOfElement(By.id("firstname"));
    }

    public WebElement getAddressLastNameTextField(){
        return waits.visibilityOfElement(By.id("lastname"));
    }

    public WebElement getAddressCompanyTextField(){
        return waits.visibilityOfElement(By.id("company"));
    }

    public WebElement getAddressStreetTextField(){
        return waits.visibilityOfElement(By.id("address1"));
    }

    public WebElement getAddressSecondStreetTextField(){
        return waits.visibilityOfElement(By.id("address2"));
    }

    public WebElement getAddressCityTextField(){
        return waits.visibilityOfElement(By.id("city"));
    }

    public Select getAddressStateSelectField(){
        Select state = new Select(driver.findElement((By.id("id_state"))));
        return state;
    }

    public WebElement getAddressPostalCodeTextField(){
        return waits.visibilityOfElement(By.id("postcode"));
    }

    public Select getAddressCountrySelectField(){
        Select country = new Select(driver.findElement(By.id("id_country")));
        return country;
    }

    public WebElement getAddressAdditionalInformationTextField(){
        return waits.visibilityOfElement(By.id("other"));
    }

    public WebElement getAddressHomePhoneNumberTextField(){
        return waits.visibilityOfElement(By.id("phone"));
    }

    public WebElement getAddressMobilePhoneNumberTextField(){
        return waits.visibilityOfElement(By.id("phone_mobile"));
    }

    public WebElement getAddressAliasTextField(){
        return waits.visibilityOfElement(By.id("alias"));
    }

    public WebElement getRegisterButton(){
        return waits.visibilityOfElement(By.id("submitAccount"));
    }
}
