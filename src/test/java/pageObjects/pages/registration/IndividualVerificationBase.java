package pageObjects.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Galyna Formus
 * @date Sep 24, 2018
 */
public class IndividualVerificationBase extends PageFactoryInitializer {

    @FindBy(xpath = "//button[contains(text(),'Next step')]")
    private WebElement nextStep;

    @FindBy(xpath = "//button[contains(text(),'Personal')]")
    private WebElement personalButton;

    @FindBy(partialLinkText = "Log out")
    private WebElement logOut;

    @FindBy(xpath = "//div[contains(@class,'error-text')]")
    private WebElement firstErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'error-text')]")
    private List<WebElement> errorMessages;

    @Step("To click on Next step button")
    public IndividualVerificationBase clickNextStepButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, nextStep);
        nextStep.click();
        sleep(3000);
        return this;
    }

    @Step("To click on Personal button")
    public IndividualVerificationBase clickPersonalButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, personalButton);
        personalButton.click();
        sleep(3000);
        return this;
    }

    @Step("To click on Log out link")
    public IndividualVerificationBase clickLogOutLink() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, nextStep);
        logOut.click();
        return this;
    }

    @Step("Validate error message {0}")
    public IndividualVerificationBase validateErrorMessage(String message) {
        Assert.assertEquals(errorMessages.get(0).getText(), message);
        return this;
    }

    @Step("Validate error messages {0}")
    public IndividualVerificationBase validateErrorMessagesArePresent(List<String> expectedErrorMessages) {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, firstErrorMessage);

        List<String> actualErrorMessages = new ArrayList<String>();
        for (WebElement error: errorMessages) {
            scrollIntoView(error);
            utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, error);
            actualErrorMessages.add(error.getText());
        }

        Assert.assertEquals(actualErrorMessages, expectedErrorMessages);
        return this;
    }
}
