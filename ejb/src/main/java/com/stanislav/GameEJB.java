package com.stanislav;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stanislav.model.Game;
import com.stanislav.specifications.GameEJBLocal;

@Stateless
public class GameEJB implements GameEJBLocal{
	
	@PersistenceContext
	private EntityManager em;
	
	public void saveGame(Game game){
		em.persist(game);
	}
	
	public Game getGame(Long id){
		return em.find(Game.class, id);
	}

}
