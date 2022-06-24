package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class CarvanaHelpMeSearchPage {

    public CarvanaHelpMeSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[data-qa='heading-container']>div:nth-child(1)")
        public WebElement headlineText;

    @FindBy(css = "div[data-qa='heading-container']>div:nth-child(2)")
    public WebElement subHeadlineText;
}
