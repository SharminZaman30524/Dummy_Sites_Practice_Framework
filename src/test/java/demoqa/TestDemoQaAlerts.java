package demoqa;

import base.Common;
import demo_qa_pages.DemoQaAlerts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoQaAlerts extends Common {
    @Test(enabled = false)
    public void testTimerAlert() {
        DemoQaAlerts dqAlerts = new DemoQaAlerts(driver);
        dqAlerts.handleTimerAlert();
    }
    @Test
    public void testPromptBoxAlert() throws InterruptedException {
        DemoQaAlerts dqAlerts = new DemoQaAlerts(driver);
        dqAlerts.handlePromptAlert();
        String expected = "You entered Mehnaz";
        String actual = dqAlerts.promptTextSuccess();
        Assert.assertEquals(actual,expected);

    }
}
