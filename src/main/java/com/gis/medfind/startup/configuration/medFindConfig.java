package com.gis.medfind.startup.configuration;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class medFindConfig {

    @Bean
    GeometryFactory getGeometry(){
        return new GeometryFactory(new PrecisionModel(), 4326);
    }
   
}
