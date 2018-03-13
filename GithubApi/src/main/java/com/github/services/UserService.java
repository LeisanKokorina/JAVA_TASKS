package com.github.services;

import com.github.models.User;
import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserService {

   // List<String> getRepositories(User user);

    User getUser(Long userId);
}

