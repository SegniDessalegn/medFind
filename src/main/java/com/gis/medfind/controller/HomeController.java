package com.gis.medfind.controller;

import java.util.List;

import com.gis.medfind.entity.Pharmacy;
import com.gis.medfind.repository.RegionRepository;
import com.gis.medfind.serviceImplem.SearchByRegionServiceImpl;
import com.gis.medfind.serviceImplem.SearchByUserLocationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
    @Autowired
    SearchByRegionServiceImpl searchReg;

    @Autowired
    RegionRepository regrepo;


    @Autowired
    searchForm search;
    
    @Autowired
    SearchByUserLocationServiceImpl searchloc;

    @ModelAttribute(name="searchForm")
    public searchForm addSearchForm() {
        return search;
    }
 
    @GetMapping("/")
    public String splash(){
        return "splash";
    }
    @GetMapping("/home")
    public String homepage(Model model) {
        List<String> regionNames = regrepo.getAllRegionNames() ;
        model.addAttribute("regionNames", regionNames);
        return "home";
    }
  
    @PostMapping("/region")
    public String processSearchRegion(@ModelAttribute searchForm form, Model model) {
        //System.out.println("form_id ===>"+form);
        List<Pharmacy> pharm = searchReg.findPharmaciesWithInRegion(form.generateRegion().getId(),
                form.getMedicineName());
        System.out.println(pharm);
        model.addAttribute("pharmaList", pharm);
        return "homeResult";
    }
     
    @PostMapping("/location")
    public String processSearchLocation(@ModelAttribute searchForm form, Model model){
        List<Pharmacy> pharm = searchloc.findPharmaciesByUserLocation(form.getMedicineName(), form.getUserlat(),
                form.getUserlong());
        model.addAttribute("pharmaList", pharm);
        return "homeResult";
    }
    
    
    
} 
