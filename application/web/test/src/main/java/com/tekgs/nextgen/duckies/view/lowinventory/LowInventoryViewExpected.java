package com.tekgs.nextgen.duckies.view.lowinventory;

import com.tekgs.nextgen.duckies.view.lowinventory.list.LowInventoryCardsCalibratable;
import com.tekgs.nextgen.duckies.view.lowinventory.list.LowInventoryCardsExpected;

public class LowInventoryViewExpected implements LowInventoryViewCalibratable {


    public static LowInventoryViewExpected getInstance() {
        return new LowInventoryViewExpected();
    }


    @Override
    public LowInventoryCardsCalibratable inLowInventoryCards() {
        return LowInventoryCardsExpected.getInstance();
    }
}
