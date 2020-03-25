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

/**
 * Servlet Filter implementation class PasswordResetFilter
 */
@WebFilter("/PasswordResetFilter")
public class PasswordResetFilter implements Filter {
	ServletContext context;
    /**
     * Default constructor. 
     */
    public PasswordResetFilter() {
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
		String loginPassword = request.getParameter("LoginUserPassword");
		String changedLoginPassword = request.getParameter("changedPassword");
		
		if(!loginPassword.equals(changedLoginPassword))
			context.getRequestDispatcher("/PasswordSuccessfullyReset.jsp").forward(request, response);
		// place your code here
		else
			// pass the request along the filter chain
			chain.doFilter(request, response);
	}



}
