package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;

import java.util.List;


public interface UserService {
    User findUserByEmail(String email);
    List<User> findAll();
    User saveUser(User user);
}
