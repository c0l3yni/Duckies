package com.tekgs.nextgen.duckies.data.product;

public interface ProductCalibratable {
    boolean equivalent(ProductCalibratable comparator);

    Integer getPrice();

    String getName() ;

    String getId();
}
