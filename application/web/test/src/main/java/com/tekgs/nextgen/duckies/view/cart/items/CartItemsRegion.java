package com.tekgs.nextgen.duckies.view.cart.items;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegion;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegion extends UiRegion implements CartItemsRegionCalibratable {
    private static final String DESCRIPTION = "'Items' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "items";

    private CartItemsRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static CartItemsRegion getInstance(UiElement parent) {
        return new CartItemsRegion(parent);
    }

    @Override
    public List<CartItemRegionCalibratable> getItems() {
        List<CartItemRegionCalibratable> items = new ArrayList<>();
        String description = CartItemRegion.DESCRIPTION;
        String locatorType = CartItemRegion.LOCATOR_TYPE;
        String locatorValue = CartItemRegion.LOCATOR_VALUE;
        for(UiElement itemElement:UiElement.getList(description, locatorType, locatorValue, this.getElement())){
            items.add(CartItemRegion.getInstance(itemElement));
        }
        return items;
    }
}
