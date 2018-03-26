package com.github.services;

import com.github.models.Repository;
import com.github.models.User;
import com.github.repo.GHRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private GHRepo ghRepo;

    @Override
    public List<Repository> getRepositories(User user) {
        return ghRepo.getRepositoriesByUser(user);
    }
}
