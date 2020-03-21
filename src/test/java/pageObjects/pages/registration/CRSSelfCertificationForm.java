package pageObjects.pages.registration;

import data.RegistrationInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CRSSelfCertificationForm extends IndividualVerificationBase {

    @FindBy(xpath = "//span[contains(text(),'Add another one')]")
    private WebElement addCountryLink;

    @FindBy(xpath = "//*[@class='Select-control']//input")
    private WebElement countryOfTaxResidence;

    @FindBy(xpath = "//input[@name='crsCountry[0].tin']")
    private WebElement crsCountry;

    @FindBy(xpath = "//label[input[@name='crsCountry[0].tinNotAvailable']]")
    private WebElement noTinCheckbox;

    @FindBy(xpath = "//label[input[@name='crsCountry[0].tinNotAvailableReason']]")
    private List<WebElement> noTINAvailableProvideReasonRadioGroup;

    @FindBy(xpath = "//input[@name='crsCountry[0].tinNotAvailableExplanation']")
    private List<WebElement> explanationUnableToObtainTIN;

    private WebElement getTINNotAvailableRadioOption(String partialReasonText, int countryIndex) {
        return getWebDriver().findElement(By.xpath(String.format("(//label[contains(.,'%s)])[%d]",
                partialReasonText, countryIndex + 1))); // xpath index starts with 1
    }

    @Step("Add new country")
    public CRSSelfCertificationForm clickAddCountry() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, addCountryLink);
        addCountryLink.click();
        return this;
    }

    @Step("Set country of issuance {0}")
    public CRSSelfCertificationForm selectCountry(String country) {
        scrollIntoView(countryOfTaxResidence);
        sleep(1000); //TODO remove this later
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, countryOfTaxResidence);
        countryOfTaxResidence.sendKeys(country + Keys.ENTER);
        return this;
    }

    @Step("Fill in TIN{0}")
    public CRSSelfCertificationForm enterTIN(String tin) {
        scrollIntoView(crsCountry);
        crsCountry.sendKeys(tin);
        return this;
    }

    @Step("Check No TIN is available checkbox{0}")
    public CRSSelfCertificationForm clickNoTINIsAvailable() {
        scrollIntoView(noTinCheckbox);
        noTinCheckbox.click();
        return this;
    }

    @Step("Select a reason: {0} if no TIN is available{0}")
    public CRSSelfCertificationForm selectReasonNoTINAvailable(String partialReasonText) {
        scrollIntoView(noTINAvailableProvideReasonRadioGroup.get(0));
        noTINAvailableProvideReasonRadioGroup.stream().filter(option -> option.getText().equalsIgnoreCase(partialReasonText)).
                findFirst().get().click();
        return this;
    }

    // Example in case we need to write test for adding several countries with parameterized selector
    @Step("Select a reason: {0} if no TIN is available for country index: {1}")
    public CRSSelfCertificationForm selectReasonNoTINAvailable(String partialReasonText, int countryIndex) {
        getTINNotAvailableRadioOption(partialReasonText, countryIndex).click();
        return this;
    }

    @Step("Enter explanation: {0} if no TIN is available")
    public CRSSelfCertificationForm enterExplanationIfNoTinAvailable(String explanation) {
        scrollIntoView(explanationUnableToObtainTIN.get(0));
        utils.FluentWaiting.waitUntillVisibilityOfElements(30, 500, explanationUnableToObtainTIN);
        explanationUnableToObtainTIN.get(0).sendKeys(explanation);
        return this;
    }

    // Example in case we need to write test for adding several countries with simple selector
    @Step("Enter explanation: {0} if no TIN is available for country: {1}")
    public CRSSelfCertificationForm enterExplanationIfNoTinAvailable(String explanation, int countyIndex) {
        utils.FluentWaiting.waitUntillVisibilityOfElements(30, 500, explanationUnableToObtainTIN);
        scrollIntoView(explanationUnableToObtainTIN.get(countyIndex));
        explanationUnableToObtainTIN.get(countyIndex).sendKeys(explanation);
        return this;
    }

    public CRSSelfCertificationForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.selectCountry(registrationInfo.getCountry())
                .enterTIN(registrationInfo.getTin());
        return this;
    }

    public CRSSelfCertificationForm fillInAllFieldsWithData(RegistrationInfo registrationInfo) {
        this.selectCountry(registrationInfo.getCountry())
                .clickNoTINIsAvailable()
                .selectReasonNoTINAvailable(registrationInfo.getTinNoAvailableReason())
                .enterExplanationIfNoTinAvailable(registrationInfo.getReason());
        return this;
    }

}
