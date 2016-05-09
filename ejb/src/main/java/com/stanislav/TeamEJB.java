package com.stanislav;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.stanislav.model.Team;

@Stateless
public class TeamEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Team> getAllTeams(){
		return em.createQuery("SELECT t FROM Team t ORDER BY name").getResultList();
	}
	
	public Team getTeamById(Long id){
		Query query = em.createQuery("SELECT t FROM Team t WHERE team_id = :id");
		query.setParameter("id", id);
		Team team = (Team) query.getSingleResult();
		return team;
	}

}
