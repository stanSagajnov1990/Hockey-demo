package controller;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.stanislav.GreeterHockeyEJB;
import com.stanislav.PlayerEJB;

public class PlayerDisplayController extends AbstractController{

	@EJB(mappedName="java:app/Hockey-ejb/PlayerEJB")
	private PlayerEJB playerEJB;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView model = new ModelAndView("PlayerDisplayController");

//		InitialContext context = new InitialContext();
//		PlayerEJB playerEJB = (PlayerEJB) context.lookup("java:app/Hockey-ejb/PlayerEJB!com.stanislav.PlayerEJB");
		Controller controller = new Controller();
		controller.doSomething();
		model.addObject("player", playerEJB.getPlayerById(Long.valueOf(req.getParameter("id"))));
		
		return model;
	}

}
