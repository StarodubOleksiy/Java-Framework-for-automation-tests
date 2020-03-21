package pageObjects.pages;

import data.AccountVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;


/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
public class StoneEdgeTradingDashboard extends PageFactoryInitializer {


    @FindBy(xpath = "//span[@data-menu-item='trading']")
    private WebElement tradingLink;

    @FindBy(xpath = "//span[@data-menu-item='finances']")
    private WebElement financesLink;

    @FindBy(xpath = "//span[@data-menu-item='news']")
    private WebElement newsLink;

    @FindBy(xpath = "//span[@data-menu-item='history']")
    private WebElement historyLink;

    @FindBy(xpath = "//span[contains(text(),'Add widget')]")
    private WebElement addWidgetButton;

    @FindBy(xpath = "//span[contains(text(),'Add Board')]")
    private WebElement addBoardButton;

    @FindBy(xpath = "//span[contains(text(),'Trading Board')]")
    private WebElement trainingBoardButton;

    @FindBy(xpath = "//div[contains(@class,'TopBar-components-TopBarButton-___style__active')]")
    private WebElement selectedTab;

    @FindBy(xpath = "//div[contains(@class,'TopBarButton-___style__cross')]")
    private WebElement crossButton;

    @FindBy(css = "[class*='TopBar'] input")
    private WebElement tabTitleInput;

    @FindBy(xpath = "//div[span[contains(@class,'TopBar-components-TopBarButton')]]")
    private List<WebElement> boardTabList;

    @FindBy(xpath = "//button[i[contains(@class,'icon-icon-header-hide')]]")
    private WebElement hideHeaderButton;

    @FindBy(xpath = "//button[i[contains(@class,'icon-icon-header-show')]]")
    private WebElement showHeaderButton;

    @FindBy(css = "[class*='app-pages-TradingPage']")
    private WebElement headerIndicator;

    @FindBy(css = "[class*='WidgetContainer'] [class*='header-title']")
    private WebElement widgetHeader;

    @FindBy(xpath = "//div[contains(@class,'Dashboard-components-WidgetContainer')]/span/div")
    private List<WebElement> widgetBoardersAndAngles;

    @FindBy(xpath = "//div[contains(@class,'components-WidgetContainer')]")
    private WebElement widgetContainer;

    @FindBy(xpath = "//span[contains(@class,'app-containers-Footer-___style__text___28qmq')]")
    private List<WebElement> tradingFieldsList;

    @FindBy(xpath = "//span[contains(@class,'app-containers-Footer-___style__value___1FqzF')]")
    private List<WebElement> variablesList;

    @FindBy(xpath = "//span[contains(@class,'notification-center')]")
    private WebElement notificationButton;

    @FindBy(xpath = "//span[contains(@class,'style__profile-icons-icon')]")
    private WebElement settingButton;

    @FindBy(xpath = "//header[contains(@class,'style__header___Mym9c')]//button[contains(text(),'OK')]")
    private WebElement notificationOkButton;

    @FindBy(xpath = "//a[contains(@class,'style__profile-account-details-logout___3Pn6R')]")
    private WebElement logOutLink;

    @FindBy(xpath = "//div[contains(@class,'style__profile-account-details-info-fullname___28rtU')]")
    private WebElement accountDiv;

    @FindBy(xpath = "//div[contains(@class,'Dashboard-components-Panel-___style__panel')]")
    private WebElement backgroundDivColor;

//    @FindBy(xpath = "//span[@class='app-containers-SelectAccountPopup-___style__balance___3MGDw']")
//    private List<WebElement> accountCurrency;

    @Step("Validate I am on Dashboard")
    public StoneEdgeTradingDashboard validateDashboard() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingLink, 30, "Trading");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(financesLink, 30, "Finances");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(newsLink, 30, "News");
        return this;
    }

    @Step("Validate the Page Title of the Stone Edge main page")
    public StoneEdgeTradingDashboard verifyPageTitle() {
        // FluentWaiting.waitForTitleToBe(60, 500, "Trading - Unity Finance");
        FluentWaiting.waitForTitleToBe(60, 500, "Trading - Stone Edge Trader");

        return this;
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Click to newsLink")
    public StoneEdgeTradingDashboard clickToNewsLink() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, newsLink);
        newsLink.click();
        return this;
    }

    @Step("Click to add widget button")
    public StoneEdgeTradingDashboard clickAddWidgetButton() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, addWidgetButton);
        addWidgetButton.click();
        return this;
    }

    @Step("Click setting button")
    public StoneEdgeTradingDashboard clickSettingButton() {
        sleep(7000);
        scrollIntoView(settingButton);
        FluentWaiting.waitUntillElementToBeVisible(60, 500, settingButton);
        settingButton.click();
        return this;
    }

    @Step("Click to add board button")
    public StoneEdgeTradingDashboard addNewBoard(String boardName) {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, addBoardButton);
        addBoardButton.click();
       // Actions act = new Actions(getWebDriver());
     //   act.sendKeys(boardName + Keys.ENTER).perform();
        return this;
    }

    @Step("Select board")
    public StoneEdgeTradingDashboard selectBoard(String boardName) {
        boardTabList.stream().filter(tab -> tab.getText().equals(boardName)).findFirst().get().click();
        return this;
    }

    @Step("Rename newest board")
    public StoneEdgeTradingDashboard renameActiveBoard(String boardName) {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, selectedTab);
        //new Actions(getWebDriver()).doubleClick(selectedTab).perform();
        tabTitleInput.sendKeys(boardName + Keys.ENTER);
        return this;
    }

    @Step("Verify board with name {0} exists")
    public StoneEdgeTradingDashboard verifyBoardPresent(String expectedValue) {
        sleep(3000);
        Optional<WebElement> board = getTabByName(expectedValue);
        assertTrue(board.isPresent());
        return this;
    }

    @Step("Verify board with name {0} does not exists")
    public StoneEdgeTradingDashboard verifyBoardNotPresent(String expectedValue) {
        Optional<WebElement> board = getTabByName(expectedValue);
        assertFalse(board.isPresent());
        return this;
    }

    private Optional<WebElement> getTabByName(String expectedValue) {
        return boardTabList.stream().filter(e -> e.getText().equals(expectedValue)).findFirst();
    }

    @Step("Close selected tab")
    public StoneEdgeTradingDashboard closeSelectedBoard() {
        scrollIntoView(crossButton);
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, crossButton);
        crossButton.click();
        return this;
    }

    @Step("Close all tabs")
    public StoneEdgeTradingDashboard closeAllTabs() {
        for (WebElement tab : boardTabList) {
            if (isElementPresent("//div[contains(@class,'TopBarButton-___style__cross')]")) {
                crossButton.click();
            }
        }
        return this;
    }

    @Step("verify if <<add board>> button is  not present on dashboard")
    public StoneEdgeTradingDashboard checkAddBoardButtonNotPresent() {
        sleep(1000);
        Assert.assertFalse(isElementPresent("//span[contains(text(),'Add Board')]"));
        return this;
    }

    @Step("Click to hide header")
    public StoneEdgeTradingDashboard clickHideHeader() {
        hideHeaderButton.click();
        return this;
    }

    @Step("Click to Training Board")
    public StoneEdgeTradingDashboard clickTrainingBoardButton() {
        trainingBoardButton.click();
        return this;
    }

    @Step("Check if Dashboard is expanded/collapsed(header is hidden/visible)")
    public boolean isHeaderVisible() {
        return !headerIndicator.getAttribute("class").contains("no-header");
    }

    @Step("Move widget")
    public StoneEdgeTradingDashboard verifyWidgetCanBeMoved(int XOffset, int YOffset) throws Exception {
        return moveWidget(XOffset, YOffset, widgetHeader);
    }

    @Step("Move exact widget")
    public StoneEdgeTradingDashboard verifyExactWidgetCanBeMoved(String widgetName, int XOffset, int YOffset) throws Exception {
        WebElement header = getWebDriver().findElement(By.cssSelector(Pattern.compile(String.format("[data-window\\-name='%s'] [class*='header-title']", widgetName)).toString()));
        return moveWidget(XOffset, YOffset, header);
    }

    private StoneEdgeTradingDashboard moveWidget(int XOffset, int YOffset, WebElement header) throws Exception {
        Point location1 = header.getLocation();
        Point location2 = header.getLocation();
        assertNotEquals(location1, location2);
        return this;
    }

    @Step("Click to show header")
    public StoneEdgeTradingDashboard clickShowHeader() {
        showHeaderButton.click();
        return this;
    }

    @Step("Resize widget")
    public StoneEdgeTradingDashboard verifyWidgetCanBeResized() throws Exception {
        for (WebElement border : widgetBoardersAndAngles) {
            Dimension sizeBefore = widgetContainer.getSize();
            try {
                     } catch (Exception e1) {
                e1.printStackTrace();
            }
            Dimension sizeAfter = widgetContainer.getSize();
            assertNotEquals(sizeBefore, sizeAfter);
        }
        return this;
    }

    @Step("Resize top border with xOffset (0) and YOffset (0)")
    public StoneEdgeTradingDashboard resizeTopBorder(int xOffset, int yOffset) throws Exception {
        WebElement border = widgetBoardersAndAngles.get(0);
        try {
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return this;
    }

    @Step("Verifying fields on trading board")
    public StoneEdgeTradingDashboard verifyFieldsOnTradingBoard() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingFieldsList.get(0), 30, "Total assets");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingFieldsList.get(1), 30, "Unrealized P/L");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingFieldsList.get(2), 30, "Closed P/L");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingFieldsList.get(3), 30, "Margin available");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingFieldsList.get(4), 30, "Margin");
        return this;
    }

    @Step("Checking variables on trading board when several orders are different")
    public StoneEdgeTradingDashboard checkingVariablesAreDifferentOnTradingBoard(List<WebElement> firstVariablesList) throws InterruptedException {
        String firstTotalAssets = firstVariablesList.get(0).getText();
        String firstMarginAvailable = firstVariablesList.get(3).getText();
        String firstMargin = firstVariablesList.get(4).getText();
        Thread.sleep(5000);//This line is required. Otherwise, the values will be the same.
        Assert.assertNotEquals(firstTotalAssets, variablesList.get(0).getText());
        Assert.assertNotEquals(firstMarginAvailable, variablesList.get(3).getText());
//        Assert.assertNotEquals(firstMargin, variablesList.get(4).getText()); depending on funds margin can be the same
        return this;
    }

    @Step("Checking variables on trading board when several orders are the same")
    public StoneEdgeTradingDashboard checkingVariablesAreSameOnTradingBoard(List<WebElement> firstVariablesList) throws InterruptedException {
        String firstTotalAssets = firstVariablesList.get(0).getText();
        String firstUnrealizedPL = firstVariablesList.get(1).getText();
        String firstClosedPL = firstVariablesList.get(2).getText();
        String firstMarginAvailable = firstVariablesList.get(3).getText();
        String firstMargin = firstVariablesList.get(4).getText();

        Assert.assertTrue(firstTotalAssets.contains(getWholeAmount(variablesList.get(0).getText())));
        Assert.assertTrue(firstUnrealizedPL.contains(getWholeAmount(variablesList.get(1).getText())));
        Assert.assertTrue(firstClosedPL.contains(getWholeAmount(variablesList.get(2).getText())));
        Assert.assertTrue(firstMarginAvailable.contains(getWholeAmount(variablesList.get(3).getText())));
        Assert.assertEquals(firstMargin, variablesList.get(4).getText());
        return this;
    }

    @Step("Click on notifications button")
    public StoneEdgeTradingDashboard clickOnNotificationsButton() {
        sleep(3000);
        scrollIntoView(notificationButton);
        FluentWaiting.waitUntillElementToBeClickable(60, 500, notificationButton);
        notificationButton.click();
        return this;
    }

    @Step("Verify if notification <<OK>> button is not present on dashboard")
    public StoneEdgeTradingDashboard verifyIfNotificationsOkButtonIsNotPresent() {
        Assert.assertFalse(this.isElementPresent("//header[contains(@class,'app-containers-Header-___style__header___Mym9c')]//button[contains(text(),'OK')]"));
        return this;
    }

    @Step("Click on <<OK>> button on notifications")
    public StoneEdgeTradingDashboard clickOnNotificationsOkButton() {
        FluentWaiting.waitUntillElementToBeClickable(60, 500, notificationOkButton);
        notificationOkButton.click();
        return this;
    }

    @Step("Click to log out from dashbord")
    public StoneEdgeTradingDashboard logOut() {
        sleep(5000);
        FluentWaiting.waitUntillElementToBeClickable(60, 500, logOutLink);
        logOutLink.click();
        return this;
    }

    @Step("Verify account name")
    public StoneEdgeTradingDashboard verifyAccount(String accountName) {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(accountDiv, 30, accountName);
        return this;
    }

    @Step("Verify of variables list from several accounts ")
    public StoneEdgeTradingDashboard verificationVariablesOfSeveralAccounts(AccountVariables accountVariables) {
        Assert.assertNotEquals(accountVariables.getTotalAssets(), variablesList.get(0).getText());
        Assert.assertNotEquals(accountVariables.getMarginAvailable(), variablesList.get(3).getText());
        return this;
    }

    public List<WebElement> getVariablesList() {
        return variablesList;
    }

    public AccountVariables getAccountVariables() {
        return new AccountVariables(variablesList.get(0).getText(), variablesList.get(1).getText(),
                variablesList.get(2).getText(), variablesList.get(3).getText(), variablesList.get(4).getText());
    }

    @Step("Verify currency on dash board ")
    public StoneEdgeTradingDashboard verifyCurrencyOnBoard(String currency) {
        sleep(4000);
        String actualCurrency = String.valueOf(variablesList.get(0).getText().toCharArray(),
                variablesList.get(0).getText().length() - 3, 3);
        Assert.assertEquals(currency, actualCurrency);
        return this;
    }

    public String getCurrency() {
        String currency = String.valueOf(variablesList.get(0).getText().toCharArray(),
                variablesList.get(0).getText().length() - 3, 3);
        return currency;
    }

    @Step("Verify css colour on dash board ")
    public StoneEdgeTradingDashboard verifyCssColor(String colourNumber) {
        sleep(2000);
        Assert.assertEquals(backgroundDivColor.getCssValue("color"), colourNumber);
        return this;
    }

    @Step("Click on finances link on dash board ")
    public StoneEdgeTradingDashboard clickFinancesLink() {
        sleep(3000);
        financesLink.click();
        return this;
    }

    @Step("Click on history link on dash board ")
    public StoneEdgeTradingDashboard clickHistoryLink() {
        sleep(3000);
        historyLink.click();
        return this;
    }

    @Step("Click on trading link on dash board ")
    public StoneEdgeTradingDashboard clickTradingLink() {
        sleep(3000);
        tradingLink.click();
        return this;
    }


    @Step("Click on account header ")
    public StoneEdgeTradingDashboard clickOnAccount() {
        sleep(2000);
        accountDiv.click();
        return this;
    }
//
//    @Step("Verify currency on account header")
//    public StoneEdgeTradingDashboard verifyCurrencyOnAccount(int index, String currency) {
//        ExplicitWaiting.explicitWaitTextToBePresentInElement(accountCurrency.get(index), 30, currency);
//        return this;
//    }

    //   public String getAccountCurrency(int index) {
    //       final int CURRENCY_NUMBER = 3;
//        String result = String.valueOf(accountCurrency.get(index).getText().toCharArray(),
//                0, (accountCurrency.get(index).getText().length() - CURRENCY_NUMBER));
//        return result;
//    }

}
