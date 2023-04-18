package com.tekgs.nextgen.duckies.view.products;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.view.DuckiesView;
import com.tekgs.nextgen.duckies.view.products.list.ProductCards;

public class ProductsView extends DuckiesView implements ProductsViewCalibratable {
    private static final String RELATIVE_URL = "products";
    private static final String DESCRIPTION = "'Products' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-page";

    public ProductsView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ProductsView directNav() {
        return directNav("");
    }

    public static ProductsView directNav(String cartId) {
        String queryString = "".equals(cartId) ? "" : String.format("?cart-id=%s", cartId);
        new ProductsView().load(queryString);
        return UiView.expect(ProductsView.class);
    }

    @Override
    public ProductCards inProductCards() {
        return ProductCards.getInstance(this.getElement());
    }
}
