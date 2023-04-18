package com.tekgs.nextgen.duckies.user.cart;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductProvider;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemDefinition;
import com.tekgs.nextgen.duckies.user.cart.request.CartRequest;
import com.tekgs.nextgen.duckies.user.cart.request.CartResponse;
import com.tekgs.nextgen.duckies.user.cart.request.CartResponseCalibrator;
import com.tekgs.nextgen.duckies.user.cart.request.CartResponseExpected;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.CART})
public class CartResponseTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        Cart cart = CartProvider.getInstance().get();
        given(cart);
        CartResponseExpected expected = CartResponseExpected.getInstance(cart);
        when();
        CartResponse actual = CartRequest.getInstance(cart).get();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void put() {
        addRequirements("47 - Cart Data");
        Cart cart = CartProvider.getInstance().get();
        List<ProductCalibratable> products = cart.getProducts();
        Product product = ProductProvider.getInstance().getNotIn(products);
        given(cart, product);
        CartItemDefinition itemExpected = CartItemDefinition.getInstance().withProduct(product);
        CartDefinition cartDefinition = cart.toDefinition().withItem(itemExpected);
        CartExpected cartExpected = CartExpected.getInstance(cartDefinition);
        CartResponseExpected expected = CartResponseExpected.getInstance(cartExpected);
        when();
        CartResponse actual = CartRequest.getInstance(cart, product).put();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
}
