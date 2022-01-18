package com.medfind.medfind;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PharmacyController {
   @GetMapping("/pharmacies")
   public String displayPharmacies(List<Pharmacy> pharmacies) {


      return "home";
   }
   
}
