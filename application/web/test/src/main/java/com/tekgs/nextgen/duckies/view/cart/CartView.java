package com.tekgs.nextgen.duckies.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.view.DuckiesView;
import com.tekgs.nextgen.duckies.view.cart.items.CartItemsRegion;

public class CartView extends DuckiesView implements CartViewCalibratable {
    private static final String RELATIVE_URL = "cart";
    private static final String LOCATOR_VALUE = "cart";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Cart' view";

    public CartView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav(Cart cart) {
        String cartId = cart.getId();
        new CartView().load(String.format("?id=%s", cartId));
        return UiView.expect(CartView.class);
    }

    private UiElement getCheckoutButtonElement() {
        return getViewElementById("disabled button", "checkout-button");
    }

    private UiElement getEmptyMessageElement() {
        return getViewElementById("'Empty' message", "empty-message");
    }

    private UiElement getTotalElement() {
        return getViewElementById("Total", "total");
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getTotal() {
        return getTotalElement().getText();
    }

    @Override
    public Boolean isEmptyMessageDisplayed() {
        String message = getEmptyMessageElement().getText();
        return message != null && !message.isEmpty();
    }

    @Override
    public CartItemsRegion inCartItems() {
        return CartItemsRegion.getInstance(this.getElement());
    }

    @Override
    public Boolean isCheckoutButtonDisplayed() {
        String message = getCheckoutButtonElement().getText();
        return message != null && !message.isEmpty();
    }

    @Override
    public Boolean isCheckoutButtonEnabled() {
        String isDisabled = getCheckoutButtonElement().getAttribute("disabled");
        return isDisabled == null || isDisabled.isEmpty();
    }
}
