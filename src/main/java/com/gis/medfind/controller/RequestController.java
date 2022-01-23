package com.gis.medfind.controller;

import java.util.List;

import com.gis.medfind.entity.Request;
import com.gis.medfind.serviceImplem.RequestHandlingServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestController {
    @Autowired
    public RequestHandlingServiceImpl requestService;

    @ModelAttribute(name="request")
    public Request request(){
        return new Request();
    }
    @GetMapping("/sendRequest")
    public String sendRequest(Model model){
        return "sendRequest";
    }
    @PostMapping("/sendRequest")
    public String processRequest(@ModelAttribute Request request, Errors errors){
        if (errors.hasErrors()){
            return "sendRequest";
        }
        requestService.newRequest(request);
        return "RequestSuccess";
    }
    @GetMapping("/handle_request")
    public String handleRequest(Model model){
        List<Request> requests = requestService.getAllRequests();
        model.addAttribute("requests", requests);
        return "validator";
    }
    @PostMapping("handle_request/approve")
    public String approveRequest(@ModelAttribute Request request){
        requestService.acceptRequest(request);
        return "validator";
    }
    @PostMapping("handle_request/reject")
    public String rejectRequest(String requestId){
        requestService.rejectRequest(Long.parseLong(requestId));
        return "validator";
    }

    
}
