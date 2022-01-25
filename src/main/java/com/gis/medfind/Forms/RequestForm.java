package com.gis.medfind.Forms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gis.medfind.entity.Request;
import com.gis.medfind.serviceImplem.FileStorageServiceImpl;
import com.gis.medfind.serviceImplem.RequestHandlingServiceImpl;

import org.hibernate.validator.constraints.Range;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class RequestForm {

    @NotEmpty
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String senderFullName;
    @NotEmpty(message="Email Can't Be Empty")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String pharmacyName;

    @NotNull
    @Range(min = -90, max = 90)
    private Double pharmacyLat;

    @NotNull
    @Range(min = -180, max = 180)
    private Double pharmacyLon;

    @NotNull
    private MultipartFile license;
    
    public void toRequest(RequestHandlingServiceImpl requestService, FileStorageServiceImpl fileService){

        Request request = new Request();
        request.setSenderFullName(this.senderFullName);
        request.setEmail(this.email);
        request.setPharmacyName(this.pharmacyName);

            GeometryFactory geom = new GeometryFactory(new PrecisionModel(), 4326);
            Coordinate location = new Coordinate(this.pharmacyLat, this.pharmacyLon);
        request.setLocation(geom.createPoint(location));

        request.setLicenseFile(fileService.upload(this.license));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String currentDateTime  = dtf.format(now); 
        request.setCreatedDate(currentDateTime);
        
        requestService.newRequest(request);
        
    }
    
}
