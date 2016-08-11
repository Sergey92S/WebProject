/**
 * 
 */
package by.pvt.shmouradko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.shmouradko.AccountService;
import by.pvt.shmouradko.IAccountService;
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
public class UnBlockCommand  {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private static final String PARAM_SECURITY_CODE_ADMIN = "securitycode";
	private String pathPageMain = "/jsp/main.jsp";
	private String pathPageUnblock = "/jsp/unblock.jsp";
	private String messageAccountError = "There is no such account.";
	private String messageValidationError = "Not all fields are filled.";

    @Autowired
    IAccountService accountService;

	@RequestMapping(value="/unblock", method = RequestMethod.POST)
	public String execute(@RequestParam(PARAM_SECURITY_CODE_ADMIN) String securityCode, HttpSession session, ModelMap model) {
		String page = null;
//		AccountService accountService = AccountService.getInstance();
//		try {
			if (validation(securityCode.trim())) {
				// response parsing
//				int securityCode = Integer.parseInt(request.getParameter(PARAM_SECURITY_CODE_ADMIN));
				if (!accountService.isAccount(Integer.parseInt(securityCode))) {
					model.addAttribute("errorAccountPassMessage", messageAccountError);
					page = pathPageMain;
					return page;
				}
				accountService.changeStatus(Integer.parseInt(securityCode));
				page = pathPageUnblock;
			} else {
				model.addAttribute("errorValidationPassMessage", messageValidationError);
				page = pathPageMain;
			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		logger.debug("UnBlockCommand returned: " + page);
		return page;
	}

	public boolean validation(String securityCode) {

		if ((securityCode == null) || (securityCode.equals(""))) {
			return false;
		}

		return true;
	}

}
