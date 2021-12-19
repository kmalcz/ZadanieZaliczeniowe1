package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    public WebElement emailInputLoginPage;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    public WebElement passwordInputLoginPage;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    public WebElement signInButtonLoginPage;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userNameConfirmation;

    public void enterEmail(String email) {
        emailInputLoginPage.click();
        emailInputLoginPage.clear();
        emailInputLoginPage.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordInputLoginPage.click();
        passwordInputLoginPage.clear();
        passwordInputLoginPage.sendKeys(password);
    }

    public void logIntoAccount(){
        signInButtonLoginPage.click();
    }

    public String getUserNameConfirmation() {
        return userNameConfirmation.getText();
    }
}
