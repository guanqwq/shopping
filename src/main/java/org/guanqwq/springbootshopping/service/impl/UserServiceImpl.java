package org.guanqwq.springbootshopping.service.impl;

import org.guanqwq.springbootshopping.entity.User;
import org.guanqwq.springbootshopping.mapper.UserMapper;
import org.guanqwq.springbootshopping.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper mapper;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        User user = mapper.getUser(username, null);

        if (user == null) {
            result.put("message", "查无此人.");
        } else {
            user = mapper.getUser(username, password);
            if (user != null) {
                result.put("message", "success.");
                result.put("user", user);
            } else {
                result.put("message", "密码错误.");
            }
        }

        return result;
    }
}
