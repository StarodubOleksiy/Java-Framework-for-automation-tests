package pageObjects.pages.registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.List;

public class VerificationForm extends IndividualVerificationBase {

    @FindBy(xpath = "//p[contains(text(),'Your account is on Verification')]")
    private WebElement verificationMessage;


    @Step("Validate error message {0}")
    public VerificationForm validateVerifyMessage(String message) {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(verificationMessage, 30, message);
        return this;
    }
}
