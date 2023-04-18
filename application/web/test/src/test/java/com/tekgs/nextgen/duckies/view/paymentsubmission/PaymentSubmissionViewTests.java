package com.tekgs.nextgen.duckies.view.paymentsubmission;

import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.data.cart.CartDefinition;
import com.tekgs.nextgen.duckies.data.cart.CartProvider;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.PURCHASE_SUBMISSION})
public class PaymentSubmissionViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        CartDefinition cartDefinition = CartDefinition.getInstance();
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(cart);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(cart);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }
}
