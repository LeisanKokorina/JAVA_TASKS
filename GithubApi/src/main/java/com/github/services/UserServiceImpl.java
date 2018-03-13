package com.github.services;

import com.github.models.User;
import com.github.repo.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public User getUser(Long userId) {
        return usersRepository.findOne(userId);
    }


//  Пока не работает
//    @Override
//    public List<String> getRepositories(User user)  {
//
//        try {
//            GitHub github = GitHub.connect(user.getLogin(),);
//
//            Map<String,GHRepository> repositoryMap=github.getMyself().getAllRepositories();
//
//            List<String> repositoryList = new ArrayList<>(repositoryMap.keySet());
//
//            return repositoryList;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null ;
//
//
//    }


}
