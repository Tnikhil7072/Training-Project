package com.adobe.tourism.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.tourism.core.models.MultiTourism;
import com.adobe.tourism.core.services.MultiTourismTitle;

@Model(adaptables=SlingHttpServletRequest.class,
adapters = MultiTourism.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiTourismImpl implements MultiTourism{
	
	private static final Logger LOG = LoggerFactory.getLogger(MultiTourismImpl.class);
	
	  @OSGiService(filter = "(component.name=serviceA)")
	  MultiTourismTitle multiTourismTitle;
	
	@OSGiService(filter = "(component.name=serviceB)")
	MultiTourismTitle multiTourismTitleB;
	
	@Override
	public String getNameFromService() {
		return multiTourismTitle.getName();
	}
	
	
	@Override
	public String getNameFromServiceB() {
		return multiTourismTitleB.getName();
	}


	

}
