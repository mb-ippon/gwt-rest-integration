package com.ippon.formation.gwt.client.ui.activity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.ippon.formation.gwt.client.domain.bindery.autobean.CustomAutoBeanFactory;
import com.ippon.formation.gwt.client.domain.bindery.autobean.PlayerAutoBean;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerEvent;
import com.ippon.formation.gwt.client.ui.event.DisplayPlayerHandler;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.client.ui.view.PlayerView;
import com.ippon.formation.gwt.client.ui.view.PlayerView.Presenter;
import com.ippon.formation.gwt.client.ui.view.PlayerViewImpl;
import com.ippon.formation.gwt.shared.domain.entities.Player;

/**
 * Activity du l'écran détaillé d'un joueur
 * 
 * @author mbellang
 * 
 */
public class PlayerActivity implements Presenter {

    private final PlayerView display;
    private final PlayerDriver playerDriver = PlayerDriver.Util.getInstance();
    private final AutoBeanFactory factory = GWT.create(CustomAutoBeanFactory.class);

    public PlayerActivity(PlayerView display) {
        this.display = display;
        bind();
    }

    /**
     * Driver data binding
     * 
     * @author mbellang
     * 
     */
    public interface PlayerDriver extends SimpleBeanEditorDriver<PlayerAutoBean, PlayerViewImpl> {

        public class Util {

            private static PlayerDriver instance;

            public static PlayerDriver getInstance() {
                if (instance == null) {
                    instance = GWT.create(PlayerDriver.class);
                }
                return instance;
            }
        }
    }

    /**
     * Affiche le détail d'un joueur
     * 
     * @param player
     */
    protected void displayPlayer(Player player) {
        String url = GWT.getHostPageBaseURL() + "rest/player/" + player.getName();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));

        try {
            builder.sendRequest(null, new RequestCallback() {

                @Override
                public void onError(Request request, Throwable exception) {
                    Window.alert("request error : " + exception.getMessage());
                }

                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        AutoBean<PlayerAutoBean> bean = AutoBeanCodex.decode(factory, PlayerAutoBean.class,
                                response.getText());
                        playerDriver.edit(bean.as());
                    }
                    else {
                        Window.alert("request error status : " + response.getStatusCode());
                    }
                }
            });
        }
        catch (RequestException e) {
            Window.alert("request error");
        }
    }

    private void bind() {
        playerDriver.initialize((PlayerViewImpl) display);

        ApplicationResources.getHandlerManager().addHandler(DisplayPlayerEvent.TYPE, new DisplayPlayerHandler() {

            @Override
            public void onDisplayPlayer(DisplayPlayerEvent event) {
                displayPlayer(event.getPlayer());
            }
        });
    }
}
