package com.tekgs.nextgen.duckies.data.cart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemAdapter;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public static final String CART_JSON = "../../../service/user/source/data/carts.json";
    private static final Path CART_DATA_FILE_PATH = Path.of(CART_JSON);

    public static CartRepository getInstance() {
        return new CartRepository();
    }

    public Cart query(CartCalibratable definition) {
        for (Cart candidate : query()) {
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }

    public List<Cart> query() {
        List<Cart> cartsList = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(CartItemCalibratable.class, new CartItemAdapter());
        Gson gson = builder.create();
        try (Reader reader = new FileReader(CART_DATA_FILE_PATH.toFile())) {
            cartsList = gson.fromJson(reader, new TypeToken<List<Cart>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartsList;
    }
}
