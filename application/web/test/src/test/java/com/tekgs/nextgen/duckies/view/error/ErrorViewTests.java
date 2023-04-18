package com.tekgs.nextgen.duckies.view.error;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.ERROR})
public class ErrorViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("45 - Customer Experience Error Boundary");
        ErrorViewExpected expected = ErrorViewExpected.getInstance();
        ErrorView actual = ErrorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }


}
