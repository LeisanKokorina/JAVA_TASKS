package com.github.services;

import com.github.models.Repository;
import com.github.models.User;

import java.util.List;


public interface UserService {

    List<Repository> getRepositories(User user);

}

