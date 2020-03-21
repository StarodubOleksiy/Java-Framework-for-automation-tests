package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.FluentWaiting;

public class OrderTicketPopup extends PageFactoryInitializer {

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement orderAmountInput;

    @FindBy(xpath = "//input[@name='price']")
    private WebElement orderPriceInput;

    @FindBy(xpath = "//span[contains(text(),'Place buy  order')]")
    private WebElement buyOrderButton;

    @FindBy(xpath = "//span[contains(text(),'Place sell order')]")
    private WebElement sellOrderButton;



    @Step("Enter order ticket amount")
    public OrderTicketPopup enterAmount(String amount) {
        orderAmountInput.sendKeys(amount);
        return this;
    }

    @Step("Enter order ticket price")
    public OrderTicketPopup enterPrice(String price) {
        orderPriceInput.clear();
        orderPriceInput.sendKeys(price);
        return this;
    }

    @Step("To click on place buy order button")
    public OrderTicketPopup clickBuyOrderButton() throws InterruptedException {
        // scrollIntoView(buyOrderButton);
        //  makeElementVisible(buyOrderButton);
        //  Thread.sleep(1000);
        FluentWaiting.waitUntillElementToBeClickable(60, 500, buyOrderButton);
        buyOrderButton.click();
        return this;
    }

    @Step("To click on place sell order button")
    public OrderTicketPopup clickSellOrderButton() throws InterruptedException {
//        scrollIntoView(sellOrderButton);
//        makeElementVisible(sellOrderButton);
//        Thread.sleep(1000);
        FluentWaiting.waitUntillElementToBeClickable(60, 500, sellOrderButton);
        sellOrderButton.click();
        return this;
    }


}
