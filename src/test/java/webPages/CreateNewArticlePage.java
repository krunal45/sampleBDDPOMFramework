package webPages;

import Utility.ConfigProperties;
import Utility.ProjectConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewArticlePage extends BasePage {

    public CreateNewArticlePage() {
        CreateNewArticlePage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(CreateNewArticlePage.driver, this);
    }

    @FindBy(css = "input[placeholder='Article Title'][type='text']")
    private WebElement articleTitleLocator;

    @FindBy(xpath = "//input[@type='text' and @placeholder=\"What's this article about?\"]")
    private WebElement aboutArticleLocator;

    @FindBy(xpath = "//textarea[@placeholder=\"Write your article (in markdown)\"]")
    private WebElement articleDescriptionLocator;

    @FindBy(xpath = "//input[@type=\"text\" and @placeholder=\"Enter tags\"]")
    private WebElement tagsLocator;

    @FindBy(xpath = "//button[@type=\"button\"]")
    private WebElement publishArticleBTN;


    @Override
    public boolean isPageValid() {
        return articleTitleLocator.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return publishArticleBTN.isDisplayed();
    }

    public void setArticleTitle(String articleTitle) {
        explicitlyWait(articleTitleLocator);
        articleTitleLocator.clear();
        logger.info("Cleared Article Title");
        articleTitleLocator.sendKeys(articleTitle);
        ProjectConstants.setArticleTitle(articleTitle);
        logger.info("Entered article Title : " + articleTitle);
    }

    public void setAboutArticle(String aboutArticle) {
        explicitlyWait(aboutArticleLocator);
        aboutArticleLocator.clear();
        logger.info("Cleared About article");
        aboutArticleLocator.sendKeys(aboutArticle);
        ProjectConstants.setAboutArticle(aboutArticle);
        logger.info("Entered about Article : " + aboutArticle);
    }

    public void setArticleDescription(String articleDescription) {
        explicitlyWait(articleDescriptionLocator);
        articleDescriptionLocator.clear();
        logger.info("Cleared Article Description");
        articleDescriptionLocator.sendKeys(articleDescription);
        ProjectConstants.setArticleDescription(articleDescription);
        logger.info("Entered article Description : " + articleDescription);
    }

    public void setTag(String tag) {
        explicitlyWait(tagsLocator);
        tagsLocator.clear();
        logger.info("Cleared Tags value.");
        tagsLocator.sendKeys(tag);
        ProjectConstants.setArticleTags(tag);
        logger.info("Entered Tags : " + tag);
    }

    public void clickPublishArticleButton() {
        publishArticleBTN.click();
        logger.info("Clicked on Publish Article Button.");
        ConfigProperties.setDriverInstance(driver);
    }
}
