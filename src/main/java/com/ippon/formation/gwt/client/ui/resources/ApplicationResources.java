package com.ippon.formation.gwt.client.ui.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.web.bindery.event.shared.EventBus;

public class ApplicationResources {

    private static Messages messages;
    private static EventBus eventBus = new SimpleEventBus();
    private static HandlerManager handlerManager = new HandlerManager(eventBus);
    private static CellTableCss cellTableCss;

    public interface MyStyle extends CellTable.Style {
    }

    public interface CellTableCss extends CellTable.Resources {

        @Override
        @Source({ CellTable.Style.DEFAULT_CSS, "CellTable.css" })
        MyStyle cellTableStyle();
    }

    public static CellTableCss getCellTableCss() {
        if (cellTableCss == null) {
            cellTableCss = GWT.create(CellTableCss.class);
        }
        return cellTableCss;
    }

    public static Messages getMessages() {
        if (messages == null) {
            messages = GWT.create(Messages.class);
        }
        return messages;
    }

    public static EventBus getEventBus() {
        return eventBus;
    }

    public static HandlerManager getHandlerManager() {
        return handlerManager;
    }
}
