package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.stanislav.model.Player;
import com.stanislav.model.PlayerStatistics;
import com.stanislav.specifications.GameEJBLocal;
import com.stanislav.specifications.PlayerEJBLocal;

public class PlayerDisplayController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(PlayerDisplayController.class);
	
	private PlayerEJBLocal playerEJB;
	private GameEJBLocal gameEJB;
	
	public void setPlayerEJB(PlayerEJBLocal playerEJB) {
		this.playerEJB = playerEJB;
	}
	
	public void setGameEJB(GameEJBLocal gameEJB) {
		this.gameEJB = gameEJB;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView model = new ModelAndView("PlayerDisplay");

		if(!StringUtils.isNumeric(req.getParameter("id"))){
			return new ModelAndView("redirect:/all_players.htm");
		}
		Long id = Long.valueOf(req.getParameter("id"));
		logger.info("show User with id: "+id);
		Player player = playerEJB.getPlayerByIdWithEagerStatistics(id);
		
		if(player == null){
			return new ModelAndView("redirect:/all_players.htm");
		}
		
		model.addObject("player", player);
		List<PlayerStatistics> playerStatistics = player.getPlayerStatistics();
		
		for(PlayerStatistics statistic : playerStatistics){
			if (statistic.getYear() == 2015 && !statistic.isPlayoffStatistics()){
				model.addObject("seasonStatistics", statistic);
			}
			if(statistic.getYear() == 2015 && statistic.isPlayoffStatistics()){
				model.addObject("playoffStatistics", statistic);
			} 
		}
		Object[] resultSeason = playerEJB.getSumOfPlayerStatistics(player, false);
		Object[] resultPlayoff = playerEJB.getSumOfPlayerStatistics(player, true);
		
		model.addObject("sumOfSeasons", resultSeason);
		model.addObject("sumOfPlayoffs", resultPlayoff);
		
		return model;
	}

}
