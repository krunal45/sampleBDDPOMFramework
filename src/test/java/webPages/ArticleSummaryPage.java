package webPages;

import Utility.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleSummaryPage extends BasePage {

    public ArticleSummaryPage() {
        ArticleSummaryPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(ArticleSummaryPage.driver, this);
    }

    @FindBy(css = "div.banner>div>app-article-meta>div>span:nth-child(3)>a")
    private WebElement editArticle;

    @FindBy(css = "div > div.banner > div > app-article-meta > div > span:nth-child(3) > button")
    private WebElement deleteArticle;

    @FindBy(css = "div.container>h1")
    private WebElement articleTitle;

    @FindBy(css = "div.col-md-12>div>p")
    private WebElement articleDescription;

    @FindBy(css = "div.card-block>textarea[placeholder=\"Write a comment...\"]")
    private WebElement commentBlock;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement postCommentButton;

    @FindBy(css = "a[href='/settings']")
    private WebElement settingsIconLocator;


    @Override
    public boolean isPageValid() {
        return false;
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }

    public void clickEditArticleButton() {
        explicitlyWait(editArticle);
        editArticle.click();
        logger.info("Clicked on Edit Article link");
        ConfigProperties.setDriverInstance(driver);
    }

    public void clickDeleteArticleButton() {
        explicitlyWait(editArticle);
        deleteArticle.click();
        logger.info("Clicked on delete Article link");
        ConfigProperties.setDriverInstance(driver);
    }

    public String getArticleTitle() {
        explicitlyWait(articleTitle);
        return articleTitle.getText();
    }

    public String getArticleDescription() {
        explicitlyWait(articleDescription);
        return articleDescription.getText();
    }

    public void setArticleComment(String articleComment) {
        commentBlock.sendKeys(articleComment);
        logger.info("Entered article Comment.");
    }

    public void clickPostCommentButton() {
        postCommentButton.click();
        logger.info("Clicked on Post Comment button.");
    }

    public void clickSettingsIcon() {
        explicitlyWait(settingsIconLocator);
        settingsIconLocator.click();
        logger.info("Clicked on Settings Icon");
        ConfigProperties.setDriverInstance(driver);
    }
}
