package com.tekgs.nextgen.duckies.data.product.request;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductCalibrator;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Cart Response";
    private final ProductResponseExpected expected;
    private final ProductResponse actual;

    private ProductResponseCalibrator(ProductResponseExpected expected, ProductResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        if (actual != null && expected != null) {
            List<ProductCalibratable> ProductListExpected = expected.getProducts();
            List<ProductCalibratable> ProductListActual = new ArrayList<>(actual.getProducts());
            addCalibrationsExpected(ProductListExpected, ProductListActual);
            addCalibrationsUnexpected(ProductListActual);
        }
    }

    public static ProductResponseCalibrator getInstance(ProductResponseExpected expected, ProductResponse actual) {
        return new ProductResponseCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<ProductCalibratable> ProductListExpected, List<ProductCalibratable> ProductListActual) {
        for (ProductCalibratable expectedProduct : ProductListExpected) {
            ProductCalibratable productFound = null;
            for (ProductCalibratable candidate : ProductListActual) {
                if (candidate != null && candidate.equivalent(expectedProduct)) {
                    productFound = candidate;
                    addChildCalibrator(ProductCalibrator.getInstance(expectedProduct, productFound));
                    break;
                }
            }
            if (productFound == null) {
                addChildCalibrator(ProductCalibrator.getInstance(expectedProduct, null));
            } else {
                ProductListActual.remove(productFound);
            }
        }
    }

    private void addCalibrationsUnexpected(List<ProductCalibratable> unexpectedProductList) {
        for (ProductCalibratable unexpectedProduct : unexpectedProductList) {
            addChildCalibrator(ProductCalibrator.getInstance(null, unexpectedProduct));
        }
    }

    @Override
    protected void executeVerifications() {
        verify("Status Code", expected.getStatusCode(), actual.getStatusCode());
    }
}
