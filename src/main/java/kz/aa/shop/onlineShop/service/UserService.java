package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> findUserByEmail(String email);
    List<User> findAll();
    User saveUser(User user);
    Optional<User> findCurrentUser();
}
