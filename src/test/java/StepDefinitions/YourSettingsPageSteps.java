package StepDefinitions;

import io.cucumber.java.en.Then;
import webPages.YourSettingsPage;

public class YourSettingsPageSteps {

    YourSettingsPage page;

    public YourSettingsPageSteps() {
        page = new YourSettingsPage();
    }

    @Then("User verifies signUp Details")
    public void userVerifiesSignUpDetails() {
        if (page.isPageLoaded()){

        };
    }
}
