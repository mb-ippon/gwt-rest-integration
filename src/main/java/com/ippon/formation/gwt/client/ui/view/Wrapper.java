package com.ippon.formation.gwt.client.ui.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;

public class Wrapper extends Composite {

    private static BasicUIBinderUiBinder uiBinder = GWT.create(BasicUIBinderUiBinder.class);

    interface BasicUIBinderUiBinder extends UiBinder<Widget, Wrapper> {
    }

    public Wrapper() {
        initWidget(uiBinder.createAndBindUi(this));
        CssResources.INSTANCE.myCss().ensureInjected();
        title.setInnerText(ApplicationResources.getMessages().tp_title());
        exercise.setInnerText(ApplicationResources.getMessages().tp_exercise());
    }

    @UiField
    PlayersViewImpl classement;
    @UiField
    PlayerViewImpl player;
    @UiField
    Element title;
    @UiField
    Element exercise;

    public PlayersView getClassement() {
        return classement;
    }

    public PlayerView getPlayer() {
        return player;
    }
}
