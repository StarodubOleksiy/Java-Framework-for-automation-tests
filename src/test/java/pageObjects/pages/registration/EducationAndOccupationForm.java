package pageObjects.pages.registration;

import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EducationAndOccupationForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[contains(.,'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//label[contains(.,'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//label[input[@name='employmentStatus']]")
    private List<WebElement> employmentStatusRadioButton;

    @FindBy(xpath = "//input[@name='nameOfEmployer']")
    private WebElement nameOfEmployer;

    @FindBy(xpath = "//input[@name='occupation']")
    private WebElement occupation;

    @FindBy(xpath = "//label[contains(text(),'Less than highschool diploma')]")
    private WebElement lessThenHighSchoolDiplomaCheckBox;

    @FindBy(xpath = "//label[contains(text(),'High school or equivalent')]")
    private WebElement highSchoolOrEquivalentCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Bachelor's degree (BA, BSc)')]")
    private WebElement bachelorsDegreeCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Master's degree (MA, MSc, Med)')]")
    private WebElement mastersDegreeCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Professional degree (MBA)')]")
    private WebElement professionalDegreeCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Doctorate (PhD, EdD)')]")
    private WebElement doctorateCheckBox;

    @FindBy(xpath = "//label[input[@name='wealthSize']]")
    private List<WebElement> wealthSizeRadioButton;

    @FindBy(xpath = "//label[contains(text(),'Owner of business')]")
    private WebElement ownerOfBusinessCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Salary earning')]")
    private WebElement salaryEarningCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Investments')]")
    private WebElement investmentsCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Inheritance')]")
    private WebElement inheritanceCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Other')]")
    private WebElement otherCheckBox;

    @FindBy(xpath = "//textarea[@name='sourceOfFundOther']")
    private WebElement sourceOfFundOtherTextArea;

    @FindBy(xpath = "//label[input[@name='totalAnnualIncome']]")
    private List<WebElement> totalAnnualIncomeRadioButton;

    @Step("Specify all amounts in answers in (USD, EUR) {0}")
    public EducationAndOccupationForm specifyAllAmountsInAnswer_USDorEUR_LIST(String currencyType) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
        switch (currencyType) {
            case "EUR":
                currencyEUR.click();
                break;
            case "USD":
                currencyUSD.click();
                break;
        }
        return this;
    }

    @Step("Check of employment status {0}")
    public EducationAndOccupationForm checkingEmploymentStatus(String status) {
        scrollIntoView(employmentStatusRadioButton.get(0));
        employmentStatusRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter name of employer {0}")
    public EducationAndOccupationForm enterNameOfEmployer(String name) {
        nameOfEmployer.sendKeys(name);
        return this;
    }

    @Step("Enter occupation {0}")
    public EducationAndOccupationForm enterOccupation(String name) {
        occupation.sendKeys(name);
        return this;
    }

    @Step("Check level of education less than highschool diploma")
    public EducationAndOccupationForm lessThanHighSchoolDiploma() {
        scrollIntoView(lessThenHighSchoolDiplomaCheckBox);
        lessThenHighSchoolDiplomaCheckBox.click();
        return this;
    }

    @Step("Check level of education high school or equivalent")
    public EducationAndOccupationForm highSchoolOrEquivalent() {
        scrollIntoView(highSchoolOrEquivalentCheckBox);
        highSchoolOrEquivalentCheckBox.click();
        return this;
    }

    @Step("Check level of education Bachelor's degree (BA, BSc)")
    public EducationAndOccupationForm bachelorDegree() {
        scrollIntoView(bachelorsDegreeCheckBox);
        bachelorsDegreeCheckBox.click();
        return this;
    }

    @Step("Check level of education Master's degree (MA, MSc, Med)")
    public EducationAndOccupationForm mastersDegree() {
        scrollIntoView(mastersDegreeCheckBox);
        mastersDegreeCheckBox.click();
        return this;
    }

    @Step("Check level of education Professional degree (MBA)")
    public EducationAndOccupationForm professionalDegree() {
        scrollIntoView(professionalDegreeCheckBox);
        professionalDegreeCheckBox.click();
        return this;
    }

    @Step("Check level of education Doctorate (PhD, EdD)")
    public EducationAndOccupationForm doctorateDegree() {
        scrollIntoView(doctorateCheckBox);
        doctorateCheckBox.click();
        return this;
    }

    @Step("Check size of wealth (savings and brokerage accounts, financial assets, real estates) {0}")
    public EducationAndOccupationForm sizeOfWealth(String status) {
        scrollIntoView(wealthSizeRadioButton.get(0));
        wealthSizeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check Owner of business")
    public EducationAndOccupationForm ownerOfBusiness() {
        scrollIntoView(ownerOfBusinessCheckBox);
        ownerOfBusinessCheckBox.click();
        return this;
    }

    @Step("Check Salary earning")
    public EducationAndOccupationForm salaryEarning() {
        scrollIntoView(salaryEarningCheckBox);
        salaryEarningCheckBox.click();
        return this;
    }

    @Step("Check Investments")
    public EducationAndOccupationForm investments() {
        scrollIntoView(investmentsCheckBox);
        investmentsCheckBox.click();
        return this;
    }

    @Step("Check Inheritance")
    public EducationAndOccupationForm inheritance() {
        scrollIntoView(inheritanceCheckBox);
        inheritanceCheckBox.click();
        return this;
    }

    @Step("Check Other Source of funds and/or wealth")
    public EducationAndOccupationForm otherSource() {
        scrollIntoView(salaryEarningCheckBox);
        otherCheckBox.click();
        return this;
    }

    @Step("Enter Source of funds {0}")
    public EducationAndOccupationForm enterSourceOfFunds(String sourceOfFunds) {
        scrollIntoView(sourceOfFundOtherTextArea);
        sourceOfFundOtherTextArea.sendKeys(sourceOfFunds);
        return this;
    }

    @Step("Check Total annual income {0}")
    public EducationAndOccupationForm enterTotalAnnualIncome(String income) {
        scrollIntoView(totalAnnualIncomeRadioButton.get(0));
        totalAnnualIncomeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(income)).
                findFirst().get().click();
        return this;
    }

    public EducationAndOccupationForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.specifyAllAmountsInAnswer_USDorEUR_LIST(registrationInfo.getCurrency())
                .checkingEmploymentStatus(registrationInfo.getEmploymentStatus())
                .enterNameOfEmployer(registrationInfo.getNameOfEmployer())
                .enterOccupation(registrationInfo.getOccupation())
                .lessThanHighSchoolDiploma()
                .sizeOfWealth(registrationInfo.getWealth())
                .ownerOfBusiness()
                .enterSourceOfFunds(registrationInfo.getSentence())
                .enterTotalAnnualIncome(registrationInfo.getAnnualIncome());
        return this;
    }
}
