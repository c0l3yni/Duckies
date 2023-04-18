package com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard;


public interface LowInventoryCardCalibratable {
    boolean equivalent(LowInventoryCardCalibratable comparator);

    String getId();

    String getProductName();

    Integer getInventory();
}
