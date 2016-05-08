package com.stanislav.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;

import com.stanislav.PlayerEJB;
import com.stanislav.TeamEJB;
import com.stanislav.model.Player;
import com.stanislav.model.Team;

@ManagedBean(name = "editPlayer")
@RequestScoped
public class EditPlayerBean {

	@EJB
	private PlayerEJB playerEJB;

	@EJB
	private TeamEJB teamEJB;

	@PostConstruct
	public void init() {
		String id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (!StringUtils.isBlank(id)) {
			player = playerEJB.getPlayerById(Long.valueOf(id));
			SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
			if (player.getBirthdate() != null)
				birthdate = sdf.format(player.getBirthdate());

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
	}

	private Player player = new Player();

	private List<SelectItem> teams = new ArrayList<SelectItem>();
	private long team_id;
	private String birthdate = new String();

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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void save() {
		Team team = teamEJB.getTeamById(team_id);
		player.setTeam(team);
		playerEJB.updatePlayer(player);
	}

}
