package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaSellTradePage {

    public CarvanaSellTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class*='sc-4ef54ea5-4 sc-4ef54ea5-6']")
    public WebElement carvanaSellTradePageHeading1;

    @FindBy(css = "div[class*='sc-4ef54ea5-16 sc-4ef54ea5-17']")
    public WebElement carvanaSellTradePageHeading2;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = "input[type='text']")
    public WebElement vinInputBox;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(css = "div[class*='sc-ckTRkR sc-fXazxj sc-f']")
    public WebElement errorVinMessage;

}
