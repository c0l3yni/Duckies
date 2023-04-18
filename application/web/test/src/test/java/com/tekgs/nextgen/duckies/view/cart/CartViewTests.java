package com.tekgs.nextgen.duckies.view.cart;

import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.data.cart.CartDefinition;
import com.tekgs.nextgen.duckies.data.cart.CartProvider;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.CART})
public class CartViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {CartDefinition.getInstance().withTotal(0)},
                {CartDefinition.getInstance().withNoItem()},
                {CartDefinition.getInstance()}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("308 - Cart: increment/decrement buttons");
        Cart cart = CartProvider.getInstance().get();
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart);
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition cartDefinition) {
        addRequirements("308 - Cart: increment/decrement buttons");
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart);
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}
