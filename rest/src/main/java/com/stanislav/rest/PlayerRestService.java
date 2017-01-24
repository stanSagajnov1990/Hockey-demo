package com.stanislav.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.stanislav.model.Player;
import com.stanislav.model.Team;
import com.stanislav.specifications.PlayerEJBLocal;
import com.stanislav.specifications.TeamEJBLocal;

@Path("/players")
@Produces({ MediaType.APPLICATION_XML })
public class PlayerRestService {

	@EJB(lookup = "java:app/Hockey-ejb/PlayerEJB!com.stanislav.specifications.PlayerEJBLocal")
	private PlayerEJBLocal playerEJB;

	@EJB(lookup = "java:app/Hockey-ejb/TeamEJB")
	private TeamEJBLocal teamEJB;

	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("{id}")
	public Response getPlayer(@PathParam("id") String id) {

		Player player = playerEJB.getPlayerById(Long.valueOf(id));
		return Response.ok(player).build();
	}
	
	@GET
	@Path("{id}/team")
	public Response getTeamForPlayer(@PathParam("id") String id) {
		Player player = playerEJB.getPlayerById(Long.valueOf(id));
		Team team = player.getTeam();
		return Response.ok(team).build();
	}

	@GET
	public Response getAllPlayers(@QueryParam("position") String position) {
		List<Player> playerList = null;
		if(position != null && !position.isEmpty()){
			playerList = playerEJB.getAllPlayersFromPosition(position);
		} else {
			playerList = playerEJB.getAllPlayers();
		}
		
		List<Player> wsPlayers = new ArrayList<>();
		
		for (Player player : playerList) {
			Player wsPlayer = new Player();
			wsPlayer.setId(player.getId());
			wsPlayer.setUri(uriInfo.getAbsolutePath() + "/" + player.getId());
			wsPlayer.setName(player.getName());
			wsPlayers.add(wsPlayer);
		}

		Players players = new Players(wsPlayers);
		return Response.ok(players).build();
	}

}
