package com.adobe.tourism.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.tourism.core.models.Visting;

@Model(adaptables = Resource.class,
		adapters = Visting.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class VistingImpl implements Visting{
	
	@Inject
	String fileReference;
	
	@Inject
	String title;
	
	@Inject
	String text;
	
	@Inject
	String discription;

	@Override
	public String getFileReference() {
		// TODO Auto-generated method stub
		return fileReference;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return discription;
	}

}
