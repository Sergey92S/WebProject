/**
 * 
 */
package by.pvt.shmouradko.command;

import static by.pvt.shmouradko.utils.FormDataValidator.creditcardPattern;
import static by.pvt.shmouradko.utils.FormDataValidator.securitycodePattern;
import static by.pvt.shmouradko.utils.FormDataValidator.countPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.shmouradko.*;
import by.pvt.shmouradko.entities.Account;
import by.pvt.shmouradko.entities.CreditCard;
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
public class CreditCardCommand {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private static final String PARAM_NAME_CREDIT_CARD = "name";
	private static final String PARAM_SECURITY_CODE_CREDIT_CARD = "securitycode";
	private static final String PARAM_COUNT_ACCOUNT = "count";
	private static int PARAM_PERSON_ID_CREDIT_CARD;
	private String pathPageUser = "/jsp/user.jsp";
	private String pathPageCreditCard = "/jsp/creditcard.jsp";
	private String messageSecurityCodeError = "This Security Code is already exist.";
	private String messageCreditCardError = "Not all fields are filled.";

    @Autowired
    private ICreditCardService creditCardService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    CreditCard creditCard;

    @Autowired
    Account account;

	@RequestMapping(value="/creditcard", method = RequestMethod.POST)
	public String execute(@RequestParam(PARAM_NAME_CREDIT_CARD) String creditCardPerson, @RequestParam(PARAM_SECURITY_CODE_CREDIT_CARD) String securityCode, @RequestParam(PARAM_COUNT_ACCOUNT) String count, HttpSession session, ModelMap model) {
		String page = null;
		//String creditCardPerson = request.getParameter(PARAM_NAME_CREDIT_CARD);
//		CreditCardService creditcardService = CreditCardService.getInstance();
//		AccountService accountService = AccountService.getInstance();
//		PersonService personService = PersonService.getInstance();
//		CreditCard creditcard = new CreditCard();
//		Account account = new Account();
//		try {
			if (validation(creditCardPerson.trim(), securityCode.trim(),
					count.trim())) {
				int securityCodePerson = Integer.parseInt(securityCode);
				int countPerson = Integer.parseInt(count);
				if ((PARAM_PERSON_ID_CREDIT_CARD = creditCardService
						.checkPersonId(session.getAttribute("user").toString())) != -1) {
					creditCard.setName(creditCardPerson.trim());
					creditCard.setSecurityCode(securityCodePerson);
					creditCard.setPerson(personService.get(PARAM_PERSON_ID_CREDIT_CARD));
					account.setCount(countPerson);
					account.setStatus(1);
					if (!creditCardService.checkSecurityCode(creditCard.getSecurityCode())) {
						model.addAttribute("errorSecurityCodePassMessage",
								messageSecurityCodeError);
						page = pathPageUser;
						return page;
					}
					if (validation(creditCard, account)) {
						creditCardService.register(creditCard);
						account.setCreditCard(creditCardService.get(creditCardService.checkCreditCardId(creditCard.getSecurityCode())));
						accountService.register(account);
						page = pathPageCreditCard;
					} else {
						model.addAttribute("errorCreditCardPassMessage", messageCreditCardError);
						page = pathPageUser;
					}
				}
			} else {
				model.addAttribute("errorCreditCardPassMessage", messageCreditCardError);
				page = pathPageUser;
			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		logger.debug("CreditCardCommand returned: " + page);
		return page;
	}

	public boolean validation(CreditCard creditcard, Account account) {
		if ((creditcard.getName() == null) || (creditcard.getName().equals(""))) {
			return false;
		}
		if ((creditcard.getSecurityCode() == 0) || (creditcard.getSecurityCode() == -1)) {
			return false;
		}
		if ((account.getCount() == 0) || (account.getCount() == -1)) {
			return false;
		}
		return true;
	}

	public boolean validation(String creditCardPerson, String securityCodePerson, String countPerson) {

		if (!creditcardPattern.matcher(creditCardPerson).matches()) {
			return false;
		}

		if (!securitycodePattern.matcher(securityCodePerson).matches()) {
			return false;
		}

		if (!countPattern.matcher(countPerson).matches()) {
			return false;
		}

		return true;

	}

}
