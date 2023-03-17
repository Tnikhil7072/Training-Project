package com.adobe.tourism.core.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TourismFooterModel {
	
	 @ValueMapValue
	    @Default(values = "image")
	    private String img;
	    
	    @ValueMapValue
	    @Default(values = "url")
	    private String linkurl;

	        
	    public String getImg() {
			return img;
		}
		
		public String getLinkURL() {
			return linkurl;
		}
		
		@ChildResource
		private final List<LinksModel> quickLinks  =  new ArrayList<>();

		public List<LinksModel> getQuickLinks() {
			List<LinksModel> linkscopy = new ArrayList<LinksModel>();
			linkscopy.addAll(quickLinks);
			return linkscopy;	
			
		}

}


