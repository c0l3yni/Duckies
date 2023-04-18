package com.tekgs.nextgen.duckies.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.softwaregauntlet.Environment;

public abstract class DuckiesView extends UiView {
    private static final String DOMAIN_URI = Environment.getInstance().getDomainURL();

    protected DuckiesView(String relativeUrl, UiElement viewElement) {
        super(String.format("%s/%s", DOMAIN_URI, relativeUrl), viewElement);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    protected UiElement getViewElementById(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
    protected UiElement getViewElementByTag(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.TAG, locatorValue, this.getElement());
    }

    protected UiElement getViewElementByName(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.NAME, locatorValue, this.getElement());
    }
}
