package com.ippon.formation.gwt.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public class DisplayPlayerEvent extends GwtEvent<DisplayPlayerHandler> {

    public static Type<DisplayPlayerHandler> TYPE = new Type<DisplayPlayerHandler>();
    private final Player player;

    public DisplayPlayerEvent(Player player) {
        this.player = player;
    }

    @Override
    public Type<DisplayPlayerHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DisplayPlayerHandler handler) {
        handler.onDisplayPlayer(this);
    }

    public Player getPlayer() {
        return player;
    }

}
