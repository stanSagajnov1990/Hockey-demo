package com.stanislav.specifications;

import java.util.List;

import javax.ejb.Local;

import com.stanislav.model.Team;

@Local
public interface TeamEJBLocal {

	public List<Team> getAllTeams();
	public Team getTeamById(Long id);
	
}
