package com.github.services;

import org.springframework.security.core.Authentication;
import com.github.models.User;

public interface AuthenticationService {
  User getUserByAuthentication(Authentication authentication);
}