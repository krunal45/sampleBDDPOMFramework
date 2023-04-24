package StepDefinitions;

import Utility.ConfigProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import webPages.ArticleSummaryPage;
import webPages.YourSettingsPage;

import static webPages.BasePage.*;

public class BasePageSteps {

    @Before
    public void setup() {
        browserSetup(ConfigProperties.browserName);
        launchBrowser(ConfigProperties.browserName);
        openAppURL(ConfigProperties.applicationUrl);
        fetchData();
    }

    @After
    public void closeBrowserWindow() {
        closeWindow();
    }
}