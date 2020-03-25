package com.bridgelabz.blarp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.blarp.dto.EngineerRegistrationDetailsDTO;
import com.bridgelabz.blarp.repository.BlarpRepository;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
@WebFilter("/RegistrationFilter")
public class RegistrationFilter implements Filter {
	EngineerRegistrationDetailsDTO register;
	BlarpRepository repo;
	ServletContext context;
    /**
     * Default constructor. 
     */
    public RegistrationFilter() {
    	register = new EngineerRegistrationDetailsDTO();
    	repo = BlarpRepository.getInstance();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		register.setEngineerID(request.getParameter("engineerID"));
		register.setEngineerFirstName(request.getParameter("engineerFirstName"));
		register.setEngineerLastName(request.getParameter("engineerFirstName"));
		register.setEngineerDOB(request.getParameter("engineerFirstName"));
		register.setEngineerEmailID(request.getParameter("engineerFirstName"));
		register.setEngineerAddress(request.getParameter("engineerFirstName"));
		register.setEngineerMobileNumber(request.getParameter("engineerFirstName"));
		register.setEngineerYOP(request.getParameter("engineerFirstName"));
		register.setEngineerBranch(request.getParameter("engineerFirstName"));
		register.setEngineerAggregate(request.getParameter("engineerFirstName"));
		register.setAccountUserName(request.getParameter("engineerFirstName"));
		register.setAccountUserPassword(request.getParameter("engineerFirstName"));
		register.setAccountChangedPassword(request.getParameter("engineerFirstName"));
		// pass the request along the filter chain
		
		if(register.getEngineerMobileNumber().length() < 10 || register.getAccountUserName().length() < 2 || register.getAccountUserPassword().length() < 8 || register.getEngineerLastName().length() < 2 || register.getEngineerFirstName().length() < 2)
			context.getRequestDispatcher("/ErrorInRegistration.jsp").forward(request, response);
		else	
			chain.doFilter(request, response);
	}

}
