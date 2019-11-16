package edu.sgl.restaurant.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sgl.restaurant.domain.UserLogin;

@SpringBootTest
public class UserLoginRepositoryIT {

  @Autowired
  private UserLoginRepository repository;

  @Test
  public void test() {
    UserLogin userLogin = UserLogin.builder()
        .username("thinguyen")
        .fullname("ABV")
        .age(18)
        .build();
    //repository.save(userLogin);
  }

  @Test
  public void testGetData() {
    List<UserLogin> users = repository.findByUsername("thinguyen");

    for (UserLogin user : users) {
      System.out.println(user.getUsername());
    }

  }
}
