package com.adobe.tourism.core.models.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.tourism.core.models.EngineModel;
import com.fasterxml.jackson.annotation.JsonRootName;

@Model(adaptables = SlingHttpServletRequest.class,
adapters = EngineModel.class,
resourceType = EngineModelImpl.RESOURCE_TYPE,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson", extensions ="json",selector = "tourism",
options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})

@JsonRootName("engine-details")
public class EngineModelImpl implements EngineModel {
    private static final Logger LOG = LoggerFactory.getLogger(EngineModelImpl.class);
    final protected static String RESOURCE_TYPE="tourism/components/enginemodel";
    
    
    @Inject
    Resource resource;

    @Override
    public List<Map<String, String>> getEngineDetailsWithMap() {
        List<Map<String, String>> engineDetailsMap=new ArrayList<>();
        try {
            Resource engineDetail=resource.getChild("enginedetailswithmap");
            if(engineDetail!=null){
            	LOG.info("\n===============excutive=======================");
                for (Resource engine : engineDetail.getChildren()) {
                    Map<String,String> engineMap=new HashMap<>();
                    engineMap.put("enginename",engine.getValueMap().get("enginename",String.class));
                    engineMap.put("manufactured",engine.getValueMap().get("manufactured",String.class));
                    engineMap.put("publishyear",engine.getValueMap().get("publishyear",String.class));
                    engineDetailsMap.add(engineMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        return engineDetailsMap;
    }

    }







