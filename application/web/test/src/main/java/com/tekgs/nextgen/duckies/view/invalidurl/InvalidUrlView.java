package com.tekgs.nextgen.duckies.view.invalidurl;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.view.DuckiesView;

public class InvalidUrlView extends DuckiesView implements InvalidUrlViewCalibratable {
    private static final String RELATIVE_URL = "invalid";
    private static final String DESCRIPTION = "'Invalid Url' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "invalid-url";

    public InvalidUrlView() {

        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static InvalidUrlView directNav() {
        new InvalidUrlView().load();
        return UiView.expect(InvalidUrlView.class);
    }

    @Override
    public String getMessage() {
        return getMessageElement().getText();
    }

    private UiElement getMessageElement() {
        return getViewElementById("Message", "not-found");
    }
}