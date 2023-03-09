package com.adobe.tourism.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.tourism.core.models.TourismDescription;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TourismDescriptionImpl implements TourismDescription {

	
	@Inject
	String title;
	
	@Inject
	String text;

	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getText() {
		return text;
	}

}
