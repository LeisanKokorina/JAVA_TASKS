package com.github.controllers;

import com.github.forms.RegistrationForm;
import com.github.services.ActivityService;
import com.github.services.RegistrationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;



    @SneakyThrows
    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute RegistrationForm form,
                                   @ModelAttribute("model") ModelMap model) {

        String result = service.registration(form);
        if(result.equals("error")){
            model.addAttribute("error", result);
        }else{
            model.addAttribute("username", result);
        }


        return "result";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration_page";
    }


    @GetMapping("/login")
    public String loginPage(@ModelAttribute("model") ModelMap model,
                            @RequestParam(value = "error", required = false) Boolean error) {
        if (error != null) {

            model.addAttribute("error", true);
        } else {
            model.addAttribute("error", false);
        }

        return "login";
    }

}