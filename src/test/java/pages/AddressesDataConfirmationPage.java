package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressesDataConfirmationPage extends BasePage{
    public AddressesDataConfirmationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[1]/h4")
    private WebElement addressAlias;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[1]/address")
    private WebElement addressBlock;

    public String getAddressAlias(){
        return addressAlias.getText();
    }
    public String getAddressDescription(){
        return addressBlock.getText();
    }

}
