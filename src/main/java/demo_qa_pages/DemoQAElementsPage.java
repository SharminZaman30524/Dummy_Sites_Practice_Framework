package demo_qa_pages;
import static demo_qa_webelements.DemoQAWebElements.*;
import base.Common;
import demo_qa_webelements.DemoQAWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAElementsPage extends Common {
    @FindBy (xpath = elementsOptionXpath) public WebElement elementsOption;
    /*BUTTONS*/
    @FindBy (xpath = buttonsOptionXpath) public WebElement buttonsOption;
    @FindBy (xpath = doubleClickButtonXpath) public WebElement doubleClickButton;

    public DemoQAElementsPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void clickElementsOption() {
        click(elementsOption);
    }
    public void clickButtonsOptions() {
        click(buttonsOption);
    }
    public void doubleClickButton() {
        clickElementsOption();
        clickButtonsOptions();
        click(doubleClickButton);
        click(doubleClickButton);
    }


}
