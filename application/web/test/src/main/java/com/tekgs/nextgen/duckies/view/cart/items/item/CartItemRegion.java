package com.tekgs.nextgen.duckies.view.cart.items.item;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCard;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;

public class CartItemRegion extends UiRegion implements CartItemRegionCalibratable {
    public static final String DESCRIPTION = "Item";
    public static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    public static final String LOCATOR_VALUE = "item";

    private CartItemRegion(UiElement regionElement) {
        super(regionElement);
    }

    public static CartItemRegion getInstance(UiElement itemElement) {
        return new CartItemRegion(itemElement);
    }

    @Override
    public boolean equivalent(CartItemRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean areEquivalent = comparator.getQuantity() == null || this.getQuantity().equals(comparator.getQuantity());
        areEquivalent &= comparator.inProduct() == null || this.inProduct().equivalent(comparator.inProduct());
        return areEquivalent;
    }
    private UiElement getQuantityElement() {
        return UiElement.getInstance("Quantity", UiLocatorType.CLASS, "quantity", this.getElement());
    }

    private UiElement getDecrementButtonElement() {
        return UiElement.getInstance("Decrement Button", UiLocatorType.CLASS, "decrement-button", this.getElement());
    }
    private UiElement getIncrementButtonElement() {
        return UiElement.getInstance("Increment Button", UiLocatorType.CLASS, "increment-button", this.getElement());
    }
    @Override
    public Integer getQuantity() {
        return Integer.parseInt(getQuantityElement().getText());
    }

    @Override
    public ProductCardCalibratable inProduct() {
        return ProductCard.getInstance(this.getElement());
    }

    @Override
    public String getId() {
        return this.getElement().getAttribute("data-id");
    }

    @Override
    public Boolean isDecrementButtonDisplayed() {
        return getDecrementButtonElement().isDisplayed();
    }

    @Override
    public Boolean isIncrementButtonDisplayed() {
        return getIncrementButtonElement().isDisplayed();
    }

    @Override
    public Boolean isDecrementButtonEnabled() {
        String isDisabled = getDecrementButtonElement().getAttribute("disabled");
        return isDisabled == null;
    }

    @Override
    public Boolean isIncrementButtonEnabled() {
        String isDisabled = getIncrementButtonElement().getAttribute("disabled");
        return isDisabled == null;
    }
}
