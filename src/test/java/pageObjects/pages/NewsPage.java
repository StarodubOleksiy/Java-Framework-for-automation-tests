package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

public class NewsPage extends PageFactoryInitializer {

    @FindBy(xpath = "//button[contains(text(),'Next page')]")
    private WebElement nextPage;

    @FindBy(xpath = "//button[contains(text(),'Previous page')]")
    private WebElement previousPage;


    @Step("To click on Next step button")
    public NewsPage clickNextPageButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, nextPage);
        nextPage.click();
        return this;
    }

    @Step("Validate if button previous page on Dashboard News")
    public NewsPage validateDashboardNewsPreviousPageButton() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(previousPage, 30, "Previous page");
        return this;
    }



}
