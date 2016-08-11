/**
 * 
 */
//package by.pvt.shmouradko.command.factory;
//
//import javax.servlet.http.HttpServletRequest;
//
//import by.pvt.shmouradko.command.ActionCommand;
//import by.pvt.shmouradko.command.EmptyCommand;
//import by.pvt.shmouradko.command.enums.CommandEnum;

/**
 * @author Shmouradko Sergey
 *
 */
//public class ActionFactory {
//	private String messageWrongAction = ": command not found or wrong!";
//
//	public ActionCommand defineCommand(HttpServletRequest request) {
//		ActionCommand current = new EmptyCommand();
//		// name parse
//		String action = request.getParameter("command");
//		if (action == null || action.isEmpty()) {
//			// if the command is empty
//			return current;
//		}
//		// return an object due to command
//		try {
//			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
//			current = currentEnum.getCurrentCommand();
//		} catch (IllegalArgumentException e) {
//			request.setAttribute("wrongAction", action + messageWrongAction);
//		}
//		return current;
//	}
//}
