package com.stanislav;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.stanislav.model.Player;
import com.stanislav.model.PlayerStatistics;

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
	
	public Object[] getSumOfPlayerStatistics(Player player, boolean onlyPlayoffs){
		String qlString = "SELECT SUM(ps.gamesPlayed)" + 
							      ",SUM(ps.goals)" +
							      ",SUM(ps.assists)" +
							      ",SUM(ps.points)" +
							      ",SUM(ps.plusminus)" + 
							      ",SUM(ps.penaltyInMinutes)" +
							      ",SUM(ps.powerPlayGoals)" +
							      ",SUM(ps.powerPlayPoints)" +
							      ",SUM(ps.shortHandedGoals)" +
							      ",SUM(ps.shortHandedPoints)" +
							      ",SUM(ps.gameWinningGoals)" + 
							      ",SUM(ps.overtimeGoals)" +
							      ",SUM(ps.shots)" +
							      //TODO round up to 2 decimal points
							      ",AVG(ps.shotPercentage)" +
							      ",AVG(ps.faceoffWinPercentage)" +
										"FROM PlayerStatistics ps "+
										"WHERE ps.player = :PLAYER AND "
										+ "ps.playoffStatistics = :ONLYPLAYOFFS";
		Query query = em.createQuery(qlString);
		query.setParameter("PLAYER", player);
		query.setParameter("ONLYPLAYOFFS", onlyPlayoffs);
		Object[] result = (Object[])query.getSingleResult();
		return result;
	}
}
