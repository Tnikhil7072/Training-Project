package com.adobe.tourism.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;

@Component(service = { Servlet.class })
@SlingServletResourceTypes(
		resourceTypes = "tourism/components/page",
		selectors = {"tourism","test"},
		extensions = {"txt","json"}
)
public class ResourcePageTitle extends SlingSafeMethodsServlet {

	private static final Logger LOG = LoggerFactory.getLogger(ResourcePageTitle.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {
		LOG.debug("\n=======================Excutive=======================");
		final Resource resource = req.getResource();
		resp.setContentType("text/plain");
		resp.getWriter().write("Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
		resp.getWriter().write("CreatedBy = " + resource.getValueMap().get(JcrConstants.JCR_CREATED_BY));
		resp.getWriter().write("CreatedON = " + resource.getValueMap().get(JcrConstants.JCR_CREATED));

		
	}


}
