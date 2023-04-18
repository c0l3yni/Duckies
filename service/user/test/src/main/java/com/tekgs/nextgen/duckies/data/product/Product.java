package com.tekgs.nextgen.duckies.data.product;

import com.tekgs.nextgen.duckies.behavior.ToStringBehavior;

@SuppressWarnings("unused") //  Gson is used to populate the fields
public class Product implements ProductCalibratable {
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);
    private String id;
    private String name;
    private Integer price;
    private Integer stock;

    public Product() {
    }

    private static boolean areEquivalent(Object comparatorValue, Object thisValue) {
        return comparatorValue == null || thisValue.equals(comparatorValue);
    }

    public boolean equivalent(ProductCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(Product.class)) {
            return false;
        }
        Product comparator = (Product) obj;
        boolean isEqual = this.getId().equals(comparator.getId());
        isEqual &= this.getName().equals(comparator.getName());
        isEqual &= this.getPrice().equals(comparator.getPrice());
        isEqual &= this.getStock().equals(comparator.getStock());
        return isEqual;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return toStringBehavior.execute();
    }

}
