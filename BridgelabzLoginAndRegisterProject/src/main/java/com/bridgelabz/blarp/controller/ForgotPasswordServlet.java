package com.bridgelabz.blarp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.blarp.dto.EngineerLoginDetailsDTO;
import com.bridgelabz.blarp.repository.BlarpRepository;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlarpRepository repo = BlarpRepository.getInstance();
    private EngineerLoginDetailsDTO login = new EngineerLoginDetailsDTO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login.setUserName(request.getParameter("accountUserName"));
		login.setPassword(request.getParameter("accountUserPassword"));
		
		if(repo.resetPasswordModule(login)) {
			HttpSession session = request.getSession();
			session.setAttribute("accountUserName", login.getUserName());
			response.sendRedirect("WelcomeToBridgelabz.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}else {
			response.sendRedirect("EngineerLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
