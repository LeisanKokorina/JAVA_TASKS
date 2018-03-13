package com.github.services;

import com.github.forms.RegistrationForm;
import com.github.models.Role;
import com.github.models.State;
import com.github.models.User;
import com.github.repo.UsersRepository;
import lombok.SneakyThrows;
import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private UsersRepository usersRepository;
    private PasswordEncoder encoder = new BCryptPasswordEncoder();


@SneakyThrows
    @Override
    public User authorization(RegistrationForm form) {
        String hashPassword = encoder.encode(form.getPassword());



        GitHub gitHub = GitHub.connectUsingPassword(form.getLogin(),form.getPassword());



            User newUser = User.builder()
                    .login(form.getLogin())
                    .hashPassword(hashPassword)
                    .role(Role.USER)
                    .state(State.CONFIRMED)
                    .build();

            usersRepository.save(newUser);
            return  newUser;

    }

}
