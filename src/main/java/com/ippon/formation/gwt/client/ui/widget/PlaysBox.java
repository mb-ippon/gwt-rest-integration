package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public class PlaysBox extends ValueBoxBase<Plays> {

    public PlaysBox() {
        this(Document.get().createTextInputElement(), "gwt-TextBox");
    }

    private PlaysBox(Element elem, Renderer<Plays> renderer, Parser<Plays> parser) {
        super(elem, renderer, parser);
    }

    private PlaysBox(Element elem) {
        this(elem, PlaysRenderer.instance(), PlaysParser.instance());
    }

    private PlaysBox(Element element, String styleName) {
        this(element);
        if (styleName != null) {
            setStyleName(styleName);
        }
    }

}
