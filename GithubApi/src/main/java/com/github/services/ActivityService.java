package com.github.services;


import com.github.models.Login;
import com.github.models.Logout;
import com.github.models.User;

import java.util.List;

public interface ActivityService {
    String addLoginTime(User user);
    List<Login>  getLoginHistory();
    List<Logout> getLogoutHistory();
}
