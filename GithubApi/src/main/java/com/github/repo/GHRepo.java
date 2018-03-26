package com.github.repo;

import com.github.models.Repository;
import com.github.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GHRepo extends JpaRepository<Repository, Long> {
    List<Repository> getRepositoriesByUser(User user);
}
