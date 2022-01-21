package com.gis.medfind.startup.configuration;

import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class medFindConfig {
    @Bean
    GeometryFactory getGeometry(){
        GeometryFactory geom = new GeometryFactory();
        return geom;
    }
    @Bean
    PasswordEncoder getEncoder() {
    return new BCryptPasswordEncoder();
}
}
