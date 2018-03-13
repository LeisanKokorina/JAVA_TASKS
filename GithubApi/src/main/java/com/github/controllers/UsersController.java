package com.github.controllers;

import com.github.models.User;
import com.github.services.AuthenticationService;
import com.github.services.AuthorizationService;
import com.github.services.UserService;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping(value = "/profile")
    public String getProfilePage (
            @ModelAttribute("model") ModelMap model,
            Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);

//            List<String> repo=authorizationService.getRepositories(user) ;
//            model.addAttribute("repo",repo);
        }

        return "profile";
    }
}
