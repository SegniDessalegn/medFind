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
   new Pharmacy(1,"first","8.9813972,38.7578696"),new Pharmacy(2,"second","8.9719971,38.7317747"),new Pharmacy(3,"third","8.9719971,38.7317747"));

   @GetMapping("/")
   public String home(Model model) {
      return "home";
   }

   @GetMapping("/result")
   public String homeResult(Model model) {
      
      model.addAttribute("pharmacies", pharmacies);
      return "homeResult";
   }
   
}