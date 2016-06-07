package com.stanislav.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="GOALIE_STATISTICS")
public class GoalieStatistics extends Statistics {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GS_ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name="PLAYER_ID",nullable=false)
	private Player player;
	@Column(name="GAMES_STARTED")
	private Integer gamesStarted;
	@Column(name="WINS")
	private Integer wins;
	@Column(name="LOSSES")
	private Integer losses;
	@Column(name="OVERTIME_LOSSES")
	private Integer overtimeLosses;
	@Column(name="SHOTS_AGAINST")
	private Integer shotsAgainst;
	@Column(name="GOALS_AGAINST")
	private Integer goalsAgainst;
	@Column(name="GOALS_AGAINST_AVERAGE", columnDefinition="decimal", precision=18, scale=2)
	private BigDecimal goalsAgainstAverage;
	@Column(name="SAVES")
	private Integer saves;
	@Column(name="SAVE_PERCENTAGE", columnDefinition="decimal", precision=19, scale=3)
	private BigDecimal savePercentage;
	@Column(name="SHUTOUTS")
	private Integer shutouts;
	@Column(name="MINUTES")
	private Integer minutes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getGamesStarted() {
		return gamesStarted;
	}

	public void setGamesStarted(Integer gamesStarted) {
		this.gamesStarted = gamesStarted;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getOvertimeLosses() {
		return overtimeLosses;
	}

	public void setOvertimeLosses(Integer overtimeLosses) {
		this.overtimeLosses = overtimeLosses;
	}

	public Integer getShotsAgainst() {
		return shotsAgainst;
	}

	public void setShotsAgainst(Integer shotsAgainst) {
		this.shotsAgainst = shotsAgainst;
	}

	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public BigDecimal getGoalsAgainstAverage() {
		return goalsAgainstAverage;
	}

	public void setGoalsAgainstAverage(BigDecimal goalsAgainstAverage) {
		this.goalsAgainstAverage = goalsAgainstAverage;
	}
	
	public Integer getSaves() {
		return saves;
	}
	
	public void setSaves(Integer saves) {
		this.saves = saves;
	}

	public BigDecimal getSavePercentage() {
		return savePercentage;
	}

	public void setSavePercentage(BigDecimal savePercentage) {
		this.savePercentage = savePercentage;
	}

	public Integer getShutouts() {
		return shutouts;
	}

	public void setShutouts(Integer shutouts) {
		this.shutouts = shutouts;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

}
