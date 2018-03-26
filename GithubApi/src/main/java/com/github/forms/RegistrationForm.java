package com.github.forms;

import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Data
public class RegistrationForm {
    private String login;
    private String password;

}
