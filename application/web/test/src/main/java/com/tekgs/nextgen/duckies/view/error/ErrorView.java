package com.tekgs.nextgen.duckies.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.duckies.view.DuckiesView;

public class ErrorView extends DuckiesView implements ErrorViewCalibratable{
    private static final String RELATIVE_URL = "error";
    private static final String DESCRIPTION = "'Generic Error' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "generic-error-page";
    public ErrorView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ErrorView directNav() {
        new ErrorView().load();
        return UiView.expect(ErrorView.class);
    }

    public static ErrorView directNav(String statusCode) {
        new ErrorView().load(String.format("?status=%s", statusCode));
        return UiView.expect(ErrorView.class);
    }
    private UiElement getMessageElement() {
        return getViewElementById("Message", "generic-error");
    }

    @Override
    public String getGenericErrorMessage() {
        return getMessageElement().getText();
    }


    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(this.getAddress());
    }
}
