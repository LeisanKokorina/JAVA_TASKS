package com.github.controllers;

import com.github.models.*;
import com.github.services.ActivityService;
import com.github.services.AuthenticationService;
import com.github.services.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ActivityService activityService;

    @SneakyThrows
    @GetMapping(value = "/profile")
    public String getProfilePage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
            List<Repository> repositoryList = userService.getRepositories(user);
            model.addAttribute("repo", repositoryList);
        }
        return "profile";
    }

    @GetMapping(value = "/activity")
    public String getActivityPage(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            List<Login> loginList = activityService.getLoginHistory();
            List<Logout> logoutList = activityService.getLogoutHistory();
            model.addAttribute("user", user);
            model.addAttribute("loginList", loginList);
            model.addAttribute("logoutList", logoutList);
        }

        return "activity";
    }
}
