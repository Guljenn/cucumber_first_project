package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaAutoLoanCalculatorPage {

    public CarvanaAutoLoanCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "span[class='loan-calculator-field-label']")
    public List<WebElement> loanCalculatorFieldLabels;

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement vehiclePriceInputBox;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropDown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermDropDown;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    @FindBy(css = "div[class='loan-calculator-display-value']")
    public WebElement monthlyPaymentMessage;
}
