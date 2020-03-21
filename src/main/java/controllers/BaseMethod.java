/**
 *
 */
package controllers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

import ru.yandex.qatools.allure.annotations.Step;
import utils.EnvironmentSetup;

/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
public class BaseMethod extends WebDriverFactory {
    /* To get the Website Name */
    public String getUrlTitle() throws Exception {
        URL aURL = new URL(WebsiteURL);
        String WebName = aURL.getHost();
        String WebSiteName = WebName.toUpperCase();
        return WebSiteName;
    }


    /* To Accept the Alert Dialog Message */
    public void alertAccept() throws Exception {
        al = getWebDriver().switchTo().alert();
        al.accept();
    }


    /* To click a certain Web Element */
    public void click(WebElement element) {
        element.click();
    }


    /* To click a certain Web Element using DOM/ JavaScript Executor */
    public void JSclick(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("return arguments[0].click();", element);
    }


    /* To Type at the specified location */
    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }


    /* To Clear the content in the input location */
    public void clear(WebElement element) {
        element.clear();
    }


     /*To Switch To Frame By Index */
    public void switchToFrameByIndex(int index) throws Exception {
        getWebDriver().switchTo().frame(index);
    }


    /*To Switch To Frame By Frame Name */
    public void switchToFrameByFrameName(String frameName) throws Exception {
        getWebDriver().switchTo().frame(frameName);
    }


    /*To Switch To Frame By Web Element */
    public void switchToFrameByWebElement(WebElement element) throws Exception {
        getWebDriver().switchTo().frame(element);
    }


    /*To Switch out of a Frame */
    public void switchOutOfFrame() throws Exception {
        getWebDriver().switchTo().defaultContent();
    }


    /*To Get Tooltip Text */
    public String getTooltipText(WebElement element) {
        String tooltipText = element.getAttribute("title").trim();
        return tooltipText;
    }


    /*To Close all Tabs/Windows except the First Tab */
    public void closeAllTabsExceptFirst() {
        ArrayList<String> tabs = new ArrayList<String>(getWebDriver().getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            getWebDriver().switchTo().window(tabs.get(i));
            getWebDriver().close();
        }
        getWebDriver().switchTo().window(tabs.get(0));
    }


    /*To Print all the Windows */
    public void printAllTheWindows() {
        ArrayList<String> al = new ArrayList<String>(getWebDriver().getWindowHandles());
        for (String window : al) {
            System.out.println(window);
        }
    }

    protected void clickDynamicElement(By element) throws Exception {
        for (int i = 0; i < 20; ++i) {
            try {
                scrollIntoView(getWebDriver().findElement(element));
                getWebDriver().findElement(element).click();
                return;
            } catch (WebDriverException e) {
                System.out.println("WebDriverException was caught when clicking " + element.toString());
                Thread.sleep(500);
                continue;
            }
        }
    }

    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void makeElementVisible(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.display='block';", element);
    }

    protected void selectFirstEnabledDate() {
        getWebDriver().findElement(By.cssSelector("div:not(.react-datepicker__day--disabled).react-datepicker__day")).click();
    }

    protected void sendEmptyKeys(WebElement element) {
        element.sendKeys("");
    }

    public String getWholeAmount(String fullAmount) {
        int dotIndex = fullAmount.indexOf(".");
        if (StringUtils.isEmpty(fullAmount) || dotIndex == -1)
            return fullAmount;
        return fullAmount.substring(0, dotIndex);
    }

    public boolean isElementPresent(String element) {
        List<WebElement> elements = driver.findElements(By.xpath(element));
        return elements.size() > 0;
    }

    @Step("Clear input field")
    public void clearInput(WebElement element) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }


    public boolean clickWebElementIfPresent(String xpathEl){
        try {
            WebElement element = getWebDriver().findElement(By.xpath(xpathEl));
            element.click();
            return true;
        } catch (Exception ex) {
            System.out.println("Element doesn't exist");
            return false;
        }
    }


}
