package controller;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.stanislav.PlayerEJB;
import com.stanislav.model.Player;

public class PlayerDisplayController extends AbstractController{

	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView model = new ModelAndView("PlayerDisplayController");

		InitialContext context = new InitialContext();
		PlayerEJB playerEJB = (PlayerEJB) context.lookup("java:app/Hockey-ejb/PlayerEJB");
		Player player = playerEJB.getPlayerById(Long.valueOf(req.getParameter("id")));
		model.addObject("player", player);
		
		return model;
	}

}
