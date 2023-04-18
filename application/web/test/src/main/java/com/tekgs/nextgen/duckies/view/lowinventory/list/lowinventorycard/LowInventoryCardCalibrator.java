package com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LowInventoryCardCalibrator extends Calibrator{
    private static final String DESCRIPTION = "'Low Inventory Card' region";
    private final LowInventoryCardCalibratable expected;
    private final LowInventoryCardCalibratable actual;

    private LowInventoryCardCalibrator(LowInventoryCardCalibratable expected, LowInventoryCardCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual =actual;
    }

    public static LowInventoryCardCalibrator getInstance(LowInventoryCardCalibratable expected, LowInventoryCardCalibratable actual) {
        return new LowInventoryCardCalibrator(expected, actual);
    }


    @Override
    protected void executeVerifications() {
        verify("id", expected.getId(), actual.getId());
        verify("product name", expected.getProductName(), actual.getProductName());
        verify("inventory", expected.getInventory(), actual.getInventory());
    }
}
