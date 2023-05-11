package demoqa;

import base.Common;
import demo_qa_pages.DemoQaInteractions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoQaInteractions extends Common {
    @Test
    public void testDragAndDrop() throws InterruptedException {
        DemoQaInteractions dqInteraction = new DemoQaInteractions(driver);
        dqInteraction.dragAndDrop();
        String expected = "Dropped!";
        String actual = dqInteraction.dragAndDropAssertion();
        Assert.assertEquals(expected,actual);
    }
}
