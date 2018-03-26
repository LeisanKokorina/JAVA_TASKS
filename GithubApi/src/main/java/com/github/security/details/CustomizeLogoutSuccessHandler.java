package com.github.security.details;


import com.github.models.Logout;
import com.github.repo.LoginRepository;
import com.github.repo.LogoutRepository;
import com.github.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LogoutRepository logoutRepository;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response, Authentication authentication)
            throws IOException {
        // сохранение в бд пользователя и времени выхода
        Logout logout = Logout.builder()
                .logoutTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")))
                .user(usersRepository.findByLogin(authentication.getName()).get())
                .build();
        logoutRepository.save(logout);
        response.setStatus(HttpServletResponse.SC_OK);
        //перенаправление на /login
        response.sendRedirect("/login");
    }

}