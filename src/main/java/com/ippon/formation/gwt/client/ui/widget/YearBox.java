package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.user.client.ui.ValueBox;

public class YearBox extends ValueBox<Integer> {

    protected YearBox() {
        super(Document.get().createTextInputElement(), YearRenderer.instance(), IntegerParser.instance());
    }

}
