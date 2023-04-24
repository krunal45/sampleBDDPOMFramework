package webPages;

import Utility.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        LoginPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(LoginPage.driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement userNameLocator;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordLocator;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signINBTN;

    @FindBy(xpath = "//ul[@class='error-messages']/li[text()=' email or password is invalid ']")
    private WebElement emailOrPasswordInvalidError;

    @Override
    public boolean isPageValid() {
        return signINBTN.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return passwordLocator.isDisplayed();
    }

    public void setUserName() {
        userNameLocator.sendKeys(System.getenv("EMAIL"));
        logger.info("Entered userName");
    }

    public void setUserName(String userName) {
        userNameLocator.sendKeys(userName);
        logger.info("Entered userName");
    }

    public void setPassword() {
        passwordLocator.sendKeys(System.getenv("PASSWORD"));
        logger.info("Entered Password");
    }

    public void setPassword(String password) {
        passwordLocator.sendKeys(password);
        logger.info("Entered Password");
    }

    public void clickSignInBTN() {
        signINBTN.click();
        logger.info("Clicked on Sign IN BTN");
        ConfigProperties.setDriverInstance(driver);
    }

    public boolean isSignINButtonEnabled() {
        return signINBTN.isEnabled();
    }

    public String getInvalidUserNameEmailError() {
        explicitlyWait(emailOrPasswordInvalidError);
        return emailOrPasswordInvalidError.getText();
    }
}