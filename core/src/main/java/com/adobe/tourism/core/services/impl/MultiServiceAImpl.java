package com.adobe.tourism.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.tourism.core.services.MultiTourismTitle;

@Component(service = MultiTourismTitle.class,immediate= true,name = "serviceA")
@ServiceRanking(1000)

public class MultiServiceAImpl implements MultiTourismTitle{
	
	public static final Logger LOG = LoggerFactory.getLogger(MultiServiceAImpl.class);
	
	
	@Override
	public String getName() {
		return "MultiServiceAImpl";
	}

}
