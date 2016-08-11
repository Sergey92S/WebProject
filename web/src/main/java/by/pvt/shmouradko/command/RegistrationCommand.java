/**
 * 
 */
package by.pvt.shmouradko.command;

import static by.pvt.shmouradko.utils.FormDataValidator.namePattern;
import static by.pvt.shmouradko.utils.FormDataValidator.surnamePattern;
import static by.pvt.shmouradko.utils.FormDataValidator.loginPattern;
import static by.pvt.shmouradko.utils.FormDataValidator.passwordPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.shmouradko.IPersonService;
import by.pvt.shmouradko.PersonService;
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
public class RegistrationCommand {
	static Logger logger = Logger.getLogger(LoginCommand.class.getName());
	private final String PARAM_NAME_PERSON = "name";
	private final String PARAM_SURNAME_PERSON = "surname";
	private final String PARAM_LOGIN_PERSON = "loginPerson";
	private final String PARAM_PASSWORD_PERSON = "passwordPerson";
	private final int PARAM_ROLE_PERSON = 1;
	private String pathPageLogin = "/jsp/login.jsp";
	private String pathPageRegistration = "/jsp/registration.jsp";
	private String messageLoginRegistrationError = "This login is already exist.";
	private String messageRegistrationError = "Not all fields are filled.";

    @Autowired
    Person person;

    @Autowired
    IPersonService personService;

	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String execute(@RequestParam(PARAM_NAME_PERSON) String name, @RequestParam(PARAM_SURNAME_PERSON) String surname, @RequestParam(PARAM_LOGIN_PERSON) String login, @RequestParam(PARAM_PASSWORD_PERSON) String password, HttpSession session, ModelMap model) {
		String page = null;
		// response parsing
//		String name = request.getParameter(PARAM_NAME_PERSON);
//		String surname = request.getParameter(PARAM_SURNAME_PERSON);
//		String login = request.getParameter(PARAM_LOGIN_PERSON);
//		String password = request.getParameter(PARAM_PASSWORD_PERSON);
		int role = PARAM_ROLE_PERSON;
//		Person person = new Person();
		person.setName(name.trim());
		person.setSurname(surname.trim());
		person.setLogin(login.trim());
		person.setPassword(password.trim());
		person.setRole(role);
//		PersonService personService = PersonService.getInstance();
//		try {
			// login repeat validation
			if (!personService.checkLogin(person.getLogin())) {
				model.addAttribute("errorLoginRegistrationPassMessage",
						messageLoginRegistrationError);
				session.setAttribute("userType", ClientType.GUEST);
				page = pathPageLogin;
				return page;
			}
			if (validation(person)) {
				personService.register(person);
				model.addAttribute("user", login);
//				HttpSession session = request.getSession(true);
				session.setAttribute("userType", ClientType.USER);
				page = pathPageRegistration;
			} else {
				model.addAttribute("errorRegistrationPassMessage", messageRegistrationError);
				session.setAttribute("userType", ClientType.GUEST);
				page = pathPageLogin;
			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		logger.debug("RegistrationCommand returned: " + page);
		return page;
	}

	public boolean validation(Person person) {

		if (!namePattern.matcher(person.getName()).matches()) {
			return false;
		}

		if (!surnamePattern.matcher(person.getSurname()).matches()) {
			return false;
		}

		if (!loginPattern.matcher(person.getLogin()).matches()) {
			return false;
		}

		if (!passwordPattern.matcher(person.getPassword()).matches()) {
			return false;
		}

		return true;
	}

}
