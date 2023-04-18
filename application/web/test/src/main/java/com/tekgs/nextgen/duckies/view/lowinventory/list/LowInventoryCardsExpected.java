package com.tekgs.nextgen.duckies.view.lowinventory.list;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductProvider;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCard;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardCalibratable;
import com.tekgs.nextgen.duckies.view.lowinventory.list.lowinventorycard.LowInventoryCardExpected;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardExpected;

import java.util.ArrayList;
import java.util.List;

public class LowInventoryCardsExpected implements LowInventoryCardsCalibratable{
    private final List<Product> products = ProductProvider.getInstance().getAll();

    public static LowInventoryCardsExpected getInstance() {
        return new LowInventoryCardsExpected();
    }

    public List<LowInventoryCardCalibratable> inLowInventoryCards() {
        List<LowInventoryCardCalibratable> lowInventoryCardRegions = new ArrayList<>();
        for (ProductCalibratable product : products) {
            if(product.getStock() <= 6 ){
            lowInventoryCardRegions.add(LowInventoryCardExpected.getInstance(product));
        }}
        return lowInventoryCardRegions;
    }
}
