package com.bridgelabz.blarp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bridgelabz.blarp.dto.EngineerLoginDetailsDTO;
import com.bridgelabz.blarp.repository.BlarpRepository;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoginServlet.class);
    static EngineerLoginDetailsDTO login = new EngineerLoginDetailsDTO();
    BlarpRepository repo = BlarpRepository.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login.setUserName(request.getParameter("accountUserName"));
		HttpSession session = request.getSession(false);
		session.setAttribute("accountUserName", login.getUserName());
		
		logger.info("Session : "+ session);
		response.sendRedirect("WelcomeToBridgelabz.jsp");
		logger.info("Successfully Logged In");
		response.getWriter().append("successfully logged in");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
