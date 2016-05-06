package com.stanislav.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private int age;
	@Column(name="NUMBER")
	private int number;
	@Column(name="POSITION")
	private String position;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthdate;
	@Column(name="BIRTH_PLACE")
	private String birthplace;
	@Column(name="WEIGHT")
	private int weight;
	@Column(name="HEIGHT")
	private int height;
	@Column(name="IMAGE_URL")
	private String imageUrl;
	@Column(name="BIG_IMAGE_URL")
	private String bigImageUrl;

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

	public int getAge() {
		return age;
	}

	public int getNumber() {
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

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
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

	public void setAge(int age) {
		this.age = age;
	}

	public void setNumber(int number) {
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

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

}
