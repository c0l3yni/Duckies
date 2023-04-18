package com.tekgs.nextgen.duckies.data.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Product'";
    private final ProductCalibratable expected;
    private final ProductCalibratable actual;

    public ProductCalibrator(ProductCalibratable expected, ProductCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static Calibrator getInstance(ProductCalibratable expected, ProductCalibratable actual) {
        return new ProductCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Product' id ", this.expected.getId(), this.actual.getId());
        verify("'Product' name ", this.expected.getName(), this.actual.getName());
        verify("'Product' price ", this.expected.getPrice(), this.actual.getPrice());
    }
}
