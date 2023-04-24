package StepDefinitions;

import Utility.ProjectConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import webPages.LoginPage;

public class LoginPageSteps {

    LoginPage page;

    public LoginPageSteps() {
        page = new LoginPage();
    }

    @Then("User is navigated to SignIN Page")
    public void checkPageLoad() {
        Assert.assertTrue(page.isPageValid(), "FAIL: Page Invalid!");
        Assert.assertTrue(page.isPageLoaded(), "FAIL: Page not loaded!");
    }

    @Given("user enters correct un and pwd")
    public void enterCredentials() {
        page.setUserName();
        page.setPassword();
    }

    @When("clicks on login button")
    public void clicksOnLoginButton() {
        page.clickSignInBTN();
    }

    @Given("user enters {string} {string}")
    public void userEntersUserNamePassword(String userName, String password) {
        page.setUserName(userName);
        page.setPassword(password);
        ProjectConstants.setUserName(userName);
        ProjectConstants.setPassword(password);
    }

    @Then("signIN Button should be disabled")
    public void signinButtonShouldBeDisabled() {
        if (ProjectConstants.getUserName().isBlank() || ProjectConstants.getPassword().isBlank()) {
            Assert.assertFalse(page.isSignINButtonEnabled(), "FAIL: SignIn Button is Enabled!");
        } else {
            Assert.assertTrue(page.isSignINButtonEnabled(), "FAIL: SignIN Button is Disabled");
        }
    }

    @Then("validation Error should be Displayed as per {string}")
    public void validationErrorShouldBeDisplayedAsPer(String scenario) {
        if (scenario.equals("inValidUserName & inValidPassword") || scenario.equals("validUserName & inValidPassword") || scenario.equals("invalidUserName & ValidPassword")) {
            Assert.assertEquals(page.getInvalidUserNameEmailError().trim(), "email or password is invalid", "FAIL: Invalid validation Error");
        } else {
            System.out.println("Invalid scenario");
        }
    }
}