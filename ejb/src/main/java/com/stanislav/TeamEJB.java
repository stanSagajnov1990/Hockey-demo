package com.stanislav;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stanislav.model.Team;
import com.stanislav.specifications.TeamEJBLocal;

@Stateless
public class TeamEJB implements TeamEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Team> getAllTeams(){
		return em.createQuery("FROM Team t ORDER BY name", Team.class).getResultList();
	}
	
	public Team getTeamById(Long id){
		return em.find(Team.class, id);
	}

}
