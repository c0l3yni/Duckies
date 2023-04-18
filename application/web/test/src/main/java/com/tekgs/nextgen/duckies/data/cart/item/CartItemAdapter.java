package com.tekgs.nextgen.duckies.data.cart.item;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tekgs.nextgen.duckies.data.product.Product;

import java.io.IOException;

public class CartItemAdapter extends TypeAdapter<CartItemCalibratable> {

    @Override
    public void write(JsonWriter jsonWriter, CartItemCalibratable cartItemCalibratable) {
        //  NO-OP:  The need for writing does not exist in this system
    }


    @Override
    public CartItemCalibratable read(JsonReader reader) {
        CartItem cartItem = new CartItem();
        String fieldName = null;
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                JsonToken token = reader.peek();
                if (token.equals(JsonToken.NAME)) {
                    fieldName = reader.nextName();
                }
                if ("product".equals(fieldName)) {
                    reader.peek();
                    cartItem.product = new Gson().fromJson(reader, Product.class);
                }
                if ("quantity".equals(fieldName)) {
                    reader.peek();
                    cartItem.quantity = reader.nextInt();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartItem;
    }
}
