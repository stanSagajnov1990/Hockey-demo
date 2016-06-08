package com.stanislav.specifications;

import java.util.List;

import javax.ejb.Remote;

import com.stanislav.model.Player;
import com.stanislav.model.PlayerStatistics;

@Remote
public interface PlayerEJBRemote {

	public Player getPlayerById(long id);
	public Player getPlayerByIdWithEagerStatistics(long id);
	public void savePlayer(Player player);
	public void updatePlayer(Player player);
	public Object[] getSumOfPlayerStatistics(Player player, boolean onlyPlayoffs);
	public List<Player> getAllPlayers();
	public List<PlayerStatistics> eagerPlayerStatistics(Long id);
	
}
