/**
 * 
 */
package by.pvt.shmouradko.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shmouradko Sergey
 *
 */
public interface ActionCommand {
	String execute(HttpServletRequest request);
}
