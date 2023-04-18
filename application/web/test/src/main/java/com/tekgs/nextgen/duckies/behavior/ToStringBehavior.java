package com.tekgs.nextgen.duckies.behavior;

import com.google.gson.Gson;

public class ToStringBehavior {
    private final Object objectToString;
    private final String objectClass;

    public ToStringBehavior(Object objectToString) {
        this.objectToString = objectToString;
        this.objectClass = objectToString.getClass().getSimpleName();
    }

    public static ToStringBehavior getInstance(Object objectToString) {
        return new ToStringBehavior(objectToString);
    }

    public String execute() {
        return String.format("%s: %s", objectClass, new Gson().toJson(objectToString));
    }
}
