package com.adobe.tourism.core.servlets;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Sample Servlet which runs using the path ",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/sampleservlet" })
public class TourismPathServlet  extends SlingSafeMethodsServlet{
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4438376868274173005L;

	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(TourismPathServlet.class);

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		try {
			String property = request.getParameter("prop");
			String path = request.getParameter("path");
			log.debug("param 1 is : " + property);
			log.debug("param 2 is : " + path);
			ResourceResolver resolver = request.getResourceResolver();
			Session session = resolver.adaptTo(Session.class);
			Node pathNode = session.getNode(path);
			Node jcrNode = pathNode.getNode("jcr:content");
			String propVal = null;
			if (jcrNode.hasProperty(property)) {
				propVal = jcrNode.getProperty(property).getValue().getString();
			}
			if (propVal != null) {
				response.getWriter().println("Value for the property " + property + " is  , " + propVal);
			} else {
				response.getWriter().println("There is no property with the name , " + property);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
