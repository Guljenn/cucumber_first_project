package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropDownHandler;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarFinderPage carvanaCarFinderPage;
    CarvanaHelpMeSearchPage carvanaHelpMeSearchPage;
    CarvanaSellTradePage carvanaSellTradePage;
    CarvanaAutoLoanCalculatorPage carvanaAutoLoanCalculatorPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaHelpMeSearchPage = new CarvanaHelpMeSearchPage();
        carvanaSellTradePage = new CarvanaSellTradePage();
        carvanaAutoLoanCalculatorPage = new CarvanaAutoLoanCalculatorPage();
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String link) {
        switch (link) {
            case "CAR FINDER":
                carvanaHomePage.carvanaHomePageMenuItems.get(2).click();
                break;
            case "SELL/TRADE":
                carvanaHomePage.carvanaHomePageMenuItems.get(1).click();
                break;
            default:
                throw new NotFoundException("The link is not defined properly in the feature file!!!");

        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        driver.getCurrentUrl();
        driver.getCurrentUrl();
        driver.getCurrentUrl();
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String headingText) {
        switch (headingText) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaCarFinderPage.carvanaCarFinderHeading1.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderPage.carvanaCarFinderHeading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaCarFinderPage.carvanaCarFinderHeading3.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderPage.carvanaCarFinderHeading3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMeSearchPage.headlineText.isDisplayed());
                Assert.assertEquals(headingText, carvanaHelpMeSearchPage.headlineText.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMeSearchPage.subHeadlineText.isDisplayed());
                Assert.assertEquals(headingText, carvanaHelpMeSearchPage.subHeadlineText.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue((carvanaSellTradePage.carvanaSellTradePageHeading1.isDisplayed()));
                Assert.assertEquals(headingText, carvanaSellTradePage.carvanaSellTradePageHeading1.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellTradePage.carvanaSellTradePageHeading2.isDisplayed());
                Assert.assertEquals(headingText, carvanaSellTradePage.carvanaSellTradePageHeading2.getText());
                break;
            default:
                throw new NotFoundException("The heading text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isDisplayed());
        carvanaCarFinderPage.tryCarFinderLink.click();

    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "VIN":
                Assert.assertTrue(carvanaSellTradePage.vinButton.isDisplayed());
                carvanaSellTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                Assert.assertTrue(carvanaSellTradePage.getMyOfferButton.isDisplayed());
                Assert.assertTrue(carvanaSellTradePage.getMyOfferButton.isEnabled());
                carvanaSellTradePage.getMyOfferButton.click();
                break;
            default:
                throw new NotFoundException("The button is not defined properly in the feature file!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellTradePage.vinInputBox.click();
        carvanaSellTradePage.vinInputBox.sendKeys(key);

    }

    @Then("User should see {string} text")
    public void userShouldSeeErrorText(String errorText) {
        Waiter.waitUntilTextToBePresentInElement(driver, 15, carvanaSellTradePage.errorVinMessage, "We couldn’t find that VIN. Please check your entry and try again.");
        Assert.assertTrue(carvanaSellTradePage.errorVinMessage.isDisplayed());
        Assert.assertEquals(errorText, carvanaSellTradePage.errorVinMessage.getText());
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String menuItem) {
        ActionsUtil.moveToElement(carvanaHomePage.financingMenuItem);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String text, String input) {
        carvanaAutoLoanCalculatorPage.vehiclePriceInputBox.sendKeys(input);

    }


    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String montlyPaymentText) {
        Assert.assertTrue(carvanaAutoLoanCalculatorPage.monthlyPaymentMessage.isDisplayed());
        Assert.assertEquals(montlyPaymentText, carvanaAutoLoanCalculatorPage.monthlyPaymentMessage.getText());
    }

    @When("user clicks on {string} and enters {string}")
    public void userClicksOnAndEnters(String inputBox, String text) {
        switch (inputBox) {
            case "Cost of Car I want":
                Assert.assertTrue(carvanaAutoLoanCalculatorPage.loanCalculatorFieldLabels.get(0).isDisplayed());
                Assert.assertEquals(inputBox, carvanaAutoLoanCalculatorPage.loanCalculatorFieldLabels.get(0).getText());
                carvanaAutoLoanCalculatorPage.vehiclePriceInputBox.click();
                carvanaAutoLoanCalculatorPage.vehiclePriceInputBox.sendKeys(text);
                Waiter.pause(2);
                break;
            case "What is Your Down Payment?":
                Assert.assertTrue(carvanaAutoLoanCalculatorPage.loanCalculatorFieldLabels.get(3).isDisplayed());
                Assert.assertEquals(inputBox, carvanaAutoLoanCalculatorPage.loanCalculatorFieldLabels.get(3).getText());
                carvanaAutoLoanCalculatorPage.downPaymentInputBox.click();
                carvanaAutoLoanCalculatorPage.downPaymentInputBox.sendKeys(text);

        }
    }

    @And("user clicks on {string} and selects {string}")
    public void userClicksOnAndSelects(String inputBox, String selects) {

        DropDownHandler.selectOptionByValue(carvanaAutoLoanCalculatorPage.creditScoreDropDown, "3");
        Waiter.pause(2);

    }

    @And("User clicks on {string} menu item")
    public void userClicksOnMenuItemLink(String link) {
        carvanaHomePage.autoLoanCalculatorMenuItem.click();
    }

    @And("user clicks on {string} and select {string}")
    public void userClicksOnAndSelect(String fieldBox, String dropDown) {
        carvanaAutoLoanCalculatorPage.loanTermDropDown.click();
        Waiter.pause(2);
        DropDownHandler.selectOptionByVisibleText(carvanaAutoLoanCalculatorPage.loanTermDropDown, "60 Months");
    }
}
