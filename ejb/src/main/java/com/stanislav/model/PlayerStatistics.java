package com.stanislav.model;

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

@Entity
@Table(name="PLAYER_STATISTICS")
public class PlayerStatistics {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PS_ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name="PLAYER_ID",nullable=false)
	private Player player;
	@Column(name="YEAR")
	private int year;
	@Column(name="PLAYOFF_STATISTICS")
	private boolean playoffStatistics;
	@Column(name="GAMES_PLAYED")
	private int gamesPlayed;
	@Column(name="GOALS")
	private int goals;
	@Column(name="ASSISTS")
	private int assists;
	@Column(name="POINTS")
	private int points;
	@Column(name="PLUS_MINUS")
	private int plusminus;
	@Column(name="PENALTY_IN_MINUTES")
	private int penaltyInMinutes;
	@Column(name="POWERPLAY_GOALS")
	private int powerPlayGoals;
	@Column(name="POWERPLAY_POINTS")
	private int powerPlayPoints;
	@Column(name="SHORTHANDED_GOALS")
	private int shortHandedGoals;
	@Column(name="SHORTHANDED_POINTS")
	private int shortHandedPoints;
	@Column(name="GAME_WINNING_GOALS")
	private int gameWinningGoals;
	@Column(name="OVERTIME_GOALS")
	private int overtimeGoals;
	@Column(name="SHOTS")
	private int shots;
	@Column(name="SHOT_PERCENTAGE")
	private double shotPercentage;
	@Column(name="FACEOFF_WIN_PERCENTAGE")
	private double faceoffWinPercentage;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID",nullable=false)
	private Team team;
	
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
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isPlayoffStatistics() {
		return playoffStatistics;
	}
	
	public void setPlayoffStatistics(boolean playoffStatistics) {
		this.playoffStatistics = playoffStatistics;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
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

	public double getShotPercentage() {
		return shotPercentage;
	}

	public void setShotPercentage(double shotPercentage) {
		this.shotPercentage = shotPercentage;
	}

	public double getFaceoffWinPercentage() {
		return faceoffWinPercentage;
	}

	public void setFaceoffWinPercentage(double faceoffWinPercentage) {
		this.faceoffWinPercentage = faceoffWinPercentage;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
