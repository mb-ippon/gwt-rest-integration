package com.ippon.formation.gwt.client.ui.widget;

import java.text.ParseException;

import com.google.gwt.text.shared.Parser;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public class PlaysParser implements Parser<Plays> {

    private static PlaysParser INSTANCE;

    /**
     * Returns the instance of the no-op renderer.
     */
    public static Parser<Plays> instance() {
        if (INSTANCE == null) {
            INSTANCE = new PlaysParser();
        }
        return INSTANCE;
    }

    protected PlaysParser() {
    }

    @Override
    public Plays parse(CharSequence text) throws ParseException {
        Plays plays = null;
        if (ApplicationResources.getMessages().plays_left().equals(text)) {
            plays = Plays.LeftHanded;
        }
        else if (ApplicationResources.getMessages().plays_right().equals(text)) {
            plays = Plays.RightHanded;
        }
        else {
            plays = null;
        }
        return plays;
    }

}
