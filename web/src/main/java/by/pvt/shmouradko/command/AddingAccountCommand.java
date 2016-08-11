/**
 * 
 */
package by.pvt.shmouradko.command;

import static by.pvt.shmouradko.utils.FormDataValidator.sumPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.shmouradko.AccountService;
import by.pvt.shmouradko.IAccountService;
import by.pvt.shmouradko.ITransactionService;
import by.pvt.shmouradko.TransactionService;
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
public class AddingAccountCommand {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private static final String PARAM_NAME_USER = "name";
	private static final String PARAM_SECURITY_CODE_USER = "securitycode";
	private static final String PARAM_SUM_USER = "sum";
	private String pathPageUser = "/jsp/user.jsp";
	private String pathPageAdding = "/jsp/adding.jsp";
	private String messageCheckAccountError = "There is no such account.";
	private String messageValidationError = "Not all fields are filled.";

	@Autowired
	private ITransactionService transactionService;

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value="/adding", method = RequestMethod.POST)
	public String execute(@RequestParam(PARAM_NAME_USER) String user, @RequestParam(PARAM_SECURITY_CODE_USER) String securityCode, @RequestParam(PARAM_SUM_USER) String sum, HttpSession session, ModelMap model) {
		String page = null;
//		TransactionService transactionService = TransactionService.getInstance();
//		AccountService accountService = AccountService.getInstance();
//		try {
			if (validation(user.trim(), securityCode.trim(),
					sum.trim())) {
//				int securityCode = Integer.parseInt(request.getParameter(PARAM_SECURITY_CODE_USER));
//				int sum = Integer.parseInt(request.getParameter(PARAM_SUM_USER));
				if (!accountService.isAccount(Integer.parseInt(securityCode))) {
					model.addAttribute("errorCheckAccountPassMessage", messageCheckAccountError);
					page = pathPageUser;
					return page;
				}
				transactionService.transactionManager(Integer.parseInt(sum), Integer.parseInt(securityCode));
				page = pathPageAdding;
			} else {
				model.addAttribute("errorValidationPassMessage", messageValidationError);
				page = pathPageUser;
			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		logger.debug("AddingAccountCommand returned: " + page);
		return page;
	}

	public boolean validation(String name, String securityCode, String sum) {
		if ((name == null) || (name.equals(""))) {
			return false;
		}

		if ((securityCode == null) || (securityCode.equals(""))) {
			return false;
		}

		if ((sum == null) || (sum.equals(""))) {
			return false;
		}

		if (!sumPattern.matcher(sum).matches()) {
			return false;
		}

		return true;
	}

}
