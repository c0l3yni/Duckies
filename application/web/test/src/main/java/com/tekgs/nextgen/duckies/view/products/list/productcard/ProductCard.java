package com.tekgs.nextgen.duckies.view.products.list.productcard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class ProductCard extends UiRegion implements ProductCardCalibratable {
    public static final String DESCRIPTION = "Product Card";
    public static final String LOCATOR_VALUE = "product-card";

    protected ProductCard(UiElement productElement) {
        super(productElement);
    }

    public static ProductCard getInstance(UiElement productElement) {
        return new ProductCard(productElement);
    }

    @Override
    public boolean equivalent(ProductCardCalibratable comparator) {
        return comparator.getProductName() == null || this.getProductName().equals(comparator.getProductName());
    }

    @Override
    public String getProductName() {
        return getNameElement().getText();
    }

    @Override
    public Boolean isAddToCart() {
        return getButtonElement().isDisplayed();
    }

    @Override
    public String getProductPrice() {
        return getPriceElement().getText();
    }

    @Override
    public Boolean isAddToCartEnabled() {
        String isDisabled = getButtonElement().getAttribute("disabled");
        return isDisabled == null;
    }

    @Override
    public String getButtonMessage() {
        return getButtonElement().getText();
    }


    private UiElement getPriceElement() {
        return UiElement.getInstance("Price", UiLocatorType.CLASS, "product-price", this.getElement());
    }

    private UiElement getButtonElement() {
        String description = "'Add to Cart' button";
        String locatorValue = "add-to-cart";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getNameElement() {
        String description = "Name:";
        String locatorValue = "product-name";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }
}
