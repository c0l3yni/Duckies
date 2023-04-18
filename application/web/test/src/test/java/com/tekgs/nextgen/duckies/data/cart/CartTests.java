package com.tekgs.nextgen.duckies.data.cart;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductProvider;
import com.tekgs.nextgen.duckies.view.products.ProductsView;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.Data.CART})
public class CartTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        Cart cart = CartProvider.getInstance().get();
        given(cart);
        CartExpected expected = CartExpected.getInstance(cart);
        when();
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void addItemFromProductsView() {
        Cart cart = CartProvider.getInstance().getMissingAtLeastOneProduct();
        Product product = ProductProvider.getInstance().getOtherThan(cart.getItems());
        given(cart, product);
        CartExpected expected = CartExpected.getInstance(cart, product);
        when();
        ProductsView.directNav(cart.getId()).inProductCards().addToCart(product);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }
}
