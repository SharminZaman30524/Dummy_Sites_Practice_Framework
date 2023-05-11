package demo_qa_pages;

import base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static demo_qa_webelements.DemoQAWebElements.*;

public class DemoQaInteractions extends Common {

    @FindBy(xpath = interactionsCardXpath)
    public WebElement interactionsCard;
    @FindBy(xpath = droppableSideBarXpath)
    public WebElement droppableSideBar;
    @FindBy(xpath = dragMeBoxXpath)
    public WebElement dragMeBoxSource;
    @FindBy(xpath = dropMeBoxXpath)
    public WebElement dropMeBoxTarget;
    @FindBy(xpath = droppedMessageXpath)
    public WebElement droppedMessage;


    public DemoQaInteractions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnInteractionsCard() {
        click(interactionsCard);
    }

    public void clickOnDroppable() {
        click(droppableSideBar);
    }

    public void dragBox() {
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMeBoxSource, dropMeBoxTarget).perform();
    }

    public void dragAndDrop() {
        clickOnInteractionsCard();
        clickOnDroppable();
        dragBox();
    }

    public String dragAndDropAssertion() {
        return droppedMessage.getText();
    }

    public boolean droppedSuccessfully() {
        if (droppedMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
