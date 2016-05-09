package controller;

import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.stanislav.PlayerEJB;
import com.stanislav.model.Player;

public class PlayerListController extends AbstractController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("PlayerList");
		
		InitialContext context = new InitialContext();
		PlayerEJB playerEJB = (PlayerEJB) context.lookup("java:app/Hockey-ejb/PlayerEJB");
		List<Player> players = playerEJB.getAllPlayers();
		model.addObject("players", players);
		
		return model;
	}
	
	
}
