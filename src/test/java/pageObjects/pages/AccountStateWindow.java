package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.List;

public class AccountStateWindow extends PageFactoryInitializer {

    @FindBy(xpath = "//b[contains(text(),'Account state')]")
    private WebElement windowTitle;

    @FindBy(xpath = "//div[contains(text(),'Revaluation')]")
    private WebElement rowRevaluation;

    @FindBy(xpath = "//div[contains(text(),'Cash balance')]")
    private WebElement rowCashBalance;

    @FindBy(xpath = "//div[contains(text(),'Assets')]")
    private WebElement rowAssets;

    @FindBy(xpath = "//div[contains(text(),'P&L')]")
    private WebElement rowPL;

    @FindBy(xpath = "//div[contains(text(),'Used margin')]")
    private WebElement rowUsedMargin;

    @FindBy(xpath = "//div[contains(text(),'Total assets')]")
    private WebElement rowTotalAsssets;

    @FindBy(xpath = "//div[contains(text(),'Free funds')]")
    private WebElement rowFreeFunds;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-AccountState-___style__container___2wNIu')]//span[contains(text(),'USD')]")
    private WebElement usdSpan;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-AccountState-___style__container___2wNIu')]//span[contains(text(),'EUR')]")
    private WebElement eurSpan;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-AccountState-___style__container___2wNIu')]//span[contains(text(),'RUB')]")
    private WebElement rubSpan;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-AccountState-___style__container___2wNIu')]//span[contains(text(),'GBP')]")
    private WebElement gbpSpan;

    @FindBy(xpath = "//span[contains(@class,'PaymentsPage-AccountState-___style__acc-currency')]")
    private List<WebElement> currencyList;

    @Step("Verifying fields on account state window")
    public AccountStateWindow verifyFieldsOnAccountStateWindow() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(windowTitle, 30, "Account state");
        scrollIntoView(rowRevaluation);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowRevaluation, 30, "Revaluation");
        scrollIntoView(rowCashBalance);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowCashBalance, 30, "Cash balance");
        scrollIntoView(rowAssets);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowAssets, 30, "Assets");
        scrollIntoView(rowPL);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowPL, 30, "P&L");
        scrollIntoView(rowUsedMargin);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowUsedMargin, 30, "Used margin");
        scrollIntoView(rowTotalAsssets);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowTotalAsssets, 30, "Total assets");
        scrollIntoView(rowFreeFunds);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(rowFreeFunds, 30, "Free funds");
        return this;
    }

    @Step("Click USD button")
    public AccountStateWindow clickUSDSpan() {
        scrollIntoView(usdSpan);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, usdSpan);
        usdSpan.click();
        return this;
    }

    @Step("Click EUR button")
    public AccountStateWindow clickEURSpan() {
        scrollIntoView(eurSpan);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, eurSpan);
        eurSpan.click();
        return this;
    }

    @Step("Click RUB button")
    public AccountStateWindow clickRUBSpan() {
        scrollIntoView(rubSpan);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, rubSpan);
        rubSpan.click();
        return this;
    }

    @Step("Click GBP button")
    public AccountStateWindow clickGBPSpan() {
        scrollIntoView(gbpSpan);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, gbpSpan);
        gbpSpan.click();
        return this;
    }

    @Step("Verify currency on account state window")
    public AccountStateWindow verifyCurrency(String currency) {
        sleep(1000);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(currencyList.get(0), 30, currency);
        return this;
    }

}
