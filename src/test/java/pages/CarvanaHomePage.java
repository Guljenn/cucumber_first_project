package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;


public class CarvanaHomePage {

    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "div[data-qa='header-items']>a")
    public List<WebElement> carvanaHomePageMenuItems;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']")
    public WebElement financingMenuItem;

//    @FindBy(css = "div[class*='HeaderFinancing__S']>a")
//    public List<WebElement> financingDropDownMenuItems;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanCalculatorMenuItem;



}
