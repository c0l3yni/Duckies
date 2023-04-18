package com.tekgs.nextgen.duckies.view.products.list.productcard;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.data.product.ProductCalibrator;

public class ProductCardCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product Card' region";
    private final ProductCardCalibratable expected;
    private final ProductCardCalibratable actual;

    private ProductCardCalibrator(ProductCardCalibratable expected, ProductCardCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductCardCalibrator getInstance(ProductCardCalibratable expected, ProductCardCalibratable actual) {
        return new ProductCardCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Product Name", expected.getProductName(), actual.getProductName());
        verify("Is 'product out-of-stock' message displayed on add to cart button", expected.getButtonMessage(), actual.getButtonMessage());
        verify("Is 'add to cart' button enabled", expected.isAddToCartEnabled(), actual.isAddToCartEnabled());
        verify("Product Price", expected.getProductPrice(), actual.getProductPrice());
        verify("Is 'Add to cart' button displayed", expected.isAddToCart(), actual.isAddToCart());
    }
}
