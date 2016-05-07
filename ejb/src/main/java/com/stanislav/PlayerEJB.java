package com.stanislav;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stanislav.model.Player;

@Stateless
public class PlayerEJB {

	@PersistenceContext
	private EntityManager em;
	
	public Player getPlayerById(long id){
		return em.find(Player.class, id);
	}

	public void savePlayer(Player player) {
		em.persist(player);
	}

	public void updatePlayer(Player player){
		em.merge(player);
	}
	
}
