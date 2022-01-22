package com.medfind.medfind;



import java.util.Arrays;
import java.util.List;

// import com.medfind.medfind.Pharmacy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

   List<Pharmacy> pharmacies = Arrays.asList(
   new Pharmacy(1,"first","32.232,54.23423"),new Pharmacy(2,"second","37.232,59.23423"),new Pharmacy(3,"third","20.232,74.23423"));

   @GetMapping("/")
   public String home(Model model) {
      return "home";
   }

   @GetMapping("/result")
   public String homeResult(Model model) {
      
      model.addAttribute("pharmacies", pharmacies);
      return "watchList";
   }
   
}
