package com.tekgs.nextgen.duckies.view.invalidurl;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

public class InvalidUrlViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        InvalidUrlViewExpected expected = InvalidUrlViewExpected.getInstance();
        InvalidUrlView actual = InvalidUrlView.directNav();
        then(InvalidUrlViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void directNav(){
        InvalidUrlViewExpected expected = InvalidUrlViewExpected.getInstance();
        InvalidUrlView actual =InvalidUrlView.directNav();
        then(InvalidUrlViewCalibrator.getInstance(expected, actual));

    }
}
