package learn_sliders;

import base.Common;
import learn_sliders.com.Apartments;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRentCalculatorSlider extends Common {
    int monthlyIncome= 3000;
    int percentage = 50;


    @Test
    public void testRentCalculatorSlider() throws InterruptedException {
        Apartments apartments = new Apartments();
        apartments.clickMenu();
        apartments.clickRentalToolsMenuOption();
        apartments.clickRentalCalculatorLink();
        apartments.enterMonthlyIncomeInput(String.valueOf(monthlyIncome));
        apartments.setPercentage(String.valueOf(percentage));
        int expectedCalculation = (monthlyIncome*percentage)/100;
        int actualCalculation = Integer.parseInt(apartments.getRentBudget());
        Assert.assertEquals(expectedCalculation,actualCalculation);

        Thread.sleep(3000);
    }
}
