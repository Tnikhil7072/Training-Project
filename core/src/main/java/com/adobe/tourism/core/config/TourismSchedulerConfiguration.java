package com.adobe.tourism.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "Tourism schedule - Scheduler Configuration",
        description = "Sling scheduler configuration"
)
   public @interface TourismSchedulerConfiguration {
	
	 @AttributeDefinition(
	            name = "Scheduler name",
	            description = "Name of the scheduler",
	            type = AttributeType.STRING)
	    public String schedulerName() ;

	    @AttributeDefinition(
	            name = "Cron Expression",
	            description = "Cron expression used by the scheduler",
	            type = AttributeType.STRING)
	    public String cronExpression();

}
