package com.gis.medfind.serviceImplem;

import com.gis.medfind.entity.Pharmacy;
import com.gis.medfind.repository.PharmacyRepository;

import java.util.ArrayList;
import java.util.List;

import com.gis.medfind.service.SearchByRegionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    
@Service 
public class SearchByRegionServiceImpl implements SearchByRegionService{

    @Autowired
    private PharmacyRepository pharmRepo;

    public SearchByRegionServiceImpl(PharmacyRepository pm){
        this.pharmRepo = pm;
    }
    
    public List<Pharmacy> findPharmaciesWithInRegion(Long regionId, String medicineName){
        List<Pharmacy> pharmsInRegion = pharmRepo.findAllPharmacyWithInRegion(regionId);
        List<Pharmacy> pharmsInRegionWithMedicine = new ArrayList<>();
        for(Pharmacy pharm: pharmsInRegion){
            if(pharm.checkMedicine(medicineName)){
                pharmsInRegionWithMedicine.add(pharm);
            }
        }
        return pharmsInRegionWithMedicine;
    }
}
