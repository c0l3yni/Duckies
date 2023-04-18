package com.tekgs.nextgen.duckies.view.admindashboard;

import com.tekgs.nextgen.duckies.data.login.LoginData;
import com.tekgs.nextgen.duckies.data.login.LoginDataDefinition;
import com.tekgs.nextgen.duckies.data.login.LoginDataProvider;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.ADMIN_DASHBOARD})
public class AdminDashboardViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {LoginDataDefinition.getInstance().withFailurePercentage(100)}
                , {LoginDataDefinition.getInstance().withFailurePercentage(0)}
                , {LoginDataDefinition.getInstance().withFailurePercentage(1)}
                , {LoginDataDefinition.getInstance().withFailurePercentage(99)}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        LoginDataDefinition loginDataDefinition = LoginDataDefinition.getInstance().withFailurePercentage(20);
        LoginData loginData = LoginDataProvider.getInstance().get(loginDataDefinition);
        AdminDashboardViewExpected expected = AdminDashboardViewExpected.getInstance(loginData);
        AdminDashboardView actual = AdminDashboardView.directNav(loginData);
        then(AdminDashboardViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE},dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(LoginDataDefinition loginDataDefinition) {
        LoginData loginData = LoginDataProvider.getInstance().get(loginDataDefinition);
        AdminDashboardViewExpected expected = AdminDashboardViewExpected.getInstance(loginData);
        AdminDashboardView actual = AdminDashboardView.directNav(loginData);
        then(AdminDashboardViewCalibrator.getInstance(expected, actual));
    }

}
