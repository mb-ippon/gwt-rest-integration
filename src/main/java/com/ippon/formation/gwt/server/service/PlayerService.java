package com.ippon.formation.gwt.server.service;

import java.util.List;

import org.joda.time.DateTime;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.ippon.formation.gwt.shared.domain.entities.Country;
import com.ippon.formation.gwt.shared.domain.entities.Player;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public class PlayerService {

    private final List<Player> players;

    public PlayerService() {
        players = Lists.newArrayList();
        players.add(new Player("Djokovic N.", 188, 88, new DateTime(1987, 5, 22, 0, 0).toDate(), Plays.RightHanded,
                2003, 12260, new Country("SRB", "Serbia")));
        players.add(new Player("Nadal R.", 185, 85, new DateTime(1986, 6, 3, 0, 0).toDate(), Plays.LeftHanded, 2001,
                13030, new Country("ESP", "Spain")));
        players.add(new Player("Federer R.", 185, 85, new DateTime(1981, 8, 8, 0, 0).toDate(), Plays.RightHanded, 1998,
                4205, new Country("CHE", "Switzerland")));
        players.add(new Player("Tsonga J.W.", 188, 91, new DateTime(1985, 4, 17, 0, 0).toDate(), Plays.RightHanded,
                2004, 3065, new Country("FRA", "France")));
        players.add(new Player("Ferrer D.", 175, 73, new DateTime(1982, 4, 2, 0, 0).toDate(), Plays.RightHanded, 2000,
                5800, new Country("ESP", "Spain")));
        players.add(new Player("Murray A.", 190, 84, new DateTime(1987, 5, 15, 0, 0).toDate(), Plays.RightHanded, 2005,
                5790, new Country("GBR", "Great Britain")));
        players.add(new Player("Del Potro J.M.", 198, 97, new DateTime(1988, 9, 23, 0, 0).toDate(), Plays.RightHanded,
                2005, 5255, new Country("ARG", "Argentina")));
        players.add(new Player("Berdych T.", 196, 91, new DateTime(1985, 9, 17, 0, 0).toDate(), Plays.RightHanded,
                2002, 4180, new Country("CZE", "Czech Republic")));
        players.add(new Player("Wawrinka S.", 183, 81, new DateTime(1985, 3, 28, 0, 0).toDate(), Plays.RightHanded,
                2002, 3730, new Country("CHE", "Switzerland")));
        players.add(new Player("Gasquet R.", 185, 75, new DateTime(1986, 6, 18, 0, 0).toDate(), Plays.RightHanded,
                2002, 3300, new Country("FRA", "France")));
    }

    public List<Player> findClassement() {
        return Lists.newArrayList(Lists.transform(players, new Function<Player, Player>() {

            @Override
            public Player apply(Player input) {
                Player player = new Player();
                player.setName(input.getName());
                player.setAtpPoint(input.getAtpPoint());
                return player;
            }
        }));
    }

    public Player findPlayer(String name) {
        Player playerToReturn = null;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                playerToReturn = player;
                break;
            }
        }
        return playerToReturn;
    }
}
