package demoqa;

import base.Common;
import demo_qa_pages.DemoQAElementsPage;
import org.testng.annotations.Test;

public class TestElements extends Common {

    @Test
    public void testDoubleClick() {
        DemoQAElementsPage buttons = new DemoQAElementsPage(driver);
        buttons.doubleClickButton();
    }
}
