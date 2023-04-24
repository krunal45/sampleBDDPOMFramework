package webPages;

import Utility.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {

    public SignUpPage() {
        SignUpPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(SignUpPage.driver, this);
    }

    @FindBy(css = "input[placeholder=Username][type=text]")
    private WebElement userNameLocator;

    @FindBy(css = "input[placeholder=Email][type=text]")
    private WebElement emailLocator;

    @FindBy(css = "input[placeholder=Password][type=password]")
    private WebElement passwordLocator;

    @FindBy(css = "button[type=submit]")
    private WebElement signUPButtonLocator;

    @FindBy(xpath = "//ul[@class=\"error-messages\"]/li[text()=\" username is invalid \"]")
    private WebElement inValidUserNameError;

    @FindBy(xpath = "//ul[@class=\"error-messages\"]/li[text()=\" email is invalid \"]")
    private WebElement inValidEmailError;

    @FindBy(xpath = "//ul[@class=\"error-messages\"]/li[text()=\" username is already taken. \"]")
    private WebElement duplicateUserNameError;

    @FindBy(xpath = "//ul[@class=\"error-messages\"]/li[text()=\" email is already taken. \"]")
    private WebElement duplicateEmailError;


    @Override
    public boolean isPageValid() {
        return emailLocator.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return signUPButtonLocator.isDisplayed();
    }

    public void setUserName(String userName) {
        explicitlyWait(userNameLocator);
        userNameLocator.sendKeys(userName);
        logger.info("Entered userName");
    }

    public void setEmail(String email) {
        explicitlyWait(emailLocator);
        emailLocator.sendKeys(email);
        logger.info("Entered email");
    }

    public void setPassword(String password) {
        explicitlyWait(passwordLocator);
        passwordLocator.sendKeys(password);
        logger.info("Entered password");
    }

    public void clickSignUpButton() {
        explicitlyWait(signUPButtonLocator);
        signUPButtonLocator.click();
        logger.info("Clicked on SignUP button");
    }

    public String getInvalidUserNameValidationError() {
        explicitlyWait(inValidUserNameError);
        return inValidUserNameError.getText();
    }

    public String getInvalidEmailValidationError() {
        explicitlyWait(inValidEmailError);
        return inValidEmailError.getText();
    }

    public String getDuplicateUserNameError() {
        explicitlyWait(duplicateUserNameError);
        return duplicateUserNameError.getText();
    }

    public String getDuplicateEmailError() {
        explicitlyWait(duplicateEmailError);
        return duplicateEmailError.getText();
    }


}