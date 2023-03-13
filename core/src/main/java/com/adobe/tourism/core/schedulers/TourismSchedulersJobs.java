package com.adobe.tourism.core.schedulers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.sling.commons.scheduler.JobContext;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.commons.scheduler.Job;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.tourism.core.config.TourismSchedulerConfiguration;

@Component(immediate = true, service = Job.class)
@Designate(ocd = TourismSchedulerConfiguration.class)
public class TourismSchedulersJobs implements Job {

	public static final Logger LOG = LoggerFactory.getLogger(TourismSchedulersJobs.class);
	

    private int schedulerJobId;

	@Reference
	private Scheduler scheduler;

	@Activate
	protected void activate(TourismSchedulerConfiguration config) {
		addSchedulerJob(config);
		schedulerJobId = config.schedulerName().hashCode();
	}

	@Deactivate
	protected void deactivate(TourismSchedulerConfiguration config) {
		removeSchedulerJob();
	}

	private void removeSchedulerJob() {
		scheduler.unschedule(String.valueOf(schedulerJobId));
	}

	private void addSchedulerJob(TourismSchedulerConfiguration config) {

		ScheduleOptions in = scheduler.EXPR("0 13 14 1/1 * ? *");
		Map<String, Serializable> inMap = new HashMap<>();
		inMap.put("country", "INDIA");
		inMap.put("url", "www.in.com");
		in.config(inMap);

		scheduler.schedule(this, in);
		ScheduleOptions de = scheduler.EXPR("0 14 14 1/1 * ? *");
		Map<String, Serializable> deMap = new HashMap<>();
		deMap.put("country", "UK");
		deMap.put("url", "www.uk.com");
		de.config(deMap);
		scheduler.schedule(this, de);

		ScheduleOptions us = scheduler.EXPR("0 19 14 1/1 * ? *");
		Map<String, Serializable> usMap = new HashMap<>();
		usMap.put("country", "US");
		usMap.put("url", "www.us.com");
		us.config(usMap);
		scheduler.schedule(this, us);
	}

	@Override
	public void execute(JobContext jobContext) {
		LOG.info("\n =======> COUNTRY {} : URL {} ", jobContext.getConfiguration().get("country"),
				jobContext.getConfiguration().get("url"));
	}
}
