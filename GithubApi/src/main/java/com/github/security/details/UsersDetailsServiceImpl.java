package com.github.security.details;

import com.github.models.User;
import com.github.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.github.repo.UsersRepository;

import java.util.Optional;


@Component
public class UsersDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;
  @Autowired
  private ActivityService activityService;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Optional<User> userOptional = usersRepository.findByLogin(login.toLowerCase());//регистронезависимый ввод юзернейма
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      activityService.addLoginTime(user);//сохранение времени входа
      return new UserDetailsImpl(user);
    } else throw new IllegalArgumentException("User not found by login");
  }
}