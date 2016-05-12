package com.stanislav.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQueries({
	@NamedQuery(query = "SELECT p from Player p where p.name = :name", name="Player.findByName"),
	@NamedQuery(query = "SELECT p FROM Player p", name="Player.findAll")
})


@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PLAYER_ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private Integer age;
	@Column(name="NUMBER")
	private Integer number;
	@Column(name="POSITION")
	private String position;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthdate;
	@Column(name="BIRTH_PLACE")
	private String birthplace;
	@Column(name="WEIGHT")
	private Integer weight;
	@Column(name="HEIGHT")
	private Integer height;
	@Column(name="IMAGE_URL")
	private String imageUrl;
	@Column(name="BIG_IMAGE_URL")
	private String bigImageUrl;
	//TODO write UnitTest for Fetch Eager and Lazy
	@OneToMany(mappedBy="player")
	private List<PlayerStatistics> playerStatistics = new ArrayList<PlayerStatistics>();
	@Transient
	private String formattedHeight;
	
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID", nullable = false)
	private Team team;

	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getNumber() {
		return number;
	}

	public String getPosition() {
		return position;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getHeight() {
		return height;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}
	
	public List<PlayerStatistics> getPlayerStatistics() {
		return playerStatistics;
	}
	
	public void setPlayerStatistics(List<PlayerStatistics> playerStatistics) {
		this.playerStatistics = playerStatistics;
	}

	public String getFormattedHeight() {
		if(formattedHeight == null){
			int feet = height / 12;
			formattedHeight = ""+feet+"' "+height%12+"''";
		}
		return formattedHeight;
	}
	
	public void setFormattedHeight(String formattedHeight) {
		this.formattedHeight = formattedHeight;
	}
	
}
