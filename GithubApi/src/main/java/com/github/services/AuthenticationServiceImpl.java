package com.github.services;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.github.models.User;
import com.github.repo.UsersRepository;

import java.util.List;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public User getUserByAuthentication(Authentication authentication) {

    String login = authentication.getName().toLowerCase();
    return usersRepository.findByLogin(login).get();
  }



}