package com.gis.medfind.startup.configuration;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class medFindConfig {

    @Bean
    GeometryFactory getGeometry(){
        return new GeometryFactory(new PrecisionModel(), 4326);
    }
    
    @Bean
    PasswordEncoder getEncoder() {
    return new BCryptPasswordEncoder();
}
}
