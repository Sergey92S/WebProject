/**
 * 
 */
package by.pvt.shmouradko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shmouradko Sergey
 *
 */
@Controller
public class LogoutCommand {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private String pathPageUser = "/jsp/user.jsp";
	private String pathPageMain = "/jsp/main.jsp";
	private String pathPageLogin = "/jsp/login.jsp";
	private static final String PARAM_OPTION_USER = "option";

	@RequestMapping(value="/FrontController", method = RequestMethod.GET)
	public String execute(@RequestParam(PARAM_OPTION_USER) String action, HttpSession session, ModelMap model) {
//		String action = request.getParameter("option");
		String page = null;
		if (action.equals("userReturn")) {
			page = pathPageUser;
		} else if (action.equals("adminReturn")) {
			page = pathPageMain;
		} else {
			page = pathPageLogin;
			// session destroy
			session.invalidate();
		}
		logger.debug("LogoutCommand returned: " + page);
		return page;
	}

}
