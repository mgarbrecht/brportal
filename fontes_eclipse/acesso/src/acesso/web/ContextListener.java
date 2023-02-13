package acesso.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("###############   Sistema iniciou = " + new java.util.Date()+ "   ###############");
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		 System.out.println("###############   Sistema parou = " + new java.util.Date()+ "   ###############");
	}
}
