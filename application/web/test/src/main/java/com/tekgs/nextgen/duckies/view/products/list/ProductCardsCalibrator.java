package com.tekgs.nextgen.duckies.view.products.list;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibrator;

import java.util.List;

public class ProductCardsCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Products List' region";

    private ProductCardsCalibrator(ProductCardsExpected expected, ProductsListCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        List<ProductCardCalibratable> productCardsExpected = expected.inProductCards();
        List<ProductCardCalibratable> productCardsActual = actual.inProductCards();
        addCalibrationsExpected(productCardsExpected, productCardsActual);
        addCalibrationsUnexpected(productCardsActual);
    }

    public static ProductCardsCalibrator getInstance(ProductCardsExpected expected, ProductCards actual) {
        return new ProductCardsCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<ProductCardCalibratable> productsExpected, List<ProductCardCalibratable> productsActual) {
        for (ProductCardCalibratable productExpected : productsExpected) {
            ProductCardCalibratable productFound = addCalibrationFound(productsActual, productExpected);
            if (productFound == null) {
                addChildCalibrator(ProductCardCalibrator.getInstance(productExpected, null));
            } else {
                productsActual.remove(productFound);
            }
        }
    }

    private ProductCardCalibratable addCalibrationFound(List<ProductCardCalibratable> productsActual, ProductCardCalibratable productExpected) {
        ProductCardCalibratable productFound = null;
        for (ProductCardCalibratable productActual : productsActual) {
            if (productActual.equivalent(productExpected)) {
                productFound = productActual;
                addChildCalibrator(ProductCardCalibrator.getInstance(productExpected, productFound));
                break;
            }
        }
        return productFound;
    }

    private void addCalibrationsUnexpected(List<ProductCardCalibratable> productsActual) {
        for (ProductCardCalibratable productUnexpected : productsActual) {
            addChildCalibrator(ProductCardCalibrator.getInstance(null, productUnexpected));
        }
    }

    @Override
    protected void executeVerifications() {

    }
}
