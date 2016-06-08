package com.stanislav;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.stanislav.model.Game;
import com.stanislav.specifications.GameEJBLocal;

@Stateless
public class GameEJB implements GameEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	public void saveGame(Game game){
		em.persist(game);
	}
	
	public Game getGame(Long id){
		return em.find(Game.class, id);
	}

	@Override
	public List<Game> getGamesByDate(Date date) {
//		Session session = (Session) em.getDelegate();
		TypedQuery<Game> query = em.createNamedQuery("Game.findByDate", Game.class);
		LocalDateTime startLDT = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).minusDays(1);
		LocalDateTime endLDT = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusDays(1);
		Date startDate = Date.from(startLDT.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(endLDT.atZone(ZoneId.systemDefault()).toInstant());

		query.setParameter("ST_DATE", startDate);
		query.setParameter("END_DATE", endDate);
		
		return query.getResultList();
	}

}
