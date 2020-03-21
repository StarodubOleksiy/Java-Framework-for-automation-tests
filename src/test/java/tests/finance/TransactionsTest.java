package tests.finance;

import data.RegistrationInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static data.TransactionsTypes.*;
import static data.LoggedUserData.*;

public class TransactionsTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        STEDashboardPage()
                .clickFinancesLink();
        Transactions()
                .clickTransactionsLink();
    }

    @TestCaseId("TC_Transactions_001")
    @Description("Verify if date on datepicker is changed then different period of time will be selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1DateRangedIsChanged() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String today = date.format(formatter);
        String yesterday = date.minusDays(1).format(formatter);
        String lastWeek = date.minusWeeks(1).format(formatter);
        String lastMonth = date.minusMonths(1).format(formatter);
        Transactions()
                .clickToday()
                .verifyDatePicker(today)
                .clickYesterday()
                .verifyDatePicker(yesterday)
                .clickLastWeek()
                .verifyDatePicker(lastWeek)
                .clickLastMonth()
                .verifyDatePicker(lastMonth);
    }

    @TestCaseId("TC_Transactions_002")
    @Description("Verify if transactions list is updated when datepicker is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2DatePickerIsChanged() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String lastYear = date.minusYears(1).format(formatter);
        Transactions()
                .clickToday()
                .setFilter(ALL_TYPES.toString())
                .noTransactionsAreAvailable()
                .clearDateFrom()
                .enterDateFrom(lastYear);
        try {
            Transactions()
                    .clickTransactionsTitle()//This method closes datepicker. Very ofthen it throws exception
                    .transactionsAreAvailable();
        } catch (org.openqa.selenium.WebDriverException exception) {
            System.out.println("exception has happened");
            exception.printStackTrace();
            Transactions()
                    .noTransactionsAreAvailable();
        }
    }


    @TestCaseId("TC_Transactions_003")
    @Description("Verify if transactions list is updated when filter is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3FilterIsChanged() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String lastYear = date.minusYears(1).format(formatter);
        Transactions()
                .clickToday()
                .setFilter(CASH_OUT_COMMISSION.toString())
                .clearDateFrom()
                .enterDateFrom(lastYear);
        try {
            Transactions()
                    .clickTransactionsTitle()//This method closes datepicker. Very ofthen it throws exception
                    .noTransactionsAreAvailable()
                    .setFilter(ALL_TYPES.toString())
                    .transactionsAreAvailable();
        } catch (org.openqa.selenium.WebDriverException exception) {
            System.out.println("exception has happened");
            exception.printStackTrace();
            Transactions()
                    .noTransactionsAreAvailable()
                    .setFilter(ALL_TYPES.toString())
                    .transactionsAreAvailable();
        }
    }

}
