package com.stripe.api;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.STRIPE, GauntletTest.Endpoint.PAYMENT})
public class DuckiesChargeTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {50L, "usd", "tok_amex"}
                , {99999999L, "usd", "tok_amex"}
                , {49L, "usd", "tok_amex"}
                , {100000000L, "usd", "tok_amex"}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("34 - Purchase Confirmation");
        String source = "tok_amex";
        String currency = "usd";
        long amount = 1000L;
        DuckiesChargeExpected expected = DuckiesChargeExpected.getInstance(amount);
        DuckiesCharge actual = DuckiesCharge.getInstance(amount, currency, source).submit();
        then(DuckiesChargeCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void submit(long amount, String currency, String source) {
        DuckiesChargeExpected expected = DuckiesChargeExpected.getInstance(amount);
        DuckiesCharge actual = DuckiesCharge.getInstance(amount, currency, source).submit();
        then(DuckiesChargeCalibrator.getInstance(expected, actual));
    }

    @Test(groups={TestSuite.ACCEPTANCE, TestSuite.RELEASE})
    public void fromAppPaymentSubmission() {

    }
}
