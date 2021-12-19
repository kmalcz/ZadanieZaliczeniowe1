package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressSteps {
    private WebDriver driver;

    @Given ("User is logged in on my store website")
    public void loggingIntoMyStoreAccount(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LogInPage logInPage = new LogInPage(driver);
        logInPage.enterEmail("kacpermalczewski@zz.com");
        logInPage.enterPassword("haslozz1");
        logInPage.logIntoAccount();
        logInPage.getUserNameConfirmation();
    }

    @When("Go through tiles to user addresses page")
    public void goToAddressPage() {
       AddressesPage addressesPage = new AddressesPage(driver);
       addressesPage.addingAddress();
    }

    @Then("Check if page is open on Address Page")
    public void checkAddressHeader() {
        AddressesPage addressesPage = new AddressesPage(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses", addressesPage.getHeaderAddress());
    }


    @And ("^Create address by filling forms with \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void fillingNewAddressForms(String alias, String address, String zipPostalCode, String city, String country, String phone){
        AddressesFormPage addressesFormPage = new AddressesFormPage(driver);
        addressesFormPage.addingNewAddresses(alias, address, zipPostalCode, city, country, phone);
        Assert.assertEquals("Address successfully added!",
                addressesFormPage.getAddressConfirmation());
    }

    @Then ("^Added address should contain \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void CheckEnteredAddress(String alias, String address, String city, String zipPostalCode, String country, String phone) {
        AddressesDataConfirmationPage addressesDataConfirmationPage = new AddressesDataConfirmationPage (driver);
        String userName = "Kacper Malczewski";
        String addressData = userName + '\n' + address + '\n' + city + '\n' + zipPostalCode + '\n' + country + '\n' + phone;
        Assert.assertEquals(alias,
                addressesDataConfirmationPage.getAddressAlias());
        Assert.assertEquals(addressData,
                addressesDataConfirmationPage.getAddressDescription());
    }

    @Then ("Added address should be deleted and the string should contain {string}")
    public void DeleteEnteredAddresses(String deleteConfirmation) {
        DeleteAddressPage deleteAddressPage = new DeleteAddressPage (driver);
        deleteAddressPage.deleteAddedAddress();
        Assert.assertEquals(deleteConfirmation,
                deleteAddressPage.confirmAddressDelete());
    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }
}