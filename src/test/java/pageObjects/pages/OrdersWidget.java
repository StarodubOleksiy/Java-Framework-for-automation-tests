package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class OrdersWidget extends PageFactoryInitializer {

    @FindBy(xpath = "(//div[@data-window-name='positions'])[2]")
    private WebElement positionsHeader;

    @FindBy(xpath = "//div[@data-window-name='orders']")
    private WebElement ordersHeader;

    @FindBy(xpath = "//div[contains(text(),'Instrument')]")
    private WebElement instrumentColumn;

    @FindBy(xpath = "//div[contains(text(),'Amount')]")
    private WebElement amountColumn;

    @FindBy(xpath = "//div[contains(text(),'Date')]")
    private WebElement dateColumn;

    @FindBy(xpath = "//div[contains(text(),'Price')]")
    private WebElement priceColumn;

    @FindBy(xpath = "//div[contains(text(),'Total')]")
    private WebElement totalColumn;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__row___ugA4V')]//div[contains(@class,'Positions-___style__instrument___aRFkQ')]")
    private List<WebElement> instrumentNames;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__row___ugA4V')]//button[contains(text(),'Chat')]")
    private List<WebElement> chatButtons;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__row___ugA4V')]//button[contains(text(),'Edit')]")
    private List<WebElement> editButtons;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__row___ugA4V')]//button[contains(text(),'Cancel')]")
    private List<WebElement> cancelButtons;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'Positions-___style__row___ugA4V')]")
    private List<WebElement> orders;

    @Step("Click Positions and Order header")
    public OrdersWidget clickHeader() {
        sleep(1000);
        makeElementVisible(positionsHeader);
        scrollIntoView(positionsHeader);
        positionsHeader.click();
        return this;
    }

    @Step("Click on orders header")
    public OrdersWidget clickOnOrdersHeader() {
        scrollIntoView(ordersHeader);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, ordersHeader);
        ordersHeader.click();
        return this;
    }

    @Step("Verify orders widget is present")
    public OrdersWidget verifyOrdersWidgetTitleIsPresent() {
        Assert.assertEquals(ordersHeader.getText(), "Orders");
        return this;
    }

    @Step("Verify orders widget is present")
    public OrdersWidget verifyOrdersWidgetIsPresent() {
        assertTrue(editButtons.size() > 0, "No order requests present!");
        scrollIntoView(instrumentColumn);
        Assert.assertEquals(instrumentColumn.getText(), "Instrument");
        scrollIntoView(dateColumn);
        Assert.assertEquals(dateColumn.getText(), "Date");
        scrollIntoView(amountColumn);
        Assert.assertEquals(amountColumn.getText(), "Amount");
        scrollIntoView(priceColumn);
        Assert.assertEquals(priceColumn.getText(), "Price");
        scrollIntoView(editButtons.get(0));
        Assert.assertEquals(editButtons.get(0).getText(), "Edit");
        scrollIntoView(cancelButtons.get(0));
        Assert.assertEquals(cancelButtons.get(0).getText(), "Cancel");
        return this;
    }

    @Step("Click on edit button")
    public OrdersWidget clickOnEditButton() {
        assertTrue(editButtons.size() > 0, "No order requests present!");
        scrollIntoView(editButtons.get(0));
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, editButtons.get(0));
        editButtons.get(0).click();
        return this;
    }

    @Step("Click on specific edit button found by index ")
    public OrdersWidget clickOnEditButton(int index) {
        assertTrue(editButtons.size() > 0, "No order requests present!");
        scrollIntoView(editButtons.get(index));
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, editButtons.get(index));
        editButtons.get(index).click();
        return this;
    }

    @Step("Click on cancel button")
    public OrdersWidget clickOnCancelButton() {
        assertTrue(cancelButtons.size() > 0, "No order requests present!");
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, cancelButtons.get(0));
        cancelButtons.get(0).click();
        return this;
    }

    @Step("Click cancel on latest order request")
    public OrdersWidget clickCancelOnLatestOrderRequest() {
        assertTrue(cancelButtons.size() > 0, "No order requests present!");
        scrollIntoView(cancelButtons.get(0));
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, cancelButtons.get(cancelButtons.size() - 1));
        cancelButtons.get(cancelButtons.size() - 1).click();
        return this;
    }

    @Step("Verify new position")
    public OrdersWidget verifyNewPosition(String instrumentName) {
        WebElement instrumentOrder = getWebDriver().findElement(By.xpath(String.format("//div[contains(@class,'app-pages-TradingPage-containers-Positions-___style__instrument')][contains(text(),'%s')]", instrumentName)));
        scrollIntoView(instrumentOrder);
        assertTrue(instrumentOrder.isDisplayed());
        return this;
    }

    @Step("Close all orders")
    public OrdersWidget closeAllOrders() {
        cancelButtons.forEach(item -> {
            scrollIntoView(item);
            item.click();
        });
        return this;
    }

    @Step("Click Edit button on instrument {0}")
    public OrdersWidget editCurrentOrder(String instrumentName) {
        scrollIntoView(instrumentNames.get(0));
        for (int i = 0; i < orders.size(); ++i) {
            scrollIntoView(orders.get(i));
            if (orders.get(i).getText().contains(instrumentName)) {
                scrollIntoView(editButtons.get(i - 1));
                editButtons.get(i - 1).click();
                break;
            }
        }
        return this;
    }

    @Step("Click chat button on instrument {0}")
    public OrdersWidget clickChatButton(String instrumentName) {
        scrollIntoView(instrumentNames.get(0));
        for (int i = 0; i < orders.size(); ++i) {
            scrollIntoView(orders.get(i));
            if (orders.get(i).getText().contains(instrumentName)) {
                scrollIntoView(chatButtons.get(i - 1));
                chatButtons.get(i - 1).click();
                break;
            }
        }
        return this;
    }

}
