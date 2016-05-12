package com.stanislav;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;

import com.stanislav.model.Player;
import com.stanislav.model.PlayerStatistics;

@Stateless
public class PlayerEJB {

	@PersistenceContext
	private EntityManager em;
	
	public Player getPlayerById(long id){
		return em.find(Player.class, id);
	}

	public Player getPlayerByIdWithEagerStatistics(long id){
		Player player = em.find(Player.class, id);
		List<PlayerStatistics> playerStatistics = player.getPlayerStatistics();
		for (Iterator iterator = playerStatistics.iterator(); iterator.hasNext();) {
			PlayerStatistics playerStatistic = (PlayerStatistics) iterator.next();
			playerStatistic.getGoals();
		}
		return player;
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
	
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers(){
		Query query = em.createNamedQuery("Player.findAll");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayerStatistics> eagerPlayerStatistics(Long id){
		Query query = em.createNamedQuery("PlayerStatistics.findAllForPlayer");
		query.setParameter("PLAYER_ID", id);
		return query.getResultList();
	}
	
}
