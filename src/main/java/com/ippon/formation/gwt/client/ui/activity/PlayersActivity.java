package com.ippon.formation.gwt.client.ui.activity;

import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayersView;
import com.ippon.formation.gwt.shared.domain.entities.Player;

/**
 * L'activity de la grid des joueurs
 * 
 * @author mbellang
 * 
 */
public class PlayersActivity implements PlayersView.Presenter {

    private final PlayersView display;

    public PlayersActivity(PlayersView display) {
        this.display = display;
        this.display.setPresenter(this);
    }

    /**
     * lance l'affichage du tableau
     * 
     */
    public void go() {
        display.loadingTable();

    }

    @Override
    public void onCellTableSelected(Player player) {
        ApplicationResources.getHandlerManager().fireEvent(new DisplayPlayerEvent(player));
    }
}
