package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import webPages.HomePage;

public class HomePageSteps {
    HomePage page;

    public HomePageSteps() {
        page = new HomePage();
    }

    //  HomePage homePage;
    @Then("User is in Home Page")
    public void validatePageLoad() {
        Assert.assertTrue(page.isPageValid(), "FAIL : Page Invalid!");
        Assert.assertTrue(page.isPageLoaded(), "FAIL : Page not loaded!");
    }

    @When("User clicks on SignIN Link")
    public void clickSignINLink() {
        page.clickSignINLink();
    }

    @When("User clicks on newArticle link")
    public void clickNewArticleLink() {
        page.clickNewArticleLink();
    }

    @When("User clicks on SignUP Link")
    public void userClicksOnSignUPLink() {
        page.clickSignUPLink();
    }


    @And("User clicks on YourSettings link")
    public void userClicksOnYourSettingsLink() {
        page.clickSettingsLink();
    }

    @And("Verifies if user is logged into the system")
    public void verifiesIfUserIsLoggedIntoTheSystem() {
        Assert.assertTrue(page.isPageLoaded(), "FAIL : User isn't able to login to system.");
    }
}