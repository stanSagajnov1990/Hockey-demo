package com.stanislav.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(query = "FROM PlayerStatistics ps WHERE ps.player.id = :PLAYER_ID", name="PlayerStatistics.findAllForPlayer")
})


@Entity
@Table(name="PLAYER_STATISTICS")
public class PlayerStatistics extends Statistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4887123564231595970L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PS_ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name="PLAYER_ID",nullable=false)
	private Player player;
	@Column(name="GOALS")
	private Integer goals;
	@Column(name="ASSISTS")
	private Integer assists;
	@Column(name="POINTS")
	private Integer points;
	@Column(name="PLUS_MINUS")
	private Integer plusminus;
	@Column(name="PENALTY_IN_MINUTES")
	private Integer penaltyInMinutes;
	@Column(name="POWERPLAY_GOALS")
	private Integer powerPlayGoals;
	@Column(name="POWERPLAY_POINTS")
	private Integer powerPlayPoints;
	@Column(name="SHORTHANDED_GOALS")
	private Integer shortHandedGoals;
	@Column(name="SHORTHANDED_POINTS")
	private Integer shortHandedPoints;
	@Column(name="GAME_WINNING_GOALS")
	private Integer gameWinningGoals;
	@Column(name="OVERTIME_GOALS")
	private Integer overtimeGoals;
	@Column(name="SHOTS")
	private Integer shots;
	@Column(name="SHOT_PERCENTAGE", columnDefinition="decimal", precision=18, scale=2)
	private BigDecimal shotPercentage;
	@Column(name="FACEOFF_WIN_PERCENTAGE", columnDefinition="decimal", precision=18, scale=2)
	private BigDecimal faceoffWinPercentage;
	

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
	
	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPlusminus() {
		return plusminus;
	}

	public void setPlusminus(int plusminus) {
		this.plusminus = plusminus;
	}

	public int getPenaltyInMinutes() {
		return penaltyInMinutes;
	}

	public void setPenaltyInMinutes(int penaltyInMinutes) {
		this.penaltyInMinutes = penaltyInMinutes;
	}

	public int getPowerPlayGoals() {
		return powerPlayGoals;
	}

	public void setPowerPlayGoals(int powerPlayGoals) {
		this.powerPlayGoals = powerPlayGoals;
	}

	public int getPowerPlayPoints() {
		return powerPlayPoints;
	}

	public void setPowerPlayPoints(int powerPlayPoints) {
		this.powerPlayPoints = powerPlayPoints;
	}

	public int getShortHandedGoals() {
		return shortHandedGoals;
	}

	public void setShortHandedGoals(int shortHandedGoals) {
		this.shortHandedGoals = shortHandedGoals;
	}

	public int getShortHandedPoints() {
		return shortHandedPoints;
	}

	public void setShortHandedPoints(int shortHandedPoints) {
		this.shortHandedPoints = shortHandedPoints;
	}

	public int getGameWinningGoals() {
		return gameWinningGoals;
	}

	public void setGameWinningGoals(int gameWinningGoals) {
		this.gameWinningGoals = gameWinningGoals;
	}

	public int getOvertimeGoals() {
		return overtimeGoals;
	}

	public void setOvertimeGoals(int overtimeGoals) {
		this.overtimeGoals = overtimeGoals;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public BigDecimal getShotPercentage() {
		return shotPercentage;
	}

	public void setShotPercentage(BigDecimal shotPercentage) {
		this.shotPercentage = shotPercentage;
	}

	public BigDecimal getFaceoffWinPercentage() {
		return faceoffWinPercentage;
	}

	public void setFaceoffWinPercentage(BigDecimal faceoffWinPercentage) {
		this.faceoffWinPercentage = faceoffWinPercentage;
	}

}
