package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public class PlaysRenderer extends AbstractRenderer<Plays> {

    private static PlaysRenderer INSTANCE;

    /**
     * Returns the instance of the no-op renderer.
     */
    public static Renderer<Plays> instance() {
        if (INSTANCE == null) {
            INSTANCE = new PlaysRenderer();
        }
        return INSTANCE;
    }

    protected PlaysRenderer() {
    }

    @Override
    public String render(Plays object) {
        String plays;
        switch (object) {
        case LeftHanded:
            plays = ApplicationResources.getMessages().plays_left();
            break;
        case RightHanded:
            plays = ApplicationResources.getMessages().plays_right();
            break;
        default:
            plays = null;
            break;
        }
        return plays;
    }

}
