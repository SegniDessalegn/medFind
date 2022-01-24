package com.gis.medfind.controller;

import com.gis.medfind.entity.Region;
import com.gis.medfind.repository.RegionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class searchForm {
   @Autowired
   RegionRepository regRepo;


   private String medicineName;
   private String regionName;
   private Double userlat;
   private Double userlong;

   public Region generateRegion(){
      System.out.println("---->>>"+this.regionName);
      Region region=regRepo.findByName(this.regionName); 
      return region;
  }
}

