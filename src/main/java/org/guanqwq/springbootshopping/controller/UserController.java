package org.guanqwq.springbootshopping.controller;

import org.guanqwq.springbootshopping.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("shopping")
public class UserController {

    @Resource
    private IUserService service;

    @PostMapping("login")
    public Map<String, Object> login(String username, String password) {

        return service.login(username, password);
    }
}
