package tests.settings;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.LoggedUserData.*;

public class AppearanceTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone2, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickAppearanceTab();
    }

    @TestCaseId("TC_Theme_001")
    @Description("Test  verify theme switch successful flow")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void switchAppearance() throws Exception {
        SettingsPage()
                .clickLightSpan()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCssColor("rgba(119, 119, 119, 1)")
                .clickSettingButton();
        SettingsPage()
                .clickAppearanceTab()
                .clickDarkSpan()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCssColor("rgba(0, 0, 0, 1)");
    }


}
