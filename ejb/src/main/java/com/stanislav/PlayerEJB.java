package com.stanislav;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.stanislav.model.Player;
import com.stanislav.model.PlayerStatistics;
import com.stanislav.specifications.PlayerEJBLocal;
import com.stanislav.specifications.PlayerEJBRemote;

@Stateless
public class PlayerEJB implements PlayerEJBLocal, PlayerEJBRemote {

	@PersistenceContext
	private EntityManager em;

	public Player getPlayerById(long id) {
		return em.find(Player.class, id);
	}

	public Player getPlayerByIdWithEagerStatistics(long id) {
		Player player = em.find(Player.class, id);
		if (player != null) {
			List<PlayerStatistics> playerStatistics = player.getPlayerStatistics();
			for (Iterator<PlayerStatistics> iterator = playerStatistics.iterator(); iterator.hasNext();) {
				iterator.next();
			}
		}
		return player;
	}
	
	public void savePlayer(Player player) {
		em.persist(player);
	}

	public void updatePlayer(Player player) {
		em.merge(player);
	}

	public Object[] getSumOfPlayerStatistics(Player player, boolean onlyPlayoffs) {
		String qlString = "SELECT SUM(ps.gamesPlayed)" + 
								",SUM(ps.goals)" + 
								",SUM(ps.assists)" + 
								",SUM(ps.points)"  + 
								",SUM(ps.plusminus)" + 
								",SUM(ps.penaltyInMinutes)" + 
								",SUM(ps.powerPlayGoals)" + 
								",SUM(ps.powerPlayPoints)" + 
								",SUM(ps.shortHandedGoals)" + 
								",SUM(ps.shortHandedPoints)" + 
								",SUM(ps.gameWinningGoals)" + 
								",SUM(ps.overtimeGoals)" + 
								",SUM(ps.shots)" +
								// TODO round up to 2 decimal points
								",AVG(ps.shotPercentage)" + 
								",AVG(ps.faceoffWinPercentage)" + 
									"FROM PlayerStatistics ps "
									+ "WHERE ps.player = :PLAYER AND " + 
									"ps.playoffStatistics = :ONLYPLAYOFFS";
		Query query = em.createQuery(qlString);
		query.setParameter("PLAYER", player);
		query.setParameter("ONLYPLAYOFFS", onlyPlayoffs);
		Object[] result = (Object[]) query.getSingleResult();
		return result;
	}

	public List<Player> getAllPlayers() {
		TypedQuery<Player> query = em.createNamedQuery("Player.findAll", Player.class);
		return query.getResultList();
	}
	
	public List<Player> getAllPlayersFromPosition(String position) {
		if(position != null){
			position = position.toUpperCase();
		}
		TypedQuery<Player> query = em.createNamedQuery("Player.findAllFromPosition", Player.class);
		query.setParameter("position", position);
		return query.getResultList();
	}

	public List<PlayerStatistics> eagerPlayerStatistics(Long id) {
		TypedQuery<PlayerStatistics> query = em.createNamedQuery("PlayerStatistics.findAllForPlayer", PlayerStatistics.class);
		query.setParameter("PLAYER_ID", id);
		return query.getResultList();
	}

}
