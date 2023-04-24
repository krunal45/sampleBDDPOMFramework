package webPages;

import Utility.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        HomePage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(HomePage.driver, this);
    }

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav pull-xs-right\"]/li[1]/a")
    private WebElement homeLink;

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav pull-xs-right\"]/li[2]/a")
    private WebElement signINLink;

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav pull-xs-right\"]/li[3]/a")
    private WebElement signUPLink;

    @FindBy(xpath = "//ul[@class=\"nav nav-pills outline-active\"]/li[@class=\"nav-item\"][1]/a")
    private WebElement yourFeedLink;

    @FindBy(xpath = "//ul[@class=\"nav nav-pills outline-active\"]/li[@class=\"nav-item\"][2]/a")
    private WebElement globalFeedLink;

    @FindBy(linkText = " matrix ")
    private WebElement tagLink;

    @FindBy(xpath = "//a[contains(text(),'New Article')]")
    private WebElement newArticleLink;

    @FindBy(css = "body > app-root > app-home-page > div > div > div > div.col-md-9 > app-article-list > app-article-preview:nth-child(2) > div > a > h1")
    private WebElement articleDetailLink;

    @FindBy(css = "a[routerlink='/settings']")
    private WebElement settingsLink;

    @Override
    public boolean isPageValid() {
        explicitlyWait(yourFeedLink);
        return yourFeedLink.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        explicitlyWait(globalFeedLink);
        return globalFeedLink.isDisplayed();
    }

    public void clickYourFeedLink() {
        explicitlyWait(yourFeedLink);
        yourFeedLink.click();
        logger.info("Clicked on your Feed Link");
    }

    public void clickGlobalFeedLink() {
        explicitlyWait(globalFeedLink);
        globalFeedLink.click();
        logger.info("Clicked on global Feed link");
    }

    public void clickHomeLink() {
        explicitlyWait(homeLink);
        homeLink.click();
        logger.info("Clicked on Home link");
    }

    public void clickSignINLink() {
        explicitlyWait(signINLink);
        signINLink.click();
        logger.info("Clicked on Sign IN Link");
        ConfigProperties.setDriverInstance(driver);
    }

    public void clickSignUPLink() {
        explicitlyWait(signUPLink);
        signUPLink.click();
        logger.info("Clicked on Sign UP Link");
        ConfigProperties.setDriverInstance(driver);
    }

    public void clickNewArticleLink() {
        explicitlyWait(newArticleLink);
        newArticleLink.click();
        logger.info("Clicked on New Article link.");
    }

    public void clickArticleDetailLink() {
      explicitlyWait(articleDetailLink);
      articleDetailLink.click();
      logger.info("Clicked on Article Detail link.");
    }

    public void clickSettingsLink(){
        explicitlyWait(settingsLink);
        settingsLink.click();
        logger.info("Clicked on settings link");
        ConfigProperties.setDriverInstance(driver);
    }
}
