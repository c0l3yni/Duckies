package com.tekgs.nextgen.duckies.data.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public Product query(ProductDefinition definition) {
        for(Product candidate:getProductsFromJSON()){
            if(candidate.equivalent(definition)){
                return candidate;
            }
        }
        return null;
    }

    public List<Product> queryAll() {
        return getProductsFromJSON();
    }

    private List<Product> getProductsFromJSON() {
        List<Product> productList = new ArrayList<>();
        Path path = Paths.get("../source/src/data/products.json");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            productList = new Gson().fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productList;
    }
}
