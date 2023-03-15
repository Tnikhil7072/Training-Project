package com.adobe.tourism.core.listeners;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true,service= EventListener.class)
public class TourismPageEvents implements EventListener {
	
    private static final Logger log = LoggerFactory.getLogger(TourismPageEvents.class);
    
    private Session session;

    @Reference
    SlingRepository slingRepository;
       

    @Activate
    public void activate() throws Exception {
        try {

            String[] nodetypes={"cq:PageContent"};
            session = slingRepository.loginService("tourserviceuser",null);
            session.getWorkspace().getObservationManager().addEventListener(
                    this,                                 //handler
                    Event.NODE_ADDED | Event.PROPERTY_ADDED,      //int code for event type
                    "/content/tourism/us/en/multifield-page",          				//path
                    true,                                        //is Deep?
                    null,                                    //UUIDs filter
                    nodetypes,                                   //nodetypes filter
                    false);

        } catch (RepositoryException e){
            log.info(" \n Error while adding Event Listener : {} ",e.getMessage());
        }
    }

    public void onEvent(EventIterator eventIterator) {
        try {
            while (eventIterator.hasNext()){
                log.info("\n Path : {} ",eventIterator.nextEvent().getPath());
            }
        } catch(Exception e){
            //log.error("\n Error while processing events : {} ",e.getMessage());
        }
    }



}
