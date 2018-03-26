package com.github.services;

import com.github.forms.RegistrationForm;
import com.github.models.User;
import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHUser;

import java.util.List;

public interface RegistrationService {

    String registration(RegistrationForm form);


}
