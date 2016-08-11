/**
 * 
 */
package by.pvt.shmouradko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.shmouradko.AccountService;
import by.pvt.shmouradko.IAccountService;
import by.pvt.shmouradko.ILoginService;
import by.pvt.shmouradko.LoginService;
import by.pvt.shmouradko.command.enums.ClientType;
import by.pvt.shmouradko.entities.Person;
import by.pvt.shmouradko.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginCommand {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private String pathPageUser = "/jsp/user.jsp";
	private String pathPageMain = "/jsp/main.jsp";
	private String pathPageLogin = "/jsp/login.jsp";
	private String messageLoginError = "Incorrect login or password.";

	@Autowired
	private ILoginService loginService;

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String execute(@RequestParam(PARAM_NAME_LOGIN) String login, @RequestParam(PARAM_NAME_PASSWORD) String pass, HttpSession session, ModelMap model) {
		String page = null;
		// parameter's parsing
//		String login = request.getParameter(PARAM_NAME_LOGIN);
//		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// login and password validation
		Person person = null;
//		LoginService loginService = LoginService.getInstance();
//		try {
			if ((person = loginService.checkPerson(login, pass, person)) != null) {
//				HttpSession session = request.getSession(true);
				session.setAttribute("user", login);
//				AccountService accountService = AccountService.getInstance();
				switch (person.getRole()) {
				case 1:
					session.setAttribute("userType", ClientType.USER);
//					accountService = AccountService.getInstance();
					model.addAttribute("result",
							accountService.getValuesForUser(session.getAttribute("user").toString()));
					page = pathPageUser;
					break;
				case 2:
					session.setAttribute("userType", ClientType.ADMINISTRATOR);
//					accountService = AccountService.getInstance();
					model.addAttribute("result", accountService.getValuesForAdmin());
					page = pathPageMain;
					break;
				default:
					session.setAttribute("userType", ClientType.GUEST);
					page = pathPageLogin;
				}
//				accountService = null;
			} else {
				model.addAttribute("errorLoginPassMessage", messageLoginError);
				model.addAttribute("userType", ClientType.GUEST);
				page = pathPageLogin;
			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		logger.debug("Model returns: " + model);
		logger.debug("LoginCommand returned: " + page);
		return page;
	}

}
