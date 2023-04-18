package com.tekgs.nextgen.duckies.view.lowinverntoryreport;

import com.tekgs.nextgen.duckies.view.lowinventory.LowInventoryView;
import com.tekgs.nextgen.duckies.view.lowinventory.LowInventoryViewCalibrator;
import com.tekgs.nextgen.duckies.view.lowinventory.LowInventoryViewExpected;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

    @Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.LOWINVENTORYREPORT})
    public class LowInventoryViewTests extends GauntletTest {
        @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE, TestSuite.DEBUG})
        public void smoke() {

            LowInventoryViewExpected expected = LowInventoryViewExpected.getInstance();
            LowInventoryView actual = LowInventoryView.directNav();
            then(LowInventoryViewCalibrator.getInstance(expected, actual));
        }
}
