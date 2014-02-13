package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;

public class YearRenderer extends AbstractRenderer<Integer> {

    private static YearRenderer INSTANCE;

    /**
     * Returns the instance.
     */
    public static Renderer<Integer> instance() {
        if (INSTANCE == null) {
            INSTANCE = new YearRenderer();
        }
        return INSTANCE;
    }

    protected YearRenderer() {
    }

    @Override
    public String render(Integer object) {
        if (null == object) {
            return "";
        }

        return NumberFormat.getFormat("####").format(object);
    }
}
