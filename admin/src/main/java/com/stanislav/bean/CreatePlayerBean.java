package com.stanislav.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.stanislav.PlayerEJB;
import com.stanislav.TeamEJB;
import com.stanislav.model.Player;
import com.stanislav.model.Team;



@ManagedBean(name="createPlayer")
@RequestScoped
public class CreatePlayerBean {
	
    @EJB
	private PlayerEJB playerEJB;
    
    @EJB
    private TeamEJB teamEJB;
    
	private Player player = new Player(){{
		setName("Alex Ovechkin");
	}};
	
	private List<SelectItem> teams = new ArrayList<SelectItem>();
	private long team_id;

	public Long getTeam_id() {
		return team_id;
	}
	
	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}
	
	@PostConstruct
	public void init(){
		List<Team> teams = teamEJB.getAllTeams();
		
		for(Team team : teams){
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
	
	public void save(){
		System.out.println("TEST");
		Player player = new Player();
		String name = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerName");
		String position = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerPosition");
		int number = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerNumber"));
		int age = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerAge"));
		int weight = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerWeight"));
		int height = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerHeight"));
		String birthDateString = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerBirthdate");
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
		try {
			Date birthdate = sdf.parse(birthDateString);
			player.setBirthdate(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String birthplace = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerBirthplace");
		String imageUrl = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerImageUrl");
		String bigImageUrl = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerBigImageUrl");
		String twitterUrl = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerTwitterUrl");
		String twitterHandle = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:playerTwitterHandle");
		player.setName(name);
		player.setPosition(position);
		player.setNumber(number);
		player.setAge(age);
		player.setWeight(weight);
		player.setHeight(height);
		player.setBirthplace(birthplace);
		player.setImageUrl(imageUrl);
		player.setBigImageUrl(bigImageUrl);
//		player.setTwitterUrl(twitterUrl);
//		player.setTwitterHandle(twitterHandle);
//		player.setTeam_id(team_id);
		
		Team team = teamEJB.getTeamById(team_id);
		player.setTeam(team);
		playerEJB.savePlayer(player);
	}
	
	
	
}
