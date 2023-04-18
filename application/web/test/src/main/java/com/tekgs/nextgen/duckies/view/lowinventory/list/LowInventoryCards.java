package com.tekgs.nextgen.duckies.view.lowinventory.list;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCard;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCard;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;

import java.util.ArrayList;
import java.util.List;

public class LowInventoryCards extends UiRegion implements LowInventoryCardsCalibratable {
    private static final String DESCRIPTION ="'low-inventory' region" ;
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "low-inventory-cards" ;

    private LowInventoryCards(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static LowInventoryCards getInstance(UiElement parentElement) {
        return new LowInventoryCards(parentElement);
    }

    public List<LowInventoryCardCalibratable> inLowInventoryCards() {
        List<LowInventoryCardCalibratable> lowInventoryCards = new ArrayList<>();
        for (UiElement lowInventoryCardElement : getLowInventoryCardElements()) {
            lowInventoryCards.add(LowInventoryCard.getInstance(lowInventoryCardElement));
        }
        return lowInventoryCards;
    }

    private List<UiElement> getLowInventoryCardElements() {
        return UiElement.getList("low inventory card", UiLocatorType.CLASS, "low-inventory-card", this.getElement());

    }


}
