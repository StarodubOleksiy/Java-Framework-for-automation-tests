package tests;

import controllers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.EnvironmentSetup;

public class BaseTest extends PageFactoryInitializer {
    @BeforeTest(alwaysRun=true)
    public void suiteSetup() throws Exception
    {
        detectBrowser();
    }

    @BeforeMethod
    public void beforeMethod() throws Exception
    {
        System.out.println("Browser: "+Browser);
        System.out.println("WebsiteURL: "+WebsiteURL);
        new WebDriverFactory();
        WebDriver driver = WebDriverFactory.createDriver();
        setWebDriver(driver);

        if(VideoFeature.toLowerCase().contains("enabledfailed"))
        {
            setupVideoRecordingFailedOnly();
        }
        else if(VideoFeature.toLowerCase().contains("enabledall"))
        {
            setupVideoRecordingAll();
        }
    }

    @AfterMethod(alwaysRun=true,enabled=true)
    public void afterMethod() throws Exception
    {
        Thread.sleep(2000);
        getWebDriver().quit();
    }

    @AfterTest
    public void beforeSuite() throws Exception
    {
        EnvironmentSetup.environmentSetup();
    }
}
