package com.stanislav.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Statistics {

	@Column(name = "YEAR")
	protected Integer year;
	@Column(name = "PLAYOFF_STATISTICS")
	protected boolean playoffStatistics;
	@Column(name = "GAMES_PLAYED")
	protected Integer gamesPlayed;
	@ManyToOne
	@JoinColumn(name="TEAM_ID",nullable=false)
	protected Team team;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public boolean isPlayoffStatistics() {
		return playoffStatistics;
	}
	public void setPlayoffStatistics(boolean playoffStatistics) {
		this.playoffStatistics = playoffStatistics;
	}
	public Integer getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}


}