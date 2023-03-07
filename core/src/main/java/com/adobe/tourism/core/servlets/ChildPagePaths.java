package com.adobe.tourism.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/pagess"}
)
public class ChildPagePaths extends SlingAllMethodsServlet {
	private static final Logger LOG=LoggerFactory.getLogger(ChildPagePaths.class);
	
	  @Override
	    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
	        final ResourceResolver resourceResolver = req.getResourceResolver();
	        LOG.debug("\n=============Updating=======================");

	        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/tourism/us/en");
	        LOG.debug("\n=============Updating=======================");
	        JSONArray pagesArray = new JSONArray();
	        try {
	            Iterator<Page> childPages = page.listChildren();
		        LOG.debug("\n=============Updating=======================");

	            while (childPages.hasNext()) {
	                Page childPage = childPages.next();
	    	        LOG.debug("\n=============Updating=======================");

	                JSONObject pageObject = new JSONObject();
	    	        LOG.debug("\n=============Updating=======================");

	                pageObject.put(childPage.getTitle(), childPage.getPath().toString());
	                pagesArray.put(pageObject);
	            }
	        } catch (JSONException e) {
	            LOG.info("\n ERROR {} ", e.getMessage());
	        }

	        resp.setContentType("application/json");
	        resp.getWriter().write(pagesArray.toString());
	        
	  }
	

}
