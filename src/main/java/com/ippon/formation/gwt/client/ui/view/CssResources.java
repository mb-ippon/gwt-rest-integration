package com.ippon.formation.gwt.client.ui.view;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface CssResources extends ClientBundle {
    public static final CssResources INSTANCE = GWT.create(CssResources.class);

    @Source("MyCss.css")
    public MyCss myCss();
}
