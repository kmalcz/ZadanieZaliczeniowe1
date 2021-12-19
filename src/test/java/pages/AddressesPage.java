package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div/a[@class='col-lg-4 col-md-6 col-sm-6 col-xs-12'][2]")
    private WebElement addAddressButton;

    public void addingAddress() {
        addAddressButton.click();
    }

    public String getHeaderAddress() {
        return driver.getCurrentUrl();
    }

}
