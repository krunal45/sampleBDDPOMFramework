package webPages;
//
//import org.openqa.selenium.By;

import Utility.ConfigProperties;
import Utility.FakeDataGenerator;
import Utility.FileReadUtil;
import Utility.ProjectConstants;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//
//import java.time.Duration;
//
//public class basePage {
//    public WebDriver driver=null;
//
//    @BeforeSuite
//    public void setUp(String url,String browser){
////        if (browser.equalsIgnoreCase("chrome")) {
//            System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");
//            driver = new ChromeDriver();
//            driver.navigate().to("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
////        }
//    }
//
//    @BeforeTest
//    public void login(){
//        WebElement signINBTN = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav pull-xs-right\"]/li[2]"));
//        signINBTN.click();
//
//        WebElement userNameLoc = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"text\"]")));
//        WebElement passwordLoc = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"password\"]")));
//
//        userNameLoc.sendKeys("krunalb@hexaware.com");
//        passwordLoc.sendKeys("Vishnu@0");
//
//        WebElement loginBTN = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
//        loginBTN.click();
//    }
//}


import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BasePage.class);


    public void setLogFilePath(String path) {
        PropertyConfigurator.configure(path);
    }


    public static void browserSetup(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browser.equals("IEEdge")) {
            WebDriverManager.edgedriver().setup();
        } else if (browser.equals("Safari")) {
            WebDriverManager.safaridriver().setup();
        } else {
            logger.info("Browser not supported. Please choose from i)chrome ii)firefox iii)IEEdge or iv)Safari");
        }
    }

    public static void launchBrowser(String browser) {
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("IEEdge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("Safari")) {
            driver = new SafariDriver();
        } else {
            logger.info("Browser not supported. Please choose from i)chrome ii)firefox iii)IEEdge or iv)Safari");
        }
        ConfigProperties.setDriverInstance(driver);
    }

    public static void openAppURL(String url) {
        driver.get(url);
        logger.info("Opened url " + url);
    }


    public static void ImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigProperties.ImplicitWaitTimeoutDurationInSeconds)));
    }

    public static void explicitlyWait(WebElement elementXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigProperties.ExplicitWaitTimeoutDurationInSeconds)));
        wait.until(ExpectedConditions.elementToBeClickable(elementXpath));
    }

    public static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigProperties.PageloadTimeoutDurationInSeconds)));
    }

    @After
    public static void closeTab() {
        driver.close();
        logger.info("Tab closed");
    }

    public static void closeWindow() {
        driver.quit();
        logger.info("Window closed");
    }

    public abstract boolean isPageValid();

    public abstract boolean isPageLoaded();

    public static void fetchData() {
        if (ConfigProperties.wantToGenerateDataAutomatically.equalsIgnoreCase("no")) {
            ProjectConstants.setArticleTitle(FileReadUtil.getCSVData("articleTitle"));
            ProjectConstants.setAboutArticle(FileReadUtil.getCSVData("aboutArticle"));
            ProjectConstants.setArticleDescription(FileReadUtil.getCSVData("articleDescription"));
            ProjectConstants.setArticleTags(FileReadUtil.getCSVData("tags"));
        } else if (ConfigProperties.wantToGenerateDataAutomatically.equalsIgnoreCase("yes")) {
            ProjectConstants.setArticleTitle(FakeDataGenerator.getFakeData("articleTitle"));
            ProjectConstants.setAboutArticle(FakeDataGenerator.getFakeData("aboutArticle"));
            ProjectConstants.setArticleDescription(FakeDataGenerator.getFakeData("articleDescription"));
            ProjectConstants.setArticleTags(FakeDataGenerator.getFakeData("tags"));
        } else {
            System.out.println("Invalid input for wantToGenerateDataAutomatically field in config.properties file. Allowed values are yes/no");
        }
    }


}

