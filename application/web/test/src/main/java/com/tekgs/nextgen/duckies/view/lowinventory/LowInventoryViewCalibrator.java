package com.tekgs.nextgen.duckies.view.lowinventory;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.lowinventory.list.LowInventoryCardsCalibrator;

public class LowInventoryViewCalibrator extends Calibrator{
    private static final String DESCRIPTION = "'Low Inventory' View";
    public LowInventoryViewCalibrator(LowInventoryViewCalibratable expected, LowInventoryViewCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(LowInventoryCardsCalibrator.getInstance(expected.inLowInventoryCards(), actual.inLowInventoryCards()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static LowInventoryViewCalibrator getInstance(LowInventoryViewCalibratable expected, LowInventoryViewCalibratable actual) {
        return new LowInventoryViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
