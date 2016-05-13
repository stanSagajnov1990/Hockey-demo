package com.stanislav.specifications;

import javax.ejb.Local;

import com.stanislav.model.Game;

@Local
public interface GameEJBLocal {

	public void saveGame(Game game);
	public Game getGame(Long id);
	
}
