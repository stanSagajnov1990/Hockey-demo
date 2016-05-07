package com.stanislav;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stanislav.model.Game;

@Stateless
public class GameEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void saveGame(Game game){
		em.persist(game);
	}

}
