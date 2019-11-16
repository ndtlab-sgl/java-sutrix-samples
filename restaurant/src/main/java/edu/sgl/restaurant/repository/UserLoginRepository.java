package edu.sgl.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sgl.restaurant.domain.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

  List<UserLogin> findByUsername(String username);

}
