package StepDefinitions;

import Utility.ProjectConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import webPages.CreateNewArticlePage;

import static io.restassured.RestAssured.given;

public class CreateNewArticlePageSteps {
    CreateNewArticlePage page;


    public CreateNewArticlePageSteps() {
        page = new CreateNewArticlePage();
    }


    @Then("User enters Article Details")
    public void publishArticle() {
        page.setArticleTitle(ProjectConstants.getArticleTitle());
        page.setAboutArticle(ProjectConstants.getAboutArticle());
        page.setArticleDescription(ProjectConstants.getArticleDescription());
        page.setTag(ProjectConstants.getArticleTags());
        page.clickPublishArticleButton();
    }
    @And("User updates Article Details {string} {string} {string} {string}")
    public void userUpdatesArticleDetails(String articleTitle, String aboutArticle, String articleDescription, String tags) {
        ProjectConstants.setArticleTitle(articleTitle);
        ProjectConstants.setAboutArticle(aboutArticle);
        ProjectConstants.setArticleDescription(articleDescription);
        ProjectConstants.setArticleTags(tags);
        publishArticle();
    }
}