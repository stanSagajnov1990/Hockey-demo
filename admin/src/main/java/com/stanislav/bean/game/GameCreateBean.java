package com.stanislav.bean.game;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.stanislav.model.Game;
import com.stanislav.model.Team;
import com.stanislav.specifications.GameEJBLocal;
import com.stanislav.specifications.TeamEJBLocal;

@ManagedBean(name = "gameCreateMB")
@RequestScoped
public class GameCreateBean {

	@EJB(lookup="java:app/Hockey-ejb/TeamEJB")
	private TeamEJBLocal teamEJB;

	@EJB(lookup="java:app/Hockey-ejb/GameEJB")
	private GameEJBLocal gameEJB;

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

	public List<SelectItem> getTeams() {
		return teams;
	}

	public void setTeams(List<SelectItem> teams) {
		this.teams = teams;
	}

	@PostConstruct
	public void init() {
		try {
			List<Team> teams = teamEJB.getAllTeams();

			for (Team team : teams) {
				SelectItem item = new SelectItem();
				item.setLabel(team.getName());
				item.setValue(team.getId());
				this.teams.add(item);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Internal Error. An error in the database may be the cause.",
							"Internal Error. An error in the database may be the cause."));
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			Team homeTeam = teamEJB.getTeamById(Long.valueOf(this.homeTeam));
			Team awayTeam = teamEJB.getTeamById(Long.valueOf(this.awayTeam));
			game.setHomeTeam(homeTeam);
			game.setAwayTeam(awayTeam);
			gameEJB.saveGame(game);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create successful", "A new game was created successfully."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Create unsuccessful", "Internal Error. No new game was created."));
		}

	}

}
