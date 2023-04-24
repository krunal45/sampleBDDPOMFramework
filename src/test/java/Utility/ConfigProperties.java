package Utility;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ConfigProperties {
    public static String browserName, applicationEnvironment, applicationUrl, ExplicitWaitTimeoutDurationInSeconds, ImplicitWaitTimeoutDurationInSeconds,
            PageloadTimeoutDurationInSeconds, GetArticleDetailsAPIBaseURL,wantToGenerateDataAutomatically, CSVFilePath;
    public static WebDriver driver;

    static {
        try {
            FileReadUtil.loadPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        browserName = FileReadUtil.getProperty("browserName");
        applicationEnvironment = FileReadUtil.getProperty("applicationEnvironment");
        applicationUrl = FileReadUtil.getProperty("applicationUrl");
        ExplicitWaitTimeoutDurationInSeconds = FileReadUtil.getProperty("ExplicitWaitTimeoutDurationInSeconds");
        ImplicitWaitTimeoutDurationInSeconds = FileReadUtil.getProperty("ImplicitWaitTimeoutDurationInSeconds");
        PageloadTimeoutDurationInSeconds = FileReadUtil.getProperty("PageLoadTimeoutDurationInSeconds");
        GetArticleDetailsAPIBaseURL = FileReadUtil.getProperty("GetArticleDetailsAPIBaseURL");
        CSVFilePath = FileReadUtil.getProperty("csvFilePath");
        wantToGenerateDataAutomatically= FileReadUtil.getProperty("wantToGenerateDataAutomatically");
    }

    public static void setDriverInstance(WebDriver driver) {
        ConfigProperties.driver = driver;
    }

    public static WebDriver getDriverInstance() {
        return ConfigProperties.driver;
    }

}
