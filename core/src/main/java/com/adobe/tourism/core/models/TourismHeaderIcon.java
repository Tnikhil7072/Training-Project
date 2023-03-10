package com.adobe.tourism.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TourismHeaderIcon {
	

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
	
	

}
