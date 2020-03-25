package com.bridgelabz.blarp.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.bridgelabz.blarp.configuration.BlarpConfiguration;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, ServletContextAttributeListener {
	BlarpConfiguration configuration = BlarpConfiguration.getConfigurationInstance();
    Logger logger = Logger.getLogger(ContextListener.class);
    ServletContext servletContext;
    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
    	logger.info("Session Created :: ID = "+sessionEvent.getSession().getId());
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent)  { 
    	 ServletRequest servletRequest = servletRequestEvent.getServletRequest();
    	 logger.info("ServletRequest destroyed. Remote IP = "+servletRequest.getRemoteAddr());
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent servletRequestEvent)  { 
     ServletRequest servletRequest = servletRequestEvent.getServletRequest();
     logger.info("ServletRequest initialized. Remote IP = "+servletRequest.getRemoteAddr());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	logger.info("Session Created :: ID = "+sessionEvent.getSession().getId());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	servletContext = sce.getServletContext();
    	 Connection connection = configuration.connectToDatabaseWithDatabaseName();
    	 try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 logger.info("connection closed for this application");    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        servletContext = sce.getServletContext();
        
        Connection connection = configuration.connectToDatabaseWithDatabaseName();
        servletContext.setAttribute("ConnectionObject", connection);
        logger.info("Database connection established for the application");
    }
	/**
	 * @see ServletContextAttributeEvent added
	 * 
	 */
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
    	logger.info("ServletContext attribute added : : { "+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
    
    /**
     * @see ServletContextAttributeEvent Replaced
     */
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
    	logger.info("ServletContext attribute added : : { "+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
    /**
     * @see ServletContextAttributeEvent Removed
     */
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
    	logger.info("ServletContext attribute added : : { "+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }
}
