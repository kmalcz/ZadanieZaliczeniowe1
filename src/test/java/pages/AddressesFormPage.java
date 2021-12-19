package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesFormPage extends BasePage{

    public AddressesFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[text() = 'Create new address']")
    private WebElement createAddress;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement cityInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement zipPostalCodeInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")
    private WebElement countryDropdownList;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")
    private WebElement unitedKingdomDropdownListOption;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

    @FindBy (xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement addressSavedConfirmation;


    public void addingNewAddresses(String alias, String address, String zipPostalCode, String city, String country, String phone){
        createAddress.click();

        aliasInput.click();
        aliasInput.sendKeys(alias);

        addressInput.click();
        addressInput.sendKeys(address);

        zipPostalCodeInput.click();
        zipPostalCodeInput.sendKeys(zipPostalCode);

        cityInput.click();
        cityInput.sendKeys(city);

        countryDropdownList.click();
        countryDropdownList.sendKeys(country);

        phoneInput.click();
        phoneInput.sendKeys(phone);

        saveButton.click();
    }

    public String getAddressConfirmation(){
        return addressSavedConfirmation.getText();
    }
}