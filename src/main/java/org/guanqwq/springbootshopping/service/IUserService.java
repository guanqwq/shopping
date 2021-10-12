package org.guanqwq.springbootshopping.service;

import org.guanqwq.springbootshopping.entity.User;

import java.util.Map;

public interface IUserService {
    Map<String, Object> login(String username, String password);
    Map<String, Object> getUserList(User user, String password);
}
