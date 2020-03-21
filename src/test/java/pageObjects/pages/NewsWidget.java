package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

import java.util.List;

public class NewsWidget extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@data-window-name='news']//div[contains(text(),'News')]")
    private WebElement newsWidgetHeader;

    @FindBy(xpath = "//div[contains(@class,'app-components-News-___style__news-list-group-header___2eITZ')]")
    private WebElement todayDate;

    @FindBy(xpath = "//div[contains(@class,'app-components-News-___style__news-list-item-header-text___2nVHo')]")
    private List<WebElement> newsList;

    @FindBy(xpath = "//div[contains(@class,'app-components-News-___style__news-full-header___wuvLI')]")
    private WebElement article;

    @FindBy(xpath = "//span[contains(text(),'Back to news list')]")
    private WebElement backToNewsListButton;

    @FindBy(xpath = "//div[@data-window-name='news']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;

    @Step("Verify if news widget is present")
    public NewsWidget verifyNewsWidgetPresent() {
        sleep(2000);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(newsWidgetHeader, 30, "News");
        return this;
    }

    @Step("Verify if content of news widget is present")
    public NewsWidget clickNewsListItem() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, newsList.get(0));
        newsList.get(0).click();
        return this;
    }

    @Step("Verify if date news is present")
    public NewsWidget verifyPresentDate(String date) {
        Assert.assertEquals(todayDate.getText(), date);
        return this;
    }

    @Step("Verify if news content is real")
    public NewsWidget verifyArticleContent() {
        String newsListItem = newsList.get(0).getText().toLowerCase();
        String articleText = article.getText().toLowerCase();

        Assert.assertTrue(newsListItem.contains(articleText));
        return this;
    }

    @Step("Test navigation on news widget")
    public NewsWidget clickBackToNewsListButton() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, backToNewsListButton);
        backToNewsListButton.click();
        return this;
    }

    @Step("Verify if content of news widget is visible")
    public NewsWidget verifyIfNewsListVisible() {
        Assert.assertEquals(newsList.get(0).isDisplayed(), true);
        return this;
    }

    @Step("Click news close button")
    public NewsWidget clickCloseButton() {
        closeButton.click();
        return this;
    }

    @Step("Verify if date is present on widget")
    public boolean isDatePresent() {
        return this.isElementPresent("//div[contains(@class,'app-components-News-___style__news-list-group-header___2eITZ')]");
    }

}
