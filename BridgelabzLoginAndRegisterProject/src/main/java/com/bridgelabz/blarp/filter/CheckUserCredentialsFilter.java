package com.bridgelabz.blarp.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.blarp.dto.EngineerLoginDetailsDTO;
import com.bridgelabz.blarp.repository.BlarpRepository;
/**
 * Servlet Filter implementation class CheckUserCredentialsFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.ERROR}, urlPatterns = {"/CheckUserCredentialsFilter"})
public class CheckUserCredentialsFilter implements Filter {
	EngineerLoginDetailsDTO login= new EngineerLoginDetailsDTO();
	BlarpRepository repo = BlarpRepository.getInstance();
	ServletContext servletContext;
    /**
     * Default constructor. 
     */
    public CheckUserCredentialsFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		servletContext = fConfig.getServletContext();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		login.setUserName(request.getParameter("accountUserName"));
		login.setPassword(request.getParameter("accountUserPassword"));
		if(repo.checkLoginCredentials(login))
			chain.doFilter(request, response);
		else
			servletContext.getRequestDispatcher("/ErrorInLogin.jsp").forward(request, response);
	}
}
