package com.ippon.formation.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.ippon.formation.gwt.client.ui.activity.PlayerActivity;
import com.ippon.formation.gwt.client.ui.activity.PlayersActivity;
import com.ippon.formation.gwt.client.ui.view.Wrapper;

public class FormationGWT implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Wrapper wrapper = new Wrapper();
        RootPanel.get().add(wrapper);
        PlayersActivity playersActivity = new PlayersActivity(wrapper.getClassement());
        PlayerActivity playerActivity = new PlayerActivity(wrapper.getPlayer());
        playersActivity.go();
    }
}
