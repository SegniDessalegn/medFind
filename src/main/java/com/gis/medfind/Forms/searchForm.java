package com.gis.medfind.Forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import com.gis.medfind.entity.Region;
import com.gis.medfind.repository.RegionRepository;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
   
@Data
@Component
public class searchForm {
   @Autowired
   RegionRepository regRepo;

   @NotEmpty(message = "Please Type The Name of The Medicine !!!")
   private String medicineName;

   @Null
   private String regionName;

   @Null
   @Range(min = -90, max = 90)
   private Double userlat;

   @Null
   @Range(min = -180, max = 180)
   private Double userlong;

   public Region generateRegion(){
      System.out.println("---->>>"+this.regionName);
      Region region=regRepo.findByName(this.regionName); 
      return region;
  }
}

