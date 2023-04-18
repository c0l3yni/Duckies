package com.tekgs.nextgen.duckies.user.cart;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public static final String CART_JSON = "../source/data/carts.json";
    private static final Path CART_DATA_FILE_PATH = Path.of(CART_JSON);

    public static CartRepository getInstance() {
        return new CartRepository();
    }

    public Cart query(CartCalibratable cartDefinition) {
        for (Cart candidate : getCarts()) {
            if (candidate.equivalent(cartDefinition)) {
                return candidate;
            }
        }
        return null;
    }

    private List<Cart> getCarts() {
        List<Cart> cartsList = new ArrayList<>();
        try (Reader reader = new FileReader(CART_DATA_FILE_PATH.toFile())) {
            cartsList = new GsonBuilder().create().fromJson(reader, new TypeToken<List<Cart>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartsList;
    }
}
