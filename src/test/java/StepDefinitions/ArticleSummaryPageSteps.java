package StepDefinitions;

import Utility.ProjectConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import webPages.ArticleSummaryPage;

public class ArticleSummaryPageSteps {

    ArticleSummaryPage page;

    public ArticleSummaryPageSteps() {
        page = new ArticleSummaryPage();
    }

    @Then("User clicks on editArticle Link")
    public void clickEditArticleLink() {
        page.clickEditArticleButton();
    }

    @And("Verifies if data entered is correctly saved")
    public void verifyArticleDetails() {
        Assert.assertEquals(page.getArticleTitle(), ProjectConstants.getArticleTitle(), "FAIL: Article Title values mismatch.");
        Assert.assertEquals(page.getArticleDescription(), ProjectConstants.getArticleDescription(), "FAIL: Article Description values mismatch.");
    }
}