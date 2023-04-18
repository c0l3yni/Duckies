package com.tekgs.nextgen.duckies.view.products;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.products.list.ProductCardsCalibrator;

public class ProductsViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Products' view";

    public ProductsViewCalibrator(ProductsViewExpected expected, ProductsView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(ProductCardsCalibrator.getInstance(expected.inProductCards(), actual.inProductCards()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static ProductsViewCalibrator getInstance(ProductsViewExpected expected, ProductsView actual) {
        return new ProductsViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
