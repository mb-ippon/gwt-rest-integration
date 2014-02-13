package com.ippon.formation.gwt.client.ui.activity;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;
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
        String url = GWT.getHostPageBaseURL() + "rest/player";
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
                        Document doc = XMLParser.parse(response.getText());
                        Element element = doc.getDocumentElement();
                        NodeList nlist = element.getElementsByTagName("player");
                        final int count = nlist.getLength();
                        List<Player> players = Lists.newArrayList();

                        for (int i = 0; i < count; ++i) {
                            final Node player = nlist.item(i);
                            NodeList playerDetails = player.getChildNodes();
                            Player p = new Player();
                            p.setAtpPoint(Integer.valueOf(playerDetails.item(0).getFirstChild().getNodeValue()));
                            p.setName(playerDetails.item(1).getFirstChild().getNodeValue());
                            players.add(p);
                        }

                        display.setData(players);
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

    @Override
    public void onCellTableSelected(Player player) {
        ApplicationResources.getHandlerManager().fireEvent(new DisplayPlayerEvent(player));
    }
}
