package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleTest1 {
    WebDriver driver;

    @Test(priority = 3)
    public void testCase1(){
        System.out.println("Test Case 1");
    }

    @Test(priority = 4)
    public void testCase2(){
        System.out.println("Test Case 2");
    }

    @Test(priority = 2)
    public void testCase3(){
        System.out.println("Test Case 3");
    }

    @Test(priority = 1)
    public void testCase4(){
        System.out.println("Test Case 4");
    }

    @Test(priority = 5)
    public void testCase5(){
        System.out.println("Test Case 5");
    }

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://google.com");
        System.out.println("Opened Google");
        driver.manage().deleteAllCookies();
        System.out.println("Cookeies cleared.");
        driver.navigate().refresh();
        System.out.println("Page Refreshed");
    }





//    test case 1
//    test case 2
//    test case 3
//    test case 4
//    test case 5
//             
//    make the order of the test cases as 4,3,1,2,5
}
