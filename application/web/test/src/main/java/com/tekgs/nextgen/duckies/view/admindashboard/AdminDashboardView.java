package com.tekgs.nextgen.duckies.view.admindashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.data.login.LoginData;
import com.tekgs.nextgen.duckies.view.DuckiesView;
import com.tekgs.nextgen.duckies.view.admindashboard.loginfailure.LoginFailureReport;

public class AdminDashboardView extends DuckiesView implements AdminDashboardViewCalibratable {
    private static final String RELATIVE_URI = "admin-dashboard";
    private static final String DESCRIPTION = "'Admin Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "admin-dashboard";

    public AdminDashboardView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static AdminDashboardView directNav(LoginData loginDataDefinition) {
        new AdminDashboardView().load(String.format("?percent=%s", loginDataDefinition.getFailurePercentage()));
        return UiView.expect(AdminDashboardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    @Override
    public LoginFailureReport inLoginFailureReport() {
        return LoginFailureReport.getInstance(this.getElement());
    }

    private UiElement getTitleElement() {
        return getViewElementById("Title", "title");
    }
}
