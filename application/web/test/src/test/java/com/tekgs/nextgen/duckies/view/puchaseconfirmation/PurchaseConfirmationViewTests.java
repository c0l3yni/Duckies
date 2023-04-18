package com.tekgs.nextgen.duckies.view.puchaseconfirmation;

import com.tekgs.nextgen.duckies.data.payment.PaymentData;
import com.tekgs.nextgen.duckies.data.payment.PaymentDataDefinition;
import com.tekgs.nextgen.duckies.data.payment.PaymentDataProvider;
import com.tekgs.nextgen.duckies.view.paymentsubmission.PaymentSubmissionView;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.PURCHASE_CONFIRMATION})
public class PurchaseConfirmationViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        int fiftyCents = 50;
        int oneLessThanOneMillion = 99999999;
        return new Object[][]{
                {PaymentDataDefinition.getInstance().withAmount(fiftyCents)}
                , {PaymentDataDefinition.getInstance().withAmount(oneLessThanOneMillion)}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        PaymentData paymentData = PaymentDataProvider.getInstance().get();
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance();
        PurchaseConfirmationView actual = PaymentSubmissionView.directNav().submit(paymentData);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void submit(PaymentDataDefinition paymentDefinition) {
        PaymentData paymentData = PaymentDataProvider.getInstance().get(paymentDefinition);
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance();
        PurchaseConfirmationView actual = PaymentSubmissionView.directNav().submit(paymentData);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }
}
