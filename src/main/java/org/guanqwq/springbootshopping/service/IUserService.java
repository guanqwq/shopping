package org.guanqwq.springbootshopping.service;

import java.util.Map;

public interface IUserService {
    Map<String, Object> login(String username, String password);
}
