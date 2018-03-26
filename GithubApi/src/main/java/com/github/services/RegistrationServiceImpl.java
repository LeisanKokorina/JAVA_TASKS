package com.github.services;

import com.github.forms.RegistrationForm;
import com.github.models.*;

import com.github.repo.GHRepo;
import com.github.repo.UsersRepository;
import lombok.SneakyThrows;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private GHRepo ghRepo;
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @SneakyThrows
    @Override
    public String registration(RegistrationForm form) {
        String hashPassword = encoder.encode(form.getPassword());
        GitHub gitHub = GitHub.connectUsingPassword(form.getLogin(), form.getPassword());
        if(gitHub.isCredentialValid()){   //есть ли такой пользователь на GitHub
            //если юзер  попытается еще раз зарегистрироваться, то его перебросит на /login

            //сохраняем в бд юзера, login хранится в lowerCase,
            // а также введеный юзером login тоже преобразуется в lowercase(в классе UsersDetailsServiceImpl)
            User newUser = User.builder()
                    .login(form.getLogin().toLowerCase())
                    .hashPassword(hashPassword)
                    .role(Role.USER)
                    .state(State.CONFIRMED)
                    .build();
            usersRepository.save(newUser);

            //Вытаскиваем репозитории пользователя и сохраняем в бд
            Map<String, GHRepository> repositoryMap = gitHub.getMyself().getAllRepositories();
            List<String> repositoryList = new ArrayList<>(repositoryMap.keySet());
            for (int i = 0; i < repositoryList.size(); i++) {
                Repository repository = Repository.builder()
                        .name(repositoryList.get(i))
                        .user(newUser)
                        .build();
                ghRepo.save(repository);
            }
            return gitHub.getMyself().getLogin();
        }else {
            return "error";
        }

    }

}


