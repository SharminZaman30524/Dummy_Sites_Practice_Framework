package uitesting;

import base.Common;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitesting_pages.UITestingTextInput;
import utility.ReadExcelFile;

public class TestInputButton extends Common {

    @Test
    public static void testInputButton() {
        UITestingTextInput testButton = new UITestingTextInput(driver);
        for (int row=0; row<=2;row++) {
        testButton.clickInputTextButton();
            ReadExcelFile excelFile = new ReadExcelFile();
            String name = excelFile.getValueFromCell("UITestingButton", row, 1);
            testButton.clickInputButton(name);
            testButton.clickButton();
        String expectedName = excelFile.getValueFromCell("UITestingButton", row, 1);;
        String actualName = testButton.button.getText();
        Assert.assertEquals(expectedName,actualName);
        }
    }
}
