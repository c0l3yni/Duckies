package com.tekgs.nextgen.duckies.view.lowinventory;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.view.DuckiesView;
import com.tekgs.nextgen.duckies.view.lowinventory.list.LowInventoryCards;
import com.tekgs.nextgen.duckies.view.lowinventory.list.LowInventoryCardsCalibratable;

public class LowInventoryView extends DuckiesView implements LowInventoryViewCalibratable {
    private static final String RELATIVE_URL = "low-inventory";
    private static final String LOCATOR_VALUE = "low-inventory";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Low Inventory' view";

    public LowInventoryView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static LowInventoryView directNav() {
        new LowInventoryView().load();
        return UiView.expect(LowInventoryView.class);
    }
    
    @Override
    public LowInventoryCardsCalibratable inLowInventoryCards() {
        return LowInventoryCards.getInstance(this.getElement());
    }
}
