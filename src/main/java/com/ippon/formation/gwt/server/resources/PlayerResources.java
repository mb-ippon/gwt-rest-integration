package com.ippon.formation.gwt.server.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ippon.formation.gwt.server.service.PlayerService;
import com.ippon.formation.gwt.shared.domain.entities.Player;

@Path("/player")
public class PlayerResources {

    private final PlayerService service = new PlayerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Player getPlayer(@PathParam("name")
    String name) {
        return service.findPlayer(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Player> getClassement() {
        return service.findClassement();
    }
}
