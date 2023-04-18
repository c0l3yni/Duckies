package com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class LowInventoryCard extends UiRegion implements LowInventoryCardCalibratable {
    public static final String DESCRIPTION = "low inventory card";
    public static final String LOCATOR_VALUE = "low-inventory-card";

    private LowInventoryCard(UiElement lowInventoryElement) {
        super(lowInventoryElement);
    }

    public static LowInventoryCard getInstance(UiElement lowInventoryElement){
        return new LowInventoryCard(lowInventoryElement);
    }
    public boolean equivalent(LowInventoryCardCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() == null || this.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean areEquivalent = comparator.getProductName() == null || this.getProductName() != null && this.getProductName().equals(comparator.getProductName());
        areEquivalent &= comparator.getInventory() == null || this.getInventory() != null && this.getInventory().equals(comparator.getInventory());
        return areEquivalent;
    }

    @Override
    public String getId() {
        return getIdElement().getText();
    }

    private UiElement getIdElement() {
        return UiElement.getInstance("id", UiLocatorType.CLASS, "inventory-id", this.getElement());

    }

    @Override
    public String getProductName() {
        return getProductNameElement().getText();
    }

    private UiElement getProductNameElement() {
        return UiElement.getInstance("product name", UiLocatorType.CLASS, "product-name", this.getElement());
    }

    @Override
    public Integer getInventory() {
        return Integer.parseInt(getInventoryElement().getText());
    }

    private UiElement getInventoryElement() {
            return UiElement.getInstance("inventory", UiLocatorType.CLASS, "inventory", this.getElement());
    }
}
