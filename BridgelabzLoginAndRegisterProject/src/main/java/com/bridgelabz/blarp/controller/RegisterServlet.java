package com.bridgelabz.blarp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bridgelabz.blarp.dto.EngineerRegistrationDetailsDTO;
import com.bridgelabz.blarp.repository.BlarpRepository;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(RegisterServlet.class);
    static EngineerRegistrationDetailsDTO register = new EngineerRegistrationDetailsDTO();
    BlarpRepository repo = BlarpRepository.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("In Register Servlet do get method");
		
		register.setEngineerID(request.getParameter("engineerID"));
		register.setEngineerFirstName(request.getParameter("engineerFirstName"));
		register.setEngineerLastName(request.getParameter("engineerLastName"));
		register.setEngineerDOB(request.getParameter("engineerDOB"));
		register.setEngineerEmailID(request.getParameter("engineerEmailID"));
		register.setEngineerAddress(request.getParameter("engineerAddress"));
		register.setEngineerMobileNumber(request.getParameter("engineerMobileNumber"));
		register.setEngineerYOP(request.getParameter("engineerYOP"));
		register.setEngineerBranch(request.getParameter("engineerBranch"));
		register.setEngineerAggregate(request.getParameter("engineerAggregate"));
		register.setAccountUserName(request.getParameter("accountUserName"));
		register.setAccountUserPassword(request.getParameter("accountUserPassword"));
		register.setAccountChangedPassword(request.getParameter("accountChangedPassword"));
		
	    // Create cookies for first and last names.      
	      Cookie firstName = new Cookie("engineerFirstName", request.getParameter("engineerFirstName"));
	      Cookie lastName = new Cookie("engineerLastName", request.getParameter("engineerLastName"));

	      // Set expiry date after 24 Hrs for both the cookies.
	      firstName.setMaxAge(60*60*24);
	      lastName.setMaxAge(60*60*24);

	      // Add both the cookies in the response header.
	      response.addCookie( firstName );
	      response.addCookie( lastName );
	      
		if(repo.registerUserAndStoreInDatabase(register)) {
			logger.info("Successfully Registered");
			response.getWriter().append("Successfully Registered");
		}else {
			logger.info("Entered Details Already Exsists!!!!!!!");
			response.sendRedirect("ErrorInRegistration.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
