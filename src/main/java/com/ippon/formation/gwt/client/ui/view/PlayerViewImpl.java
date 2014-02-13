package com.ippon.formation.gwt.client.ui.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.widget.PlaysBox;
import com.ippon.formation.gwt.client.ui.widget.YearBox;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public class PlayerViewImpl extends Composite implements PlayerView, Editor<Player> {

    private static PlayerViewImplUiBinder uiBinder = GWT.create(PlayerViewImplUiBinder.class);

    interface PlayerViewImplUiBinder extends UiBinder<Widget, PlayerViewImpl> {
    }

    @UiField
    @Path("name")
    TextBox name;

    @UiField
    @Ignore
    Element lblName;

    @UiField
    @Ignore
    Element lblHeight;

    @UiField
    @Ignore
    Element lblWeight;

    @UiField
    @Ignore
    Element lblBirthday;

    @UiField
    @Ignore
    Element lblPlayHand;

    @UiField
    @Ignore
    Element lblTurnPro;

    @UiField
    @Ignore
    Element lblCountry;

    @UiField
    @Path("birthDay")
    DateBox birthDay;

    @UiField
    @Path("country.libelle")
    TextBox country;

    @UiField
    @Path("playHand")
    PlaysBox playHand;

    @UiField
    @Path("height")
    IntegerBox height;

    @UiField
    @Path("weight")
    IntegerBox weight;

    @UiField
    @Path("yearTurnPro")
    YearBox yearTurnPro;

    public PlayerViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        lblName.setInnerText(ApplicationResources.getMessages().player_name());
        lblBirthday.setInnerText(ApplicationResources.getMessages().player_birthday());
        lblCountry.setInnerText(ApplicationResources.getMessages().player_country());
        lblHeight.setInnerText(ApplicationResources.getMessages().player_height());
        lblPlayHand.setInnerText(ApplicationResources.getMessages().player_play());
        lblTurnPro.setInnerText(ApplicationResources.getMessages().player_turnedpro());
        lblWeight.setInnerText(ApplicationResources.getMessages().player_weight());
        birthDay.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd MMMM yyyy")));
    }
}
