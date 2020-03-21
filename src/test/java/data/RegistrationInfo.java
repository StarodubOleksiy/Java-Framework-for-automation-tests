package data;

import com.github.javafaker.Faker;

import java.io.File;

public class RegistrationInfo {
    private Faker faker;

    private String currency;
    private String sentence;
    private String yesAnswer;
    private String noAnswer;
    private String invalidNumber;

    //Open account
    private String validSmsCode; //TODO extract
    private String phoneNumber;
    private String firstName;
    private String lastName;

    //CRS self-certification
    private String fullName;
    private String emailAddress;
    private String password;
    private String dateOfBirth;
    private String placeOfBirth;
    private String nationality;
    private String passportNumber;
    private String country;
    private String passportIssueDate;
    private String passportExpiryDate;
    private String homeAddress;
    private String preferredCommunication;
    private String purposeForRequesting;
    private String expiryDate;
    private String proofOfIdentity;
    private String proofOfResidency;
    private String proofOfAffiliation;
    private String tin;
    private String reason;
    //Education and occupation
    private String employmentStatus;
    private String nameOfEmployer;
    private String occupation;
    private String wealth;
    private String annualIncome;
    private String swift;
    private String company;
    private String knowledge;
    private String averageAmount;
    private String duration;
    private String stringNumber;
    private String tinNoAvailableReason;
    private String state;
    private String street;
    private String province;
    private String position;
    private String oneCharacterName;
    private String fiveDigitNumber;
    private String nineDigitNumber;
    private String tenDigitNumber;
    //Politically exposed persons

    //Investment profile
    private String frequencyOfProspectiveFinancialTransaction;
    private String intendedToInvestAmount;
    private String anticipatedAccountTurnover;
    private String levelOfRiskWillingToTake;

    //Payment method
    private String usdPaymentMethod;
    private String eurPaymentMethod;
    private String rubPaymentMethod;
    private String gbpPaymentMethod;


    public RegistrationInfo() {
        File testFile = new File("src/test/resources/test.txt");
        String country = "United States of America";

        faker = new Faker();
        this.validSmsCode = "123";
        this.phoneNumber = "3809" + faker.number().numberBetween(10000000, 99999999);

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.fullName = faker.name().fullName();

        this.emailAddress = faker.internet().emailAddress();
        this.password = faker.internet().password(6, 10);

        this.dateOfBirth = "n/a";
        this.placeOfBirth = country;
        this.country = country;
        this.nationality = this.country;
        this.passportNumber = faker.number().digits(8);
        this.passportIssueDate = "n/a";
        this.passportExpiryDate = "n/a";
        this.homeAddress = faker.address().fullAddress();
        this.preferredCommunication = "Email";
        this.purposeForRequesting = faker.lorem().sentence();
        this.expiryDate = "n/a";
        this.proofOfIdentity = testFile.getAbsolutePath();
        this.proofOfResidency = testFile.getAbsolutePath();
        this.proofOfAffiliation = testFile.getAbsolutePath();
        this.tin = faker.number().digits(9);
        this.tin = faker.number().digits(9);
        this.yesAnswer = "Yes";
        this.noAnswer = "No";
        this.currency = "USD";
        this.employmentStatus = "Employed";
        this.nameOfEmployer = faker.name().fullName();
        this.occupation = "engineer";
        this.wealth = "Less than $50,000";
        this.sentence = faker.lorem().sentence();
        this.annualIncome = "Less than $20,000";
        this.frequencyOfProspectiveFinancialTransaction = "Regular";
        this.intendedToInvestAmount = "Less than $50,000";
        this.anticipatedAccountTurnover = "Less than $10,000";
        this.levelOfRiskWillingToTake = "Slight fluctuations in value (from a current perspective: up to 10% p.a., stronger fluctuations are possible).";
        this.swift = "CTBAAU2S";
        this.company = faker.company().name();
        this.knowledge = "Academic studies";
        this.averageAmount = "Below $20,000";
        this.duration = "1 year or less";
        this.stringNumber = faker.numerify("1023");
        this.invalidNumber = "abc";
        this.reason = faker.lorem().sentence();
        this.tinNoAvailableReason = "The Account Holder is otherwise unable to obtain a TIN or equivalent number.";
        this.state = faker.address().state();
        this.street = faker.address().streetName();
        this.province = faker.address().streetAddress();
        this.position = faker.job().position();
        this.oneCharacterName = "c";
        this.fiveDigitNumber = "12345";
        this.nineDigitNumber = "123456789";
        this.tenDigitNumber = "1234567890";
        this.usdPaymentMethod = "Adams-Adams";
        this.eurPaymentMethod = "Gleason and Sons";
        this.rubPaymentMethod = "Hudson Inc";
        this.gbpPaymentMethod = "Ondricka-Ondricka";
    }


    public String getValidSmsCode() {
        return validSmsCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public String getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPreferredCommunication() {
        return preferredCommunication;
    }

    public String getPurposeForRequesting() {
        return purposeForRequesting;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getProofOfIdentity() {
        return proofOfIdentity;
    }

    public String getProofOfResidency() {
        return proofOfResidency;
    }

    public String getTin() {
        return tin;
    }

    public String getCurrency() {
        return currency;
    }

    public String getYesAnswer() {
        return yesAnswer;
    }

    public String getNoAnswer() {
        return noAnswer;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public String getNameOfEmployer() {
        return nameOfEmployer;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getWealth() {
        return wealth;
    }

    public String getSentence() {
        return sentence;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public String getFrequencyOfProspectiveFinancialTransaction() {
        return frequencyOfProspectiveFinancialTransaction;
    }

    public String getIntendedToInvestAmount() {
        return intendedToInvestAmount;
    }

    public String getAnticipatedAccountTurnover() {
        return anticipatedAccountTurnover;
    }

    public String getLevelOfRiskWillingToTake() {
        return levelOfRiskWillingToTake;
    }

    public String getProofOfAffiliation() {
        return proofOfAffiliation;
    }

    public String getSwift() {
        return swift;
    }

    public String getCompany() {
        return company;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public String getAverageAmount() {
        return averageAmount;
    }

    public String getDuration() {
        return duration;
    }

    public String getStringNumber() {
        return stringNumber;
    }

    public String getReason() {
        return reason;
    }

    public String getTinNoAvailableReason() {
        return tinNoAvailableReason;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getProvince() {
        return province;
    }

    public String getPosition() {
        return position;
    }

    public String getInvalidNumber() {
        return invalidNumber;
    }

    public String getOneCharacterName() {
        return oneCharacterName;
    }

    public String getFiveDigitNumber() {
        return fiveDigitNumber;
    }

    public String getNineDigitNumber() {
        return nineDigitNumber;
    }

    public String getTenDigitNumber() {
        return tenDigitNumber;
    }

    public String getUsdPaymentMethod() {
        return usdPaymentMethod;
    }

    public String getEurPaymentMethod() {
        return eurPaymentMethod;
    }

    public String getRubPaymentMethod() {
        return rubPaymentMethod;
    }

    public String getGbpPaymentMethod() { return gbpPaymentMethod; }
}
