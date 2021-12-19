package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAddressPage extends BasePage{
    public DeleteAddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement deleteSuccess;

    public void deleteAddedAddress(){
        deleteAddressButton.click();
    }
    public String confirmAddressDelete(){
        return deleteSuccess.getText();
    }

}
