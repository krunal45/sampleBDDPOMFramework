package StepDefinitions;

import Utility.FakeDataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import webPages.SignUpPage;

public class SignUpPageSteps {

    SignUpPage page;

    public SignUpPageSteps() {
        page = new SignUpPage();
    }


    @Then("User enters signUp Details")
    public void userEntersSignUpDetails() {
        page.setUserName(FakeDataGenerator.getFakeData("userName"));
        page.setEmail(FakeDataGenerator.getFakeData("email"));
        page.setPassword(FakeDataGenerator.getFakeData("password"));
        page.clickSignUpButton();
    }

    @Then("User enters invalid {string} {string} and correct {string}")
    public void userEntersIncorrectUserNameAndPassword(String userName, String email, String password) {
        page.setUserName(userName);
        page.setEmail(email);
        page.setPassword(password);
        page.clickSignUpButton();
    }


    @And("Verifies if validation error is displayed")
    public void verifiesIfValidationErrorIsDisplayed() {
        Assert.assertEquals(page.getInvalidUserNameValidationError(), "username is invalid", "FAIL : Validation error mismatch.");
        Assert.assertEquals(page.getInvalidEmailValidationError(), "email is invalid", "FAIL: Validation error mismatch.");
    }

    @And("Verifies if validation Error is displayed for existing userName and email")
    public void verifiesIfValidationErrorIsDisplayedForExistingUserNameAndEmail() {
      Assert.assertEquals(page.getDuplicateUserNameError(),"username is already taken.","FAIL: Validation error mismatch.");
      Assert.assertEquals(page.getDuplicateEmailError(),"email is already taken.","FAIL: Validation error mismatch.");
    }
}
