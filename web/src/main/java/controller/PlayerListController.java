package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.stanislav.model.Player;
import com.stanislav.specifications.PlayerEJBLocal;

public class PlayerListController extends AbstractController {
	
	private PlayerEJBLocal playerEJB;
	
	public void setPlayerEJB(PlayerEJBLocal playerEJB) {
		this.playerEJB = playerEJB;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("PlayerList");
		
		List<Player> players = playerEJB.getAllPlayers();
		model.addObject("players", players);
		
		return model;
	}
	
	
}
