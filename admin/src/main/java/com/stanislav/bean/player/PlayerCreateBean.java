package com.stanislav.bean.player;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.stanislav.PlayerEJB;
import com.stanislav.TeamEJB;
import com.stanislav.model.Player;
import com.stanislav.model.Team;
import com.stanislav.specifications.PlayerEJBLocal;
import com.stanislav.specifications.TeamEJBLocal;

@ManagedBean(name = "playerCreateMB")
@RequestScoped
public class PlayerCreateBean {

	@EJB(lookup="java:app/Hockey-ejb/PlayerEJB")
	private PlayerEJBLocal playerEJB;

	@EJB(lookup="java:app/Hockey-ejb/TeamEJB")
	private TeamEJBLocal teamEJB;

	private Player player = new Player();
	private List<SelectItem> teams = new ArrayList<SelectItem>();
	private long team_id;

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Internal Error. An error in the database may be the cause.", "Internal Error. An error in the database may be the cause."));
			e.printStackTrace();
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
		try {
			Team team = teamEJB.getTeamById(team_id);
			player.setTeam(team);
			playerEJB.savePlayer(player);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create successful", "A new player was created successfully."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Create unsuccessful", "Internal Error. No new player was created."));
			e.printStackTrace();
		}

	}

}
