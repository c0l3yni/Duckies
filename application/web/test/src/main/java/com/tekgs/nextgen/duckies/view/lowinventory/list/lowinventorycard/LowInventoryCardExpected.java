package com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class LowInventoryCardExpected implements LowInventoryCardCalibratable{
    private final ProductCalibratable product;

    public LowInventoryCardExpected(ProductCalibratable product) {
        this.product = product;
    }

    public static LowInventoryCardExpected getInstance(ProductCalibratable product){
        return new LowInventoryCardExpected(product);
}
    @Override
    public boolean equivalent(LowInventoryCardCalibratable comparator) {
        return false;
    }

    @Override
    public String getId() {


        return product.getId();
    }

    @Override
    public String getProductName() {
       return product.getName();
    }

    @Override
    public Integer getInventory() {
        return product.getStock();
    }
}
