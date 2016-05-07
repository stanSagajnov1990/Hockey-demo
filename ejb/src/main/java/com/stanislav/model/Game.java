package com.stanislav.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="GAME")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GAME_ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name="HOME_TEAM_ID",nullable=false)
	private Team homeTeam;
	@ManyToOne
	@JoinColumn(name="AWAY_TEAM_ID",nullable=false)
	private Team awayTeam;
	@Column(name="HOME_TEAM_SCORE")
	private int homeTeamScore;
	@Column(name="AWAY_TEAM_SCORE")
	private int awayTeamScore;
	@Column(name="GAME_DATE")
	@Temporal(TemporalType.DATE)
	private Date gameDate;
	@Column(name="OT")
	private boolean winInOvertime;
	@Column(name="SO")
	private boolean winInShootout;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public Date getGameDate() {
		return gameDate;
	}
	
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	
	public boolean isWinInOvertime() {
		return winInOvertime;
	}
	
	public void setWinInOvertime(boolean winInOvertime) {
		this.winInOvertime = winInOvertime;
	}
	
	public boolean isWinInShootout() {
		return winInShootout;
	}
	
	public void setWinInShootout(boolean winInShootout) {
		this.winInShootout = winInShootout;
	}
	
}
