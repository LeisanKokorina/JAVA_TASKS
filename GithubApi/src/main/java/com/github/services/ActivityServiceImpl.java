package com.github.services;


import com.github.models.Login;
import com.github.models.Logout;
import com.github.models.User;
import com.github.repo.LoginRepository;
import com.github.repo.LogoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private LogoutRepository logoutRepository;

    @Override
    public List<Login> getLoginHistory() {
        return loginRepository.findAll();
    }

    @Override
    public String addLoginTime(User user) {
        Login login = Login.builder()
                .loginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")))
                .user(user)
                .build();
        loginRepository.save(login);
        return user.getLogin();
    }

    @Override
    public List<Logout> getLogoutHistory() {
        return logoutRepository.findAll();
    }
}
