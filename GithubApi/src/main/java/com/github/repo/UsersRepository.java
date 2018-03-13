package com.github.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.github.models.User;


import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    User findByLoginAndHashPassword(String login, String hashPassword);


}