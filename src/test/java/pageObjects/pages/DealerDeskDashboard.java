package pageObjects.pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.AllureAttachments;
import utils.Platform;

import java.util.List;
import java.util.stream.DoubleStream;

public class DealerDeskDashboard extends PageFactoryInitializer {

    @FindBy(xpath = "//span[contains(text(),'Accounts')]")
    private WebElement accountsLink;

    @FindBy(xpath = "(//div[contains(@class,'app-containers-Grid-___style__footer')]/div)[1]")
    private WebElement paginationDesc;

    @FindBy(xpath = "//div[contains(@class,'select__multi-value__label')]")
    private WebElement filter;

    @FindBy(xpath = "//button[contains(text(),'Save as a new board')]")
    private WebElement saveAsANewBoardButton;

    @FindBy(xpath = "//form[contains(@class,'Grid-containers-___style__form___3PtMv')]//button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBoardButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameOfBoardInput;

    @FindBy(xpath = "//span[contains(text(),'OK')]")
    private WebElement okButton;

    @FindBy(xpath = "//a[contains(@class,'Submenu-___style__top-button___3PYHq')]")
    List<WebElement> boards;

    @Step("Click on Accounts")
    public DealerDeskDashboard clickOnAccounts() {
        accountsLink.click();
        return this;
    }

    @Step("Get elements size")
    public int getSize() {
        String description = paginationDesc.getText();
        if (StringUtils.isNotEmpty(description)) {
            String[] array = description.split(" ");//Showing 1 to 20 of 24 entries
            String sizeStr = array[5];
            return sizeStr.matches("\\d+") ? Integer.parseInt(sizeStr) : 0;
        }

        return 0;
    }

    @Step("Click on <<Save as a new board>> button")
    public DealerDeskDashboard clickOnSaveAsANewBoardButton() {
        saveAsANewBoardButton.click();
        return this;
    }

    @Step("Click on <<Save>> button")
    public DealerDeskDashboard clickOnSaveButton() throws Exception {
        saveButton.click();
        return this;
    }

    @Step("Enter name of new board {0}")
    public DealerDeskDashboard enterNameOfNewBoard(String name) {
        nameOfBoardInput.sendKeys(name);
        return this;
    }

    @Step("Click on <<OK>> button")
    public DealerDeskDashboard clickOnOKButton() {
        okButton.click();
        return this;
    }

    @Step("Click on <<Save>> button to save board")
    public DealerDeskDashboard clickOnSaveBoardButton() {
        saveBoardButton.click();
        return this;
    }

    @Step("Delete board {0}")
    public DealerDeskDashboard deleteAllBoards() {
        final String xpath = "//span[contains(@class,'components-Submenu-___style__close-icon')]";
        boards.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        lst -> {
                            Collections.reverse(lst);
                            return lst.stream();
                        }
                )).forEach(element -> {
                    scrollIntoView(element);
                    element.click();
                    if (isElementPresent("//a[contains(text(),'" + element.getText() + "')]" + xpath)) {
                        WebElement cancelIcon = getWebDriver().findElement(By.xpath("//a[contains(text(),'" + element.getText() + "')]" + xpath));
                        cancelIcon.click();
                        clickOnOKButton();
                    } else return;
                }
        );
        return this;
    }


    @Step("Verify if new board is present {0}")
    public DealerDeskDashboard isBoardPresent(String name) {
        Assert.assertTrue(isElementPresent("//a[contains(text(),'" + name + "')]"));
        return this;
    }

    @Step("Verify if filter is present {0}")
    public DealerDeskDashboard isFilterPresent(String name) {
        Assert.assertTrue(isElementPresent("//div[contains(text(),'" + name + "')]"));
        return this;
    }

    @Step("Click on new board")
    public DealerDeskDashboard clickOnNewBoard(String name) {
        this.clickWebElementIfPresent("//a[contains(text(),'" + name + "')]");
        return this;
    }


    @Step("Verify if new board is not present {0}")
    public DealerDeskDashboard isBoardNotPresent(String name) {
        Assert.assertFalse(isElementPresent("//a[contains(text(),'" + name + "')]"));
        return this;
    }

    public String getFilterText() {
        return filter.getText();
    }


}
