package controllers;


import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @date Aug 18, 2018
 */

public class BrowserFactory extends InitMethod {
    static WebDriver driver;
    //static DesiredCapabilities capabilities;

    public void detectBrowser() {
        System.out.println("Browser detection");
        switch (Browser.toLowerCase()) {
            case "chrome":
            case "chrome_headless":
            case "opera":
                String chromeVersion = ChromeBrowserVersion;
                if ("default".equalsIgnoreCase(chromeVersion)) {
                    ChromeDriverManager.chromedriver().setup();
                } else {
                    ChromeDriverManager.chromedriver().version(chromeVersion).setup();
                }
                break;

            case "firefox":
                FirefoxDriverManager.firefoxdriver().setup();
                break;

            case "ie":
            case "internet explorer":
                InternetExplorerDriverManager.iedriver().setup();
                break;

            case "edge":
                EdgeDriverManager.edgedriver().setup();
                break;

            case "ghost":
            case "phantom":
                PhantomJsDriverManager.phantomjs().setup();
                break;

            case "safari":
                break;

            default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");

        }
    }

    @SuppressWarnings("deprecation")
    public static WebDriver createDriver() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();


        switch (Browser.toLowerCase()) {
            case "chrome":
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);

			/*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();*/

                break;

            case "chrome_headless":
			/*ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");  
			chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--remote-debugging-port=9222");
            chromeOptions.addArguments("--window-size=1200,1024");*/
                //driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ie":
            case "internet explorer":
                //DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                //	ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                break;


            default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
        }
        if (ImplicitlyWait > 0) {
            implicitlywait(ImplicitlyWait);
        }

        if (MaxPageLoadTime > 0) {
            setMaxPageLoadTime(MaxPageLoadTime);
        }
        driver.get(WebsiteURL);
        if (!Browser.toLowerCase().contains("unit") || !Browser.toLowerCase().contains("ghost") || !Browser.toLowerCase().contains("phantom")) {
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void implicitlywait(int timeInSeconds) throws Exception {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    public static void setMaxPageLoadTime(int timeInSeconds) throws Exception {
        driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
    }
}
