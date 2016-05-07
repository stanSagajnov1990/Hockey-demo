package com.stanislav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.stanislav.GameEJB;
import com.stanislav.PlayerEJB;
import com.stanislav.TeamEJB;
import com.stanislav.model.Game;
import com.stanislav.model.Player;
import com.stanislav.model.Team;

@ManagedBean(name = "createGame")
@RequestScoped
public class CreateGameBean {

	@EJB
	private PlayerEJB playerEJB;

	@EJB
	private TeamEJB teamEJB;

	@EJB
	private GameEJB gameEJB;

	private Player player = new Player() {
		{
			setName("Alex Ovechkin");
		}
	};

	private Game game = new Game();

	private List<SelectItem> teams = new ArrayList<SelectItem>();
	private long team_id;

	private String homeTeam;
	private String awayTeam;

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	@PostConstruct
	public void init() {
		List<Team> teams = teamEJB.getAllTeams();

		for (Team team : teams) {
			SelectItem item = new SelectItem();
			item.setLabel(team.getName());
			item.setValue(team.getId());
			this.teams.add(item);
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<SelectItem> getTeams() {
		return teams;
	}

	public void setTeams(List<SelectItem> teams) {
		this.teams = teams;
	}

	public void save() {
		System.out.println("TEST");

		Team homeTeam = teamEJB.getTeamById(Long.valueOf(this.homeTeam));
		Team awayTeam = teamEJB.getTeamById(Long.valueOf(this.awayTeam));
		game.setHomeTeam(homeTeam);
		game.setAwayTeam(awayTeam);
		gameEJB.saveGame(game);
	}

}
