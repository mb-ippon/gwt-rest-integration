package com.ippon.formation.gwt.client.ui.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.ippon.formation.gwt.client.ui.widget.PlayersTable;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public class PlayersViewImpl extends Composite implements PlayersView {

    private static PlayersViewImplUiBinder uiBinder = GWT.create(PlayersViewImplUiBinder.class);

    interface PlayersViewImplUiBinder extends UiBinder<Widget, PlayersViewImpl> {
    }

    private Presenter activity;

    public PlayersViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));

    }

    @UiField
    PlayersTable playersTable;

    @Override
    public void setData(List<Player> players) {
        playersTable.setData(players);
    }

    @UiHandler("playersTable")
    void onSelection(SelectionChangeEvent e) {
        activity.onCellTableSelected(playersTable.getSelectedItem());
    }

    @Override
    public void setPresenter(Presenter playersActivity) {
        this.activity = playersActivity;
    }

    @Override
    public void loadingTable() {
        playersTable.loadingTable();
    }

}
