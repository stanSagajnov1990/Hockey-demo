package com.stanislav;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.stanislav.model.Team;
import com.stanislav.specifications.TeamEJBLocal;

@Stateless
public class TeamEJB implements TeamEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Team> getAllTeams(){
		return em.createQuery("SELECT t FROM Team t ORDER BY name").getResultList();
	}
	
	public Team getTeamById(Long id){
		return em.find(Team.class, id);
	}

}
