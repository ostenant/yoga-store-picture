package org.ostenant.yoga.store.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import org.ostenant.yoga.store.webservice.DirMakerImpl;

public class WsPublishListener implements ServletContextListener {

	private static Properties properties = new Properties();
	static {
		try {
			properties.load(WsPublishListener.class.getClassLoader()
					.getResourceAsStream("address.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext sc = arg0.getServletContext();
		String address = properties.getProperty("address");

		DirMakerImpl dirMaker = new DirMakerImpl(sc);
		Endpoint.publish(address, dirMaker);
		sc.setAttribute("dirMaker", dirMaker);
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
