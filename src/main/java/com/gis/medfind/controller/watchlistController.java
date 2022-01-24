package com.gis.medfind.controller;


import com.gis.medfind.entity.Medicine;
import com.gis.medfind.repository.MedicineRepository;
import com.gis.medfind.entity.User;
import com.gis.medfind.entity.WatchList;
import com.gis.medfind.serviceImplem.CustomSecurityService;
import com.gis.medfind.serviceImplem.WatchListServiceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
  
@Controller
public class watchlistController {
    @Autowired
    MedicineRepository medRepo;
    @Autowired
    CustomSecurityService currentUser;
    @Autowired
    WatchListServiceImpl watchlistServ;
     
    @GetMapping("/watchlist")
    public String watchlist(Model model){
        User user=currentUser.findLoggedInUser();
        model.addAttribute("watchlist", watchlistServ.findWatchListByUserId(user.getId()).getMedicines());

        return "watchList";
    }
    @PostMapping("/watchlist/addToWatchlist")
    public String addtoWatchlist(String medicineName,  Model model){
        User user=currentUser.findLoggedInUser();
        WatchList watchList=watchlistServ.findWatchListByUserId(user.getId());
        
        Medicine medicine = medRepo.findByName(medicineName);
        
        if (medicine == null ){
            model.addAttribute("medicineNotFound", true);
            return "watchlist";
        }
        model.addAttribute("medicineNotFound", false);
        watchList.addMedicine(medicine);
        model.addAttribute("watchlist", watchlistServ.findWatchListByUserId(user.getId()).getMedicines());
        return "watchList";
    }
    @PostMapping("/watchlist/removeFromWatchlist")
    public String removeFromWatchlist(String medicineName,Model model){
        User user=currentUser.findLoggedInUser();
        WatchList watchList=watchlistServ.findWatchListByUserId(user.getId());
        Medicine medicine = medRepo.findByName(medicineName);
        watchList.removeMedicine(medicine);
        model.addAttribute("watchlist", watchlistServ.findWatchListByUserId(user.getId()).getMedicines());
        return "watchList";
    }

    
}
