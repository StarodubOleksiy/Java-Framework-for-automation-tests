package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

public class PositionsAndOrdersWidget {

    @FindBy(xpath = "//div[contains(text(),'Positions')]")
    private WebElement positionsTitle;

    @FindBy(xpath = "//div[contains(text(),'Orders')]")
    private WebElement ordersTitle;

    @FindBy(xpath = "//div[@data-window-name='positions']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;

    @Step("Verify watchlist widget is present")
    public PositionsAndOrdersWidget verifyPositionsAndOrdersWidgetPresent() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(positionsTitle, 30, "Positions");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(ordersTitle, 30, "Orders");
        return this;
    }

    @Step("Click positions and orders close button")
    public PositionsAndOrdersWidget clickCloseButton() {
        closeButton.click();
        return this;
    }
}
