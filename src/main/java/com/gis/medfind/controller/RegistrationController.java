package com.gis.medfind.controller;

import java.util.ArrayList;

import com.gis.medfind.entity.Medicine;
import com.gis.medfind.entity.Role;
import com.gis.medfind.entity.User;
import com.gis.medfind.entity.WatchList;
import com.gis.medfind.repository.RoleRepository;
import com.gis.medfind.repository.UserRepository;
import com.gis.medfind.repository.WatchListRepository;
import com.gis.medfind.serviceImplem.CustomUserDetailServices;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

@Controller
@RequiredArgsConstructor
public class RegistrationController {
  @Autowired
  private RoleRepository roleRepo;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CustomUserDetailServices userService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private WatchListRepository watchListRepo;

  @ModelAttribute(name="user")
  public User addUser(){
    return new User();
  }
   @GetMapping("/register")
   public String showRegisterForm() {
     return "signup";
   }
   @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user, Errors errors,Model model) {
        if (errors.hasErrors()){
          return "signup";
        }

        if(userService.loadUserByUsername(user.getEmail())==null){
            model.addAttribute("UserAlreadyExist", true);
            return "signup";
        }
        else{
          model.addAttribute("UserAlreadyExist", false);
        }

        user.setRoles(new ArrayList<Role>());
        Role role =roleRepo.findByName("USER");
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        WatchList watch_list = new WatchList();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        watch_list.setCreationDate(dtf.format(now));
        watch_list.setMedicines(new ArrayList<Medicine>());
        watch_list.setOwner(user);
        watchListRepo.save(watch_list);
        model.addAttribute("SuccessfullRegistration", true);
        return "login";
    }
}

