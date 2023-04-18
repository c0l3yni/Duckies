package com.tekgs.nextgen.duckies.view.products.list;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.view.products.ProductsView;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCard;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductCards extends UiRegion implements ProductsListCalibratable {
    private static final String DESCRIPTION = "'Products List' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-list";

    private ProductCards(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static ProductCards getInstance(UiElement parent) {
        return new ProductCards(parent);
    }

    private static UiElement getAddToCartElement(UiElement productCardElement) {
        String description = "'Add To Cart' button";
        String locatorValue = "add-to-cart";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, productCardElement);
    }

    @Override
    public List<ProductCardCalibratable> inProductCards() {
        List<ProductCardCalibratable> products = new ArrayList<>();
        for (UiElement productElement : getProductCardElements()) {
            products.add(ProductCard.getInstance(productElement));
        }
        return products;
    }

    @SuppressWarnings("UnusedReturnValue")
    public ProductsView addToCart(Product product) {
        UiElement addToCartElement = getAddToCartElement(getProductCardElement(product));
        addToCartElement.click();
        return UiView.expect(ProductsView.class);
    }

    private List<UiElement> getProductCardElements() {
        return UiElement.getList(ProductCard.DESCRIPTION, UiLocatorType.CLASS,
                ProductCard.LOCATOR_VALUE, this.getElement());
    }

    private UiElement getProductCardElement(Product product) {
        if (product.getId() == null) {
            return null;
        }
        for (UiElement candidate : getProductCardElements()) {
            String dataId = candidate.getAttribute("data-id");
            if (product.getId().equals(dataId)) {
                return candidate;
            }
        }
        return null;
    }
}
