package org.guanqwq.springbootshopping.controller;

import org.guanqwq.springbootshopping.entity.User;
import org.guanqwq.springbootshopping.service.IUserService;
import org.guanqwq.springbootshopping.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("shopping")
public class UserController {

    @Resource
    private IUserService service;

    private String getIPAddress(HttpServletRequest request) {
        String ip = null;

        String[] headers = {
                "x-forwarded-for",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_CLIENT_IP",
                "HTTP_X_FORWARDED_FOR"
        };

        for (String header : headers) {
            if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader(header);
            } else {
                break;
            }
        }

        if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    @PostMapping("login")
    public Map<String, Object> login(HttpServletResponse response, String username, String password) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        return service.login(username, password);
    }

    @PostMapping("users")
    public Map<String, Object> getUsers(HttpServletRequest request, @RequestBody User user, String password) {

        Map<String, Object> result = service.getUserList(user, password);
        if (result.get("message") == UserServiceImpl.EXCEPTION) {
            result.put("message", "你的ip已被记录: " + getIPAddress(request));
        }

        return result;
    }
}
