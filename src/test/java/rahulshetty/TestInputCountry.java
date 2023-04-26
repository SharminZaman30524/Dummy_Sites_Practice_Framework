package rahulshetty;

import base.Common;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahul_shetty_pages.RahulShettyPracticePage;
import utility.ReadExcelFile;

public class TestInputCountry extends Common {

    @Test
    public void testInputCountry() throws InterruptedException {
        RahulShettyPracticePage practicePage = new RahulShettyPracticePage(driver);
        ReadExcelFile excelFile = new ReadExcelFile();
        String country = excelFile.getValueFromCell("RahulShettyCountries", 1,3);
        practicePage.clickInputCountry("Zimbabwe");
        practicePage.clickCountryOption();
        String expected = "Zimbabwe";
        String actual = practicePage.countryResult.getText();
        Assert.assertEquals(expected, actual);
        /*if (practicePage.countryDropdownOptions.isSelected()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);*/
        //}
    }
}
