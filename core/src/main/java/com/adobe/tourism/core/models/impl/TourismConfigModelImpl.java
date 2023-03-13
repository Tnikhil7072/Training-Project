package com.adobe.tourism.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.adobe.tourism.core.models.TourismConfigModel;
import com.adobe.tourism.core.services.TourismConfig;

@Model(adaptables = SlingHttpServletRequest.class, adapters = TourismConfigModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TourismConfigModelImpl implements TourismConfigModel {

	@OSGiService
	TourismConfig tourismConfig;

	@Override
	public String getTourismPlace() {
		return tourismConfig.getTourismPlace();
	}

	@Override
	public int getCapacitySeats() {
		return tourismConfig.getCapacitySeats();
	}

	@Override
	public boolean isFoodAvalible() {
		return tourismConfig.isFoodAvalible();
	}

	@Override
	public String[] getCountries() {
		return tourismConfig.getCountries();
	}

	@Override
	public String getRunModes() {
		return tourismConfig.getRunModes();
	}

}
