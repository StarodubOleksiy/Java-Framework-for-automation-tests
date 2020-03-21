package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class WatchlistWidget extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@data-window-name='watchlist']//div[contains(text(),'Watchlist')]")
    private WebElement watchlistWidgetHeader;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//span[contains(@class,'InstrumentCategory-___style__label-box-text___Q-JQl')]")
    private List<WebElement> instrumentCategoryList;

    @FindBy(css = "[data-watchlist-button='new']")
    private WebElement newWatchlistButton;

    @FindBy(css = "[data-watchlist-action='edit']")
    private WebElement editWatchlistButton;

    @FindBy(xpath = "//span[contains(@class,'Watchlist')]/span[contains(text(),'Delete')]")
    private WebElement deleteWatchlistButton;

    @FindBy(xpath = "//div[contains(@class,'Watchlist')]//button[contains(@class,'app-components-TabsHead')]")
    private List<WebElement> watchlistTabList;

    @FindBy(xpath = "//button[contains(@class,'Watchlist')]/i[contains(@class,'icon-icon-list-view')]")
    private WebElement listViewButton;

    @FindBy(xpath = "//button[contains(@class,'Watchlist')]/i[contains(@class,'icon-icon-block-view')]")
    private WebElement blockViewButton;

    @FindBy(xpath = "//div[contains(@class,'Watchlist-___style__radioButtonsShrinked')]/button")
    private List<WebElement> amountRadioButtons; //TODO it's okay in list?

    @FindBy(xpath = "//input[contains(@class,'Watchlist-___style__amount-input')]")
    private WebElement amountInput;

    @FindBy(xpath = "//div[contains(@class,'Watchlist-components-TradingBoard-___style__trade-ticket-wrapper')]")
    private List<WebElement> tradeTicketList;

    //trade ticket
    @FindBy(xpath = "//div[@data-window-name='watchlist']//div[@class='Select-control']//input")
    private List<WebElement> selectAmountList;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//button[contains(text(), 'Make an order')]")
    private List<WebElement> makeAnOrderButtonList;

    @FindBy(xpath = "//div[contains(@class,'ConfirmationDialog')]/button/span[contains(text(), 'Delete')]")
    private WebElement deleteWatchlistConfirmButton;

    //select widget menu
//@FindBy(xpath = div[contains(@class,'Watchlist')]//i[contains(@class,'icon-icon-wathclist-widget-menu')]")
    //@FindBy(css = "[class='icon-icon-wathclist-widget-menu']")
    @FindBy(xpath = "//div[contains(@class,'Watchlist')]//i[contains(@class,'icon-icon-wathclist-widget-menu')]")
    private List<WebElement> instrumentMenuButtons;

    @FindBy(css = "[class='icon-icon-widget-chart']")
    private WebElement selectChartWidgetButton;

    @FindBy(css = "[class='icon-icon-widget-market-depth']")
    private WebElement selectMarketDepthWidgetButton;

    @FindBy(css = "[class='icon-icon-ticket-widget']")
    private WebElement selectTicketWidgetButton;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//i[contains(@class,'icon-icon-amounts-panel')]")
    private WebElement amountSwitcher;

    @FindBy(xpath = "//div[contains(@class,'Watchlist')]//span[contains(@class,'Select-value-label')]")
    private List<WebElement> verificationAmountField;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//span[contains(@class,'trade-ticket-currency')]")
    private List<WebElement> instrumentsOnWatchlistWidget;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//span[contains(text(),'Delete instrument')]")
    private WebElement deleteInstrumentSpan;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@data-window-name='watchlist']//span[contains(@class,'style__custom-amount___djksx')]")
    private WebElement amountSpan;

    @Step("Verify watchlist widget is present")
    public WatchlistWidget verifyWatchlistWidgetPresent() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(watchlistWidgetHeader, 30, "Watchlists");
        return this;
    }

    @Step("Click watchlist widget header")
    public WatchlistWidget clickWatchlistWidgetHeader() {
        makeElementVisible(watchlistWidgetHeader);
        watchlistWidgetHeader.click();
        return this;
    }

    @Step("Click New watchlist")
    public WatchlistWidget clickNewWatchlist() {
        newWatchlistButton.click();
        return this;
    }

    @Step("Click Edit watchlist")
    public WatchlistWidget clickEditWatchlist() {
        editWatchlistButton.click();
        return this;
    }

    @Step("Click Delete watchlist")
    public WatchlistWidget clickDeleteWatchlist() {
        deleteWatchlistButton.click();
        return this;
    }

    @Step("Click Delete watchlist confirmation")
    public WatchlistWidget clickDeleteWatchlistConfirmation() {
        deleteWatchlistConfirmButton.click();
        return this;
    }

    @Step("Click first tab")
    public WatchlistWidget clickFirstTab() {
        makeElementVisible(watchlistTabList.get(0));
        watchlistTabList.get(0).click();
        return this;
    }

    @Step("Click first tab")
    public WatchlistWidget setAmountOnInstrument(String value) {
        scrollIntoView(selectAmountList.get(0));
        selectAmountList.get(0).sendKeys(value);
        return this;
    }

    @Step("Click Make an Order button")
    public WatchlistWidget clickMakeAnOrder() {
        makeElementVisible(makeAnOrderButtonList.get(0));
        scrollIntoView(makeAnOrderButtonList.get(0));
        makeAnOrderButtonList.get(0).click();
        return this;
    }

    @Step("Click Make an Order button")
    public WatchlistWidget clickMakeAnOrderOnLastInstrument() {
        scrollIntoView(makeAnOrderButtonList.get(makeAnOrderButtonList.size() - 1));
        makeAnOrderButtonList.get(makeAnOrderButtonList.size() - 1).click();
        return this;
    }

    @Step("Click instrument menu")
    public WatchlistWidget clickInstrumentMenu() {
        assertTrue(instrumentMenuButtons.size() > 0);
        scrollIntoView(instrumentMenuButtons.get(0));
        instrumentMenuButtons.get(0).click();
        return this;
    }

    @Step("Click to select Chart widget from menu")
    public WatchlistWidget clickChartWidget() {
        selectChartWidgetButton.click();
        return this;
    }

    @Step("Click to select Market depth widget from menu")
    public WatchlistWidget clickMarketDepthWidget() {
        selectMarketDepthWidgetButton.click();
        return this;
    }

    @Step("Click to select ticket widget from menu")
    public WatchlistWidget clickTicketWidget() {
        selectTicketWidgetButton.click();
        return this;
    }

    @Step("Click to switch on or switch off the amount")
    public WatchlistWidget clickAmountSwitcher() {
        FluentWaiting.waitUntillElementToBeClickable(60, 500, amountSwitcher);
        amountSwitcher.click();
        return this;
    }

    @Step("Click to list view")
    public WatchlistWidget clickListView() {
        listViewButton.click();
        return this;
    }

    @Step("Click to block view")
    public WatchlistWidget clickBlockView() {
        blockViewButton.click();
        return this;
    }

    @Step("Enter amount input")
    public WatchlistWidget enterAmountInput(String amount) {
        amountInput.sendKeys(amount);
        return this;
    }

    @Step("Verify amount input field is present on watchlist widget")
    public WatchlistWidget verifyAmoutInputFieldIsPresentOnWatchlistWidget() {
        assertTrue(amountInput.isDisplayed());
        return this;
    }

    @Step("Verify there is no amount field on watchlist widget")
    public WatchlistWidget verifyAmountInputFieldIsNotPresentOnWatchListWidget() {
        Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> amountInput.isDisplayed());
        return this;
    }

    @Step("Verify if there is not <<Make an order>> button present on watchlist widget")
    public WatchlistWidget verifyMakeAnOrderButtonsAreNotPresentOnWatchListWidget() throws Exception {
        Assert.assertEquals(makeAnOrderButtonList.size(), 0);
        return this;
    }

    @Step("Verify if <<Make an order>> button is present on watchlist widget")
    public WatchlistWidget verifyMakeAnOrderButtonsArePresentOnWatchListWidget() {
        Assert.assertNotEquals(makeAnOrderButtonList.size(), 0);
        return this;
    }

    @Step("Verify selection of placeholder amount field")
    public WatchlistWidget verifySelectAmount(String value) throws org.openqa.selenium.NoSuchElementException {
        Assert.assertEquals(verificationAmountField.get(0).getText(), value);
        return this;
    }

    @Step("Delete last instrument")
    public WatchlistWidget deleteLastInstrument() {
        assertTrue(instrumentMenuButtons.size() > 0);
        scrollIntoView(instrumentMenuButtons.get(instrumentMenuButtons.size() - 1));
        instrumentMenuButtons.get(instrumentMenuButtons.size() - 1).click();
        deleteInstrumentSpan.click();
        return this;
    }

    @Step("Verify amount span")
    public WatchlistWidget verifyAmountSpan(String amount) {
        scrollIntoView(amountSpan);
        String actualAmount = String.valueOf(amountSpan.getText().toCharArray(), 0, amount.length());
        Assert.assertEquals(amount, actualAmount);//Trading multiplier amount shows only at FX instrument category
        return this;
    }

    public String getInstrumentCategory(int index) {
        scrollIntoView(instrumentCategoryList.get(index));
        return instrumentCategoryList.get(index).getText();
    }

    @Step("Click watchlist close button")
    public WatchlistWidget clickCloseButton() {
        closeButton.click();
        return this;
    }

}
