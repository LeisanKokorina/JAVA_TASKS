package com.github.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.github.repo.UsersRepository;


@Component
public class UsersDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//    Optional<User> userOptional = usersRepository.findByEmail(email);
//    if (userOptional.isPresent()) {
//      User user = userOptional.get();
//      return new UserDetailsImpl(user);
//    } else throw new IllegalArgumentException("User not found by email");
    return new UserDetailsImpl(usersRepository
        .findByLogin(login)
        .orElseThrow(IllegalArgumentException::new));
  }
}