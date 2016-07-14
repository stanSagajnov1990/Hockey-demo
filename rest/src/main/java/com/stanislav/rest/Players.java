package com.stanislav.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.stanislav.model.Player;


@XmlRootElement
public class Players extends ArrayList<Player> {

	public Players() {
		
	}
	
	public Players(Collection<? extends Player> c) {
		super(c);
	}
	
	@XmlElement(name = "book")
	public List<Player> getPlayers(){
		return this;
	}
	
	public void setPlayers(List<Player> players){
		this.addAll(players);
	}
	
}
