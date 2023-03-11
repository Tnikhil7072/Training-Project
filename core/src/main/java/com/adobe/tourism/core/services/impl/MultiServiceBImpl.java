package com.adobe.tourism.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import com.adobe.tourism.core.services.MultiTourismTitle;

@Component (service= MultiTourismTitle.class,immediate = true,name = "serviceB")
@ServiceRanking(1001)
public class MultiServiceBImpl implements MultiTourismTitle{
	
	@Override
	public String getName() {
		
		return "MultiServiceBImpl";
	}

}
