package com.stanislav.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stanislav.model.Player;
import com.stanislav.specifications.PlayerEJBLocal;
import com.stanislav.specifications.TeamEJBLocal;

@Path("/player")
@Produces({ MediaType.APPLICATION_XML })
public class PlayerRestService {

	@EJB(lookup = "java:global/Hockey-main/Hockey-ejb/PlayerEJB!com.stanislav.specifications.PlayerEJBLocal")
	private PlayerEJBLocal playerEJB;

	@EJB(lookup = "java:app/Hockey-ejb/TeamEJB")
	private TeamEJBLocal teamEJB;

	@GET
	@Path("{id}")
	public Response getPlayer(@PathParam("id") String id) {

		PlayerEJBLocal playerEJB = null;
		try {
			final Context context = new InitialContext();

			playerEJB = (PlayerEJBLocal) context
					.lookup("java:app/Hockey-ejb/PlayerEJB!com.stanislav.specifications.PlayerEJBLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// Team team = teamEJB.getTeamById(1L);

		Player player = playerEJB.getPlayerById(Long.valueOf(id));
		return Response.ok(player).build();
	}

	@GET
	public Response getAllBooks() {
		PlayerEJBLocal playerEJB = null;
		try {
			final Context context = new InitialContext();

			playerEJB = (PlayerEJBLocal) context
					.lookup("java:app/Hockey-ejb/PlayerEJB!com.stanislav.specifications.PlayerEJBLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		List<Player> playerList = playerEJB.getAllPlayers();
		Players players = new Players(playerList);
		return Response.ok(players).build();
	}

}
