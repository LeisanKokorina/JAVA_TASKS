package com.github.controllers;

import com.github.forms.RegistrationForm;
import com.github.models.User;
import com.github.services.AuthorizationService;
import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {

  @Autowired
  private AuthorizationService service;

  @PostMapping("/registration")
  public String registrationUser(@ModelAttribute RegistrationForm form,
                                 @ModelAttribute("model") ModelMap model) {
    User user = service.authorization(form);


    model.addAttribute("user", user);
    return "profile";
  }

  @GetMapping("/registration")
  public String getAuthorizationPage() {
    return "registration_page";
  }


  @GetMapping("/login")
  public String login(
          @ModelAttribute("model") ModelMap model,
          @RequestParam(value = "error", required = false) Boolean error) {
    if (error != null) {
      model.addAttribute("error", true);
    } else {
      model.addAttribute("error", false);
    }
    return "login";
  }

}