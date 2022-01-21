package com.gis.medfind.serviceImplem;

import com.gis.medfind.service.SearchByUserLocationService;

import java.util.ArrayList;
import java.util.List;
import com.gis.medfind.entity.Pharmacy;
import com.gis.medfind.repository.PharmacyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchByUserLocationServiceImpl implements SearchByUserLocationService {

    @Autowired
    PharmacyRepository pharmRepo;


    public List<Pharmacy> findPharmaciesByUserLocation(String medicineName, Double userLat, Double userLon){
        List<Pharmacy> pharmsCloseToUser = pharmRepo.findAllPharmaciesByDistanceFromUser(userLat, userLon);
        List<Pharmacy> pharmsCloseToUserWithMedicine = new ArrayList<>();
        for(Pharmacy pharm: pharmsCloseToUser){
            if(pharm.checkMedicine(medicineName)){
                pharmsCloseToUserWithMedicine.add(pharm);
            }
        }
        return pharmsCloseToUserWithMedicine;
    }

}
