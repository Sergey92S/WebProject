/**
 * 
 */
//package by.pvt.shmouradko.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import by.pvt.shmouradko.command.ActionCommand;
//import by.pvt.shmouradko.command.factory.ActionFactory;
//import by.pvt.shmouradko.dao.BaseDAO;

/**
 * @author Shmouradko Sergey
 *
 */
//@SuppressWarnings("serial")
//@WebServlet("/FrontController")
//public class FrontController extends HttpServlet {
//	private String pathPageIndex = "/index.jsp";
//	private String messageNullPage = "Page not found. Business logic error.";
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest(request, response);
//	}
//
//	private void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String page = null;
//		// define command from JSP
//		ActionFactory client = new ActionFactory();
//		ActionCommand command = client.defineCommand(request);
//		/*
//		 * calling execute method and transporting
//		 * parameters to realisation class of the command
//		 */
//		page = command.execute(request);
//		// return page of response
//		if (page != null) {
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//			// calling the page of response
//			dispatcher.forward(request, response);
//		} else {
//			// calling an error page
//			page = pathPageIndex;
//			request.getSession().setAttribute("nullPage", messageNullPage);
//			response.sendRedirect(request.getContextPath() + page);
//		}
//	}
//}
