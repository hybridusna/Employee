package webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

	static Log log = LogFactory.getLog(MyListener.class);

	/**
	 * Default constructor.
	 */
	public MyListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("###################################33");
		log.info("########contextDestroyed");
		log.info("###################################33");

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		log.info("###################################33");
		log.info("########contextInitialized");
		log.info("###################################33");
		
		ServletContext application = sce.getServletContext();

		
		String className = application.getInitParameter("className");
		String url = application.getInitParameter("url");
		String user = application.getInitParameter("user");
		String password = application.getInitParameter("password");
		String location = application.getInitParameter("contextConfigLocation");
		
		log.info("className = " + className);
		log.info("url = " + url);
		log.info("user = " + user);
		log.info("password= " + password);
		log.info("location = " + location);

	}

}
