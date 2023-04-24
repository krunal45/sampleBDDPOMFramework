package webPages;

import Utility.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourSettingsPage extends BasePage {

    public YourSettingsPage() {
        YourSettingsPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(YourSettingsPage.driver, this);
    }

    @FindBy(css = "h1.text-xs-center")
    private WebElement yourSettingsHeader;

    @FindBy(css = "input[placeholder=Username][type=text]")
    private WebElement userNameLocator;

    @FindBy(css = "input[placeholder=Email][type=email]")
    private WebElement emailLocator;

    @FindBy(css = "input[type=password]")
    private WebElement passwordLocator;

    @FindBy(css = "button[type=submit]")
    private WebElement updateSettingsLocator;

    @FindBy(css = "a[href='/settings']")
    private WebElement settingsIconLocator;

    @FindBy(css = "button.btn.btn-outline-danger")
    private WebElement logoutButtonLocator;

    @Override
    public boolean isPageValid() {
        return yourSettingsHeader.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return logoutButtonLocator.isDisplayed();
    }

    public void setUserName(String userName) {
        explicitlyWait(userNameLocator);
        userNameLocator.clear();
        logger.info("Cleared userName value");
        userNameLocator.sendKeys(userName);
        logger.info("Entered Username");
    }

    public void setEmail(String email) {
        explicitlyWait(emailLocator);
        emailLocator.clear();
        logger.info("Cleared email value");
        emailLocator.sendKeys(email);
        logger.info("Entered Email.");
    }

    public void setPassword(String password) {
        explicitlyWait(passwordLocator);
        passwordLocator.clear();
        logger.info("Cleared password");
        passwordLocator.sendKeys(password);
        logger.info("Entered password");
    }

    public void clickUpdateSettingsButton() {
        explicitlyWait(updateSettingsLocator);
        updateSettingsLocator.click();
        logger.info("Clicked on updateSettings button");
        ConfigProperties.setDriverInstance(driver);
    }

    public void clickSettingsIcon() {
        explicitlyWait(settingsIconLocator);
        settingsIconLocator.click();
        logger.info("Clicked on Settings Icon");
    }

    public void clickLogoutButton() {
        explicitlyWait(logoutButtonLocator);
        logoutButtonLocator.click();
        logger.info("Clicked on logout button");
        ConfigProperties.setDriverInstance(driver);
    }
}