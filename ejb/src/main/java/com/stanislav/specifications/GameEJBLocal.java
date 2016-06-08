package com.stanislav.specifications;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.stanislav.model.Game;

@Local
public interface GameEJBLocal {

	public void saveGame(Game game);
	public Game getGame(Long id);
	public List<Game> getGamesByDate(Date date);
	
}
