package com.ippon.formation.gwt.client.ui.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public interface PlayersView extends IsWidget {

    void setData(List<Player> players);

    void setPresenter(Presenter playersActivity);

    void loadingTable();

    public interface Presenter {

        void onCellTableSelected(Player player);
    }

}
