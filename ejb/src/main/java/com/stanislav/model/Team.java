package com.stanislav.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name = "Team.findByName", query = "SELECT t from Team t WHERE t.name = :name")

@Entity
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3389774397827939750L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	private List<Player> players = new ArrayList<Player>();

	@Basic(fetch = FetchType.EAGER)
	@Lob
	@Column(name = "logo_small", columnDefinition = "VARBINARY")
	private byte[] logoSmall;

	@Column(name = "TOKEN")
	private String token;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLogoSmall() {
		return logoSmall;
	}

	public void setLogoSmall(byte[] logoSmall) {
		this.logoSmall = logoSmall;
	}
	
	public String getLogoSmallAsString(){
		return new String(logoSmall);
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}
}
