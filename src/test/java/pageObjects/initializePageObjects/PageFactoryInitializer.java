/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.*;
import pageObjects.pages.registration.*;

/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */
public class PageFactoryInitializer extends BaseMethod {
    public StoneEdgeTradingLogin STELoginPage() {
        return PageFactory.initElements(getWebDriver(), StoneEdgeTradingLogin.class);
    }

    public StoneEdgeTradingDashboard STEDashboardPage() {
        return PageFactory.initElements(getWebDriver(), StoneEdgeTradingDashboard.class);
    }


    public StoneEdgeTradingSignup STESignupPage() {
        return PageFactory.initElements(getWebDriver(), StoneEdgeTradingSignup.class);
    }

    public OpenAccountForm OpenAccountForm() {
        return PageFactory.initElements(getWebDriver(),
                OpenAccountForm.class);
    }

    // Registration forms
    public OpeningAnAccountForm OpeningAnAccountForm() {
        return PageFactory.initElements(getWebDriver(), OpeningAnAccountForm.class);
    }

    public CustomerInfoForm CustomerInformationForm() {
        return PageFactory.initElements(getWebDriver(), CustomerInfoForm.class);
    }

    public CRSSelfCertificationForm CRSSelfCertificationForm() {
        return PageFactory.initElements(getWebDriver(), CRSSelfCertificationForm.class);
    }

    public FATCASelfCertificationForm FATCASelfCertificationForm() {
        return PageFactory.initElements(getWebDriver(), FATCASelfCertificationForm.class);
    }

    public EducationAndOccupationForm EducationAndOccupationForm() {
        return PageFactory.initElements(getWebDriver(), EducationAndOccupationForm.class);
    }

    public PoliticallyExposedPersonsForm PoliticallyExposedPersonsForm() {
        return PageFactory.initElements(getWebDriver(), PoliticallyExposedPersonsForm.class);
    }

    public InvestmentProfileForm InvestmentProfileForm() {
        return PageFactory.initElements(getWebDriver(), InvestmentProfileForm.class);
    }

    public FinancialStatusAndExperienceForm FinancialStatusAndExperienceForm() {
        return PageFactory.initElements(getWebDriver(), FinancialStatusAndExperienceForm.class);
    }

    public PaymentDetailsForm PaymentDetailsForm() {
        return PageFactory.initElements(getWebDriver(), PaymentDetailsForm.class);
    }

    public ExplicitDeclarationsAndDocumentsForm ExplicitDeclarationsAndDocumentsForm() {
        return PageFactory.initElements(getWebDriver(), ExplicitDeclarationsAndDocumentsForm.class);
    }

    public NewsPage NewsPage() {
        return PageFactory.initElements(getWebDriver(), NewsPage.class);
    }

    public NewsWidget NewsWidget() {
        return PageFactory.initElements(getWebDriver(), NewsWidget.class);
    }

    public ChartWidget ChartWidget() {
        return PageFactory.initElements(getWebDriver(), ChartWidget.class);
    }

    public MarketDepthWidget MarketDepthWidget() {
        return PageFactory.initElements(getWebDriver(), MarketDepthWidget.class);
    }

    public TicketWidget TicketWidget() {
        return PageFactory.initElements(getWebDriver(), TicketWidget.class);
    }

    public VerificationForm VerificationForm() {
        return PageFactory.initElements(getWebDriver(), VerificationForm.class);
    }

    public WatchlistWidget WatchlistWidget() {
        return PageFactory.initElements(getWebDriver(), WatchlistWidget.class);
    }

    public CreateUpdateWatchlistPopUp CreateUpdateWatchlistPopUp() {
        return PageFactory.initElements(getWebDriver(), CreateUpdateWatchlistPopUp.class);
    }

    public PositionsAndOrdersWidget PositionsAndOrdersWidget() {
        return PageFactory.initElements(getWebDriver(), PositionsAndOrdersWidget.class);
    }

    public AddWidgetPopUp AddWidgetPopUp() {
        return PageFactory.initElements(getWebDriver(), AddWidgetPopUp.class);
    }

    public ChangeInstrumentPopUp ChangeInstrumentPopUp() {
        return PageFactory.initElements(getWebDriver(), ChangeInstrumentPopUp.class);
    }

    public OrderTicketPopup OrderTicketPopup() {
        return PageFactory.initElements(getWebDriver(), OrderTicketPopup.class);
    }

    public EditOrderRequestPopUpWindow EditOrderRequestPopUpWindow() {
        return PageFactory.initElements(getWebDriver(), EditOrderRequestPopUpWindow.class);
    }

    public PositionsWidget PositionsWidget() {
        return PageFactory.initElements(getWebDriver(), PositionsWidget.class);
    }

    public OrdersWidget OrdersWidget() {
        return PageFactory.initElements(getWebDriver(), OrdersWidget.class);
    }

    public ResetPassword ResetPassword() {
        return PageFactory.initElements(getWebDriver(), ResetPassword.class);
    }

    public SettingsPage SettingsPage() {
        return PageFactory.initElements(getWebDriver(), SettingsPage.class);
    }

    public AccountStateWindow AccountStateWindow() {
        return PageFactory.initElements(getWebDriver(), AccountStateWindow.class);
    }

    public FundsWithdrawalWindow FundsWithdrawalWindow() {
        return PageFactory.initElements(getWebDriver(), FundsWithdrawalWindow.class);
    }

    public PaymentMethodsWindow PaymentMethodsWindow() {
        return PageFactory.initElements(getWebDriver(), PaymentMethodsWindow.class);
    }

    public ChatOrderRequestPopUpWindow ChatOrderRequestPopUpWindow() {
        return PageFactory.initElements(getWebDriver(), ChatOrderRequestPopUpWindow.class);
    }

    public TransactionsTab Transactions() {
        return PageFactory.initElements(getWebDriver(), TransactionsTab.class);
    }

    public HistoryOrders HistoryOrders() {
        return PageFactory.initElements(getWebDriver(), HistoryOrders.class);
    }

    public HistoryTrades HistoryTrades() {
        return PageFactory.initElements(getWebDriver(), HistoryTrades.class);
    }

    public HistoryNotifications HistoryNotifications() {
        return PageFactory.initElements(getWebDriver(), HistoryNotifications.class);
    }

    public DealerDeskAccounts DealerDeskAccounts() {
        return PageFactory.initElements(getWebDriver(), DealerDeskAccounts.class);
    }

    public DealerDeskOrders DealerDeskOrders() {
        return PageFactory.initElements(getWebDriver(), DealerDeskOrders.class);
    }
    public DealerDeskDashboard DealerDeskDashboard() {
        return PageFactory.initElements(getWebDriver(), DealerDeskDashboard.class);
    }
   public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
