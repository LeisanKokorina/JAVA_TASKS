package com.github.repo;


import com.github.models.Logout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogoutRepository  extends JpaRepository<Logout,Long> {
}
