package com.stanislav.bean.player;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.stanislav.PlayerEJB;
import com.stanislav.model.Player;

@ManagedBean(name = "playerListMB")
@RequestScoped
public class PlayerListBean {

	private List<Player> players;

	@EJB
	private PlayerEJB playerEJB;

	@PostConstruct
	public void init() {
		players = playerEJB.getAllPlayers();

	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
