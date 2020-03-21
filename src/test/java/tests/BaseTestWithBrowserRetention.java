package tests;

import controllers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.EnvironmentSetup;

public class BaseTestWithBrowserRetention extends PageFactoryInitializer {
    @BeforeTest(alwaysRun=true)
    public void suiteSetup() throws Exception
    {
        detectBrowser();
    }

    @BeforeClass
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

    @AfterClass(alwaysRun=true,enabled=true)
    public void afterClass() throws Exception
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
