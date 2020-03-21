package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DealerDeskAccounts extends PageFactoryInitializer {

    @FindBy(xpath = "//a[contains(text(),'Own')]")
    private WebElement ownTab;

    @FindBy(xpath = "//div[contains(text(),'Management type...')]")
    private WebElement managmentTypeList;

    @FindBy(xpath = "//div[contains(text(),'Current')]")
    private WebElement currentType;

    @FindBy(xpath = "//div[contains(text(),'Portfolio management')]")
    private WebElement portfolioManagementType;

    @FindBy(xpath = "//div[contains(text(),'Brokerage')]")
    private WebElement brokerageType;

    @FindBy(xpath = "//div[contains(text(),'Client brokerage')]")
    private WebElement clientBrokerageType;

    @FindBy(xpath = "//div[contains(text(),'Account type...')]")
    private WebElement accountTypeList;

    @FindBy(xpath = "//div[contains(text(),'Real')]")
    private WebElement realType;

    @FindBy(xpath = "//div[contains(text(),'Personal')]")
    private WebElement personalType;

    @FindBy(xpath = "//div[contains(text(),'Nominal')]")
    private WebElement nominalType;

    @FindBy(xpath = "//div[contains(text(),'Tariff...')]")
    private WebElement tariffTypeList;

    @FindBy(xpath = "//div[contains(text(),'Client profile...')]")
    private WebElement clientProfileList;

    @FindBy(xpath = "//div[contains(text(),'Retail')]")
    private WebElement retailType;

    @FindBy(xpath = "//div[contains(text(),'Professional')]")
    private WebElement professionalType;

    @FindBy(xpath = "//div[contains(text(),'Test')]")
    private WebElement testType;

    @FindBy(xpath = "//div[contains(@class,'react-select__multi-value__remove')]")
    private WebElement closeType;

    @FindBy(xpath = "//div[contains(text(),'Columns')]")
    private WebElement columnsSwitcher;

    @FindBy(xpath = "//button[contains(text(),'Apply changes')]")
    private WebElement applyChangesButton;

    @FindBy(xpath = "//label[@id='laccountingType']")
    private WebElement accountingTypeCheckbox;

    @FindBy(xpath = "//label[@id='lmanagementType']")
    private WebElement managementTypeCheckbox;

    @FindBy(xpath = "//div[contains(text(),'Balance')]")
    private WebElement balanceTypeCheckbox;

    @FindBy(xpath = "//div[contains(text(),'Contract')]")
    private WebElement contractTypeCheckbox;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Accounting type')]")
    private WebElement accountingTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Management type')]")
    private WebElement managementTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Current Balance')]")
    private WebElement currentBalanceColumn;

    @FindBy(xpath = "//button[contains(text(),'View')]")
    private List<WebElement> viewButtons;

    @FindBy(xpath = "//span[contains(text(),'Accounts')]")
    private WebElement accountsLink;

    @FindBy(xpath = "//span[contains(text(),'USD')]")
    private WebElement usdCurrency;

    @FindBy(xpath = "//span[contains(text(),'EUR')]")
    private WebElement eurCurrency;

    @FindBy(xpath = "//span[contains(text(),'RUB')]")
    private WebElement rubCurrency;

    @FindBy(xpath = "//span[contains(text(),'GBP')]")
    private WebElement gbpCurrency;

    @FindBy(xpath = "(//td[contains(@class,'Components-Table-___style__td')])[1]")
    private WebElement accountId;

    @FindBy(xpath = "(//tr[contains(@class,'Table-___style__tr___22nRy')]//td//span)[2]")
    private WebElement totalAssets;

    @FindBy(xpath = "//i[@class='icon-icon-settings-desktop']")
    private WebElement settingButton;

    @FindBy(xpath = "//i[@class='icon-icon-switch-account']")
    private WebElement changeAccountButton;

    @FindBy(xpath = "//i[@class='icon-icon-notifications-desktop']")
    private WebElement notificationButton;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement okButton;

    @FindBy(xpath = "//div[contains(@class,'NotificationsCenter-___style__small-text___3JDZH')]")
    private WebElement notificationDate;

    @FindBy(xpath = "//p[contains(@class,'WithSelectedMember-___style__label')]")
    private WebElement firstLastName;

    @Step("Click on management type list")
    public DealerDeskAccounts clickManagmentTypeList() {
        managmentTypeList.click();
        return this;
    }

    @Step("Click on <<Current>> type")
    public DealerDeskAccounts clickOnCurrentType() {
        currentType.click();
        return this;
    }

    @Step("Click on <<Portfolio management>> type")
    public DealerDeskAccounts clickOnPortfolioManagementType() {
        portfolioManagementType.click();
        return this;
    }

    @Step("Click on <<Brokerage>> type")
    public DealerDeskAccounts clickOnBrokerageType() {
        currentType.click();
        return this;
    }

    @Step("Click on account type list")
    public DealerDeskAccounts clickAccountTypeList() {
        accountTypeList.click();
        return this;
    }

    @Step("Click on <<Real>> type")
    public DealerDeskAccounts clickOnRealType() {
        realType.click();
        return this;
    }

    @Step("Click on <<Personal>> type")
    public DealerDeskAccounts clickOnPersonalType() {
        personalType.click();
        return this;
    }

    @Step("Click on <<Nominal>> type")
    public DealerDeskAccounts clickOnNominalType() {
        nominalType.click();
        return this;
    }

    @Step("Click on <<Client brokerage>> type")
    public DealerDeskAccounts clickOnClientBrokerageType() {
        portfolioManagementType.click();
        return this;
    }

    @Step("Click on tariff type list")
    public DealerDeskAccounts clickTariffTypeList() {
        tariffTypeList.click();
        return this;
    }

    @Step("Click on client profile list")
    public DealerDeskAccounts clickClientProfileTypeList() {
        clientProfileList.click();
        return this;
    }

    @Step("Click on <<Retail>> type")
    public DealerDeskAccounts clickOnRetailType() {
        retailType.click();
        return this;
    }

    @Step("Click on <<Professional>> type")
    public DealerDeskAccounts clickOnProfessionalType() {
        professionalType.click();
        return this;
    }

    @Step("Click on <<Test>> type")
    public DealerDeskAccounts clickOnTestType() {
        testType.click();
        return this;
    }

    @Step("Click to close current type")
    public DealerDeskAccounts clickCloseType() {
        closeType.click();
        return this;
    }

    @Step("Click on <<Apply changes>> button")
    public DealerDeskAccounts clickOnApplyChangesButton() {
        applyChangesButton.click();
        return this;
    }

    @Step("verify column switcher on delearDesk")
    public DealerDeskAccounts verifyColumnSwitcher() {
        String[] configurableHeaders = {"Accounting type", "Management type", "Current Balance"};
        columnsSwitcher.click();
        accountingTypeCheckbox.click();
        managementTypeCheckbox.click();
        balanceTypeCheckbox.click();
        contractTypeCheckbox.click();
        applyChangesButton.click();
        for (String header : configurableHeaders) {
            Assert.assertFalse(isElementPresent(String.format("div[contains(@class,'SortArrows-___style__label')][contains(text(),'%s')]", header)));
        }
        columnsSwitcher.click();
        accountingTypeCheckbox.click();
        managementTypeCheckbox.click();
        balanceTypeCheckbox.click();
        contractTypeCheckbox.click();
        applyChangesButton.click();
        scrollIntoView(accountingTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Accounting type')]"));
        scrollIntoView(managementTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Management type')]"));
        scrollIntoView(currentBalanceColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Current Balance')]"));
        return this;
    }

    @Step("Click on <<View>> button")
    public DealerDeskAccounts clickOnViewButton() {
        viewButtons.get(0).click();
        return this;
    }

    @Step("Click on <<Accounts>> link")
    public DealerDeskAccounts clickOnAccountsLink() {
        accountsLink.click();
        return this;
    }

    @Step("Click on <<Own>> tab")
    public DealerDeskAccounts clickOnOwnTab() {
        ownTab.click();
        return this;
    }

    @Step("Click on <<USD>> currency")
    public DealerDeskAccounts clickUSDCurrency() {
        usdCurrency.click();
        return this;
    }

    @Step("Click on <<EUR>> currency")
    public DealerDeskAccounts clickEURCurrency() {
        eurCurrency.click();
        return this;
    }

    @Step("Click on <<RUB>> currency")
    public DealerDeskAccounts clickRUBCurrency() {
        rubCurrency.click();
        return this;
    }

    @Step("Click on <<GBP>> currency")
    public DealerDeskAccounts clickGBPCurrency() {
        gbpCurrency.click();
        return this;
    }

    @Step("Click on setting button")
    public DealerDeskAccounts clickSettingButton() {
        settingButton.click();
        return this;
    }

    @Step("Click on change account button")
    public DealerDeskAccounts clickChangeAccountButton() {
        changeAccountButton.click();
        return this;
    }

    @Step("Click on notification button")
    public DealerDeskAccounts clickNotificationButton() {
        notificationButton.click();
        return this;
    }

    @Step("Click on <<Log out>> button")
    public DealerDeskAccounts clickLogOutButton() {
        logOutButton.click();
        return this;
    }

    @Step("Click on <<Ok>> button")
    public DealerDeskAccounts clickOKButton() {
        okButton.click();
        return this;
    }

    @Step("Verify notification date")
    public DealerDeskAccounts verifyNotificationDate(String date) {
        Assert.assertEquals(notificationDate.getText(), date);
        return this;
    }

    public String getAccountId() {
        return accountId.getText();
    }

    public String getTotalAssert() {
        return totalAssets.getText();
    }

    public String getFirstLastName() {
        return firstLastName.getText();
    }

    @Step("Click on account")
    public DealerDeskAccounts clickOnAccount(String name) {
        this.clickWebElementIfPresent("//span[contains(text(),'" + name + "')]");
        return this;
    }

}
