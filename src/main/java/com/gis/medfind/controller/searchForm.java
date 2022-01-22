package com.gis.medfind.controller;

import com.gis.medfind.entity.Region;
import com.gis.medfind.repository.RegionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class searchForm {
   @Autowired
    RegionRepository regRepo;


   private String medicineName;
   private String regionName;
   private Double userlat;
   private Double userlong;

   public Region generateRegion(){
      Region region=regRepo.findByName(this.regionName); 
      return region;
  }
}
