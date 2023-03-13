package com.adobe.tourism.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

import com.adobe.tourism.core.services.TourismConfig;

@Component(service = TourismConfig.class, immediate = true)
@Designate(ocd = TourismConfigImpl.ServiceConfig.class)
public class TourismConfigImpl implements TourismConfig {

	@ObjectClassDefinition(name = "Tourism - Details Configuration", description = "Tourism Configuration demo.")

	public @interface ServiceConfig {

		@AttributeDefinition(name = "Tourism Place", description = "Enter the Tourism Place.", type = AttributeType.STRING)
		public String tourismPlace() default "Tourism  Service";

		@AttributeDefinition(name = "Capacity Seats", description = "No of Seats Available", type = AttributeType.INTEGER

		)
		int getgetCapacitySeats() default 5;

		@AttributeDefinition(name = "FoodAvalible", description = "Confirm that  Food is Available.", type = AttributeType.BOOLEAN)
		boolean getFoodAvalible() default false;

		@AttributeDefinition(name = "Countries", description = "Add countries locales for which you want to run this tourism.", type = AttributeType.STRING)
		String[] getCountries() default { "de", "in" };

		@AttributeDefinition(name = "Run Modes", description = "Select Run Mode.", options = {
				@Option(label = "Author", value = "author"), @Option(label = "Publish", value = "publish"),
				@Option(label = "Both", value = "both") }, type = AttributeType.STRING)
		String getRunMode() default "both";
	}

	private String tourismPlace;
	private int capacitySeats;
	private boolean foodAvalible;
	private String[] countries;
	private String runModes;
	
	
	 @Activate
	    protected void activate(ServiceConfig serviceConfig){
		 tourismPlace=serviceConfig.tourismPlace();
		 capacitySeats=serviceConfig.getgetCapacitySeats();
		 foodAvalible=serviceConfig.getFoodAvalible();
	        countries=serviceConfig.getCountries();
	        runModes=serviceConfig.getRunMode();
	    }
	
	
	@Override
	public String getTourismPlace() {
		return tourismPlace;
	}
	
	@Override
	public int getCapacitySeats() {
		return capacitySeats;
	}
	
	@Override
	public boolean isFoodAvalible() {
		return foodAvalible;
	}
	
	@Override
	public String[] getCountries() {
		return countries;
	}

	@Override
	public String getRunModes() {
		return runModes;
	}



}
