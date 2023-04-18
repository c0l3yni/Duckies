package com.tekgs.nextgen.duckies.view.products;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.PRODUCTS})
public class ProductsViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        ProductsViewExpected expected = ProductsViewExpected.getInstance();
        ProductsView actual = ProductsView.directNav();
        then(ProductsViewCalibrator.getInstance(expected, actual));
    }
}
