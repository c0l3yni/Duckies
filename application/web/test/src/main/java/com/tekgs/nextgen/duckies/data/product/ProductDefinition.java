package com.tekgs.nextgen.duckies.data.product;

@SuppressWarnings("unused")
public class ProductDefinition implements ProductCalibratable {
    private String name;
    private String id;
    private Integer price;
    private Integer stock;

    public static ProductDefinition getInstance() {
        return new ProductDefinition();
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

    public ProductDefinition withName(String name) {
        this.name = name;
        return this;
    }

    public ProductDefinition withStock(Integer stock) {
        this.stock = stock;
        return this;
    }
}
