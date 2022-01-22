package com.medfind.medfind;



import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

   @GetMapping("/")
   public String home(Model model) {
      // ArrayList<Medicine> medicineList = new ArrayList<>(); 

      // medicineList.add((new Medicines(1,"parestamol")));
      // medicineList.add(new Medicines(2,"amoxacaclin"));
      // model.addAttribute("medicines", medicines)
      return "home";
   }
   
}
