package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class CreateUpdateWatchlistPopUp extends ChangeInstrumentPopUp { //TODO

    @FindBy(xpath = "//input[@name='name']")
    private WebElement watchlistName;

    @FindBy(xpath = "//span[@data-button-action='save-watchlist']")
    private WebElement createUpdateWatchlistButton;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Step("Enter watchlist name")
    public CreateUpdateWatchlistPopUp enterWatchlistName(String value) {
        sleep(1000);
        watchlistName.sendKeys(value);
        return this;
    }

    @Step("Click to create/update watchlist")
    public CreateUpdateWatchlistPopUp clickCreteUpdateWatchlistButton() {
        createUpdateWatchlistButton.click();
        return this;
    }

    @Step("Click to cancel watchlist creation")
    public CreateUpdateWatchlistPopUp clickCancelButton() {
        cancelButton.click();
        return this;
    }

}
