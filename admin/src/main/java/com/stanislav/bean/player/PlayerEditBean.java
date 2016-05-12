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

import org.apache.commons.lang3.StringUtils;

import com.stanislav.PlayerEJB;
import com.stanislav.TeamEJB;
import com.stanislav.model.Player;
import com.stanislav.model.Team;

@ManagedBean(name = "playerEditMB")
@RequestScoped
public class PlayerEditBean {

	@EJB
	private PlayerEJB playerEJB;

	@EJB
	private TeamEJB teamEJB;

	@PostConstruct
	public void init() {
		try {
			String id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("id");
			if (!StringUtils.isBlank(id)) {
				player = playerEJB.getPlayerById(Long.valueOf(id));
				if (player.getTeam() != null) {
					team_id = player.getTeam().getId();
				}
			}

			List<Team> teams = teamEJB.getAllTeams();
			for (Team team : teams) {
				SelectItem item = new SelectItem();
				item.setLabel(team.getName());
				item.setValue(team.getId());
				this.teams.add(item);
			}
			
			int height = player.getHeight();
			int feet = height / 12;
			String formattedHeight = ""+feet+"' "+height%12+"''";
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Internal Error. An error in the database may be the cause.",
							"Internal Error. An error in the database may be the cause."));
			e.printStackTrace();
		}

	}

	private Player player = new Player();

	private List<SelectItem> teams = new ArrayList<SelectItem>();
	private long team_id;

	public long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(long id) {
		this.team_id = id;
	}

	public void setTeams(List<SelectItem> teams) {
		this.teams = teams;
	}

	public List<SelectItem> getTeams() {
		return teams;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void save() {
		try {
			Team team = teamEJB.getTeamById(team_id);
			player.setTeam(team);
			playerEJB.updatePlayer(player);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Editing successful", "A new user was edited successfully."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Editing unsuccessful.",
							"Internal Error. Player was not edited."));
			e.printStackTrace();
		}

	}

}
