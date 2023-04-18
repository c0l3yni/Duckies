package com.tekgs.nextgen.duckies.view.admindashboard.loginfailure;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class LoginFailureReport extends UiRegion implements LoginFailureReportCalibratable {
    private static final String DESCRIPTION = "'Login Failure' report";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "failure-report";

    protected LoginFailureReport(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static LoginFailureReport getInstance(UiElement parent) {
        return new LoginFailureReport(parent);
    }

    @Override
    public String getFailurePercentage() {
        return getFailurePercentageElement().getText();
    }

    private UiElement getFailurePercentageElement() {
        String DESCRIPTION = "failure percentage";
        return UiElement.getInstance(DESCRIPTION, UiLocatorType.ID, "failure-percentage", this.getElement());
    }
}
