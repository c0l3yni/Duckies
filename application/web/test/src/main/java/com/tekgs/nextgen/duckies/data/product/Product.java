package com.tekgs.nextgen.duckies.data.product;

import com.tekgs.nextgen.duckies.behavior.ToStringBehavior;

@SuppressWarnings("unused") //  Gson is used to populate the fields
public class Product implements ProductCalibratable {
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);
    private String id;
    private String name;
    private Integer price;
    private Integer stock;

    private Product() {
    }

    private static boolean areEquivalent(Object comparatorValue, Object thisValue) {
        return comparatorValue == null || thisValue.equals(comparatorValue);
    }

    public boolean equivalent(ProductCalibratable comparator) {
        if (comparator == null) {
            return false;
        } else if (this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean isEquivalent = areEquivalent(comparator.getName(), this.getName());
        isEquivalent &= areEquivalent(comparator.getPrice(), this.getPrice());
        return isEquivalent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return toStringBehavior.execute();
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
        return isEqual;
    }
}
