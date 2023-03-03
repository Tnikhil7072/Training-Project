package com.adobe.tourism.core.models.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;
import com.adobe.tourism.core.models.VistingPageDetails;

@Model(adaptables=SlingHttpServletRequest.class,
adapters = VistingPageDetails.class,
resourceType = VistingPageDetailsImpl.RESOURCE_TYPE,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VistingPageDetailsImpl implements  VistingPageDetails{
	private static Logger LOG = LoggerFactory.getLogger(VistingPageDetailsImpl.class);
	  final protected static String RESOURCE_TYPE="/tourism/components/vistingpagedetails";
	

	    @Inject
	    Resource resource;
	  
	  
   @SlingObject
   ResourceResolver resourceResolver;
   

   @Self
   SlingHttpServletRequest slingHttpServletRequest;
   
   @RequestAttribute(name = "rAttribute")
   private String reqAttribute;

	
  @ResourcePath(path="/content/tourism/us/en/visiting")@Via("resource")
  Resource resourcePage;
	
	@ScriptVariable
	Page currentPage;
	
    @Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;
	
    @Override
    public String getPageTitle(){
        return currentPage.getTitle();
    }
    
    
    @Override
    public String getRequestAttribute() {
        return reqAttribute;
    }
    
    @Override
    public String getHomePageName(){
        return resourcePage.getName();
    }
    
    @Override
    public String getLastModifiedBy(){
        return modifiedBy;
    }
    
    @PostConstruct
    protected void init() {
    	LOG.info("\n Inside INIT{}:{}",currentPage.getTitle(),resource.getPath());
    }

}
