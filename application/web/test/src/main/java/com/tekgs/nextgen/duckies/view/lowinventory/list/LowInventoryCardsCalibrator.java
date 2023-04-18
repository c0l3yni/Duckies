package com.tekgs.nextgen.duckies.view.lowinventory.list;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardCalibratable;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardCalibrator;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardExpected;

import java.util.List;

public class LowInventoryCardsCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Low Inventory list' region";


    private LowInventoryCardsCalibrator( LowInventoryCardsCalibratable expected, LowInventoryCardsCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        List<LowInventoryCardCalibratable> lowInventoryCardsExpected = expected.inLowInventoryCards();
        List<LowInventoryCardCalibratable> lowInventoryCardsActual = actual.inLowInventoryCards();
        addCalibrationsExpected(lowInventoryCardsExpected, lowInventoryCardsActual);
        addCalibrationsUnexpected(lowInventoryCardsActual);
    }

    public static LowInventoryCardsCalibrator getInstance(LowInventoryCardsCalibratable expected, LowInventoryCardsCalibratable actual) {
        return new LowInventoryCardsCalibrator(expected, actual);
    }
    private void addCalibrationsExpected(List<LowInventoryCardCalibratable> lowInventoryCardsExpected, List<LowInventoryCardCalibratable> lowInventoryCardActual) {
        for (LowInventoryCardCalibratable lowInventoryCardExpected : lowInventoryCardsExpected) {
            LowInventoryCardCalibratable lowInventoryCardFound = addCalibrationFound(lowInventoryCardExpected, lowInventoryCardActual);
            if (lowInventoryCardFound == null) {
                addChildCalibrator(LowInventoryCardCalibrator.getInstance(lowInventoryCardExpected, null));
            } else {
                lowInventoryCardActual.remove(lowInventoryCardFound);
            }
        }
    }
    private LowInventoryCardCalibratable addCalibrationFound(LowInventoryCardCalibratable lowInventoryCardExpected, List<LowInventoryCardCalibratable> lowInventoryCardsActual) {
        LowInventoryCardCalibratable lowInventoryCardFound = null;
        for (LowInventoryCardCalibratable lowInventoryCardActual : lowInventoryCardsActual) {
            if (lowInventoryCardActual.equivalent(lowInventoryCardExpected)) {
                lowInventoryCardFound = lowInventoryCardActual;
                addChildCalibrator(LowInventoryCardCalibrator.getInstance(lowInventoryCardExpected, lowInventoryCardFound));
                break;
            }
        }
        return lowInventoryCardFound;
    }
    private void addCalibrationsUnexpected(List<LowInventoryCardCalibratable> lowInventoryCardsActual) {
        for (LowInventoryCardCalibratable lowInventoryCardUnexpected : lowInventoryCardsActual) {
            addChildCalibrator(LowInventoryCardCalibrator.getInstance(null, lowInventoryCardUnexpected));
        }
    }
    @Override
    protected void executeVerifications() {

    }
}
