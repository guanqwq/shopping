package org.guanqwq.springbootshopping.service.impl;

import org.guanqwq.springbootshopping.entity.Role;
import org.guanqwq.springbootshopping.entity.User;
import org.guanqwq.springbootshopping.mapper.UserMapper;
import org.guanqwq.springbootshopping.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";
    public static final String EXCEPTION =
            "org.guanqwq.springbootshopping.service.impl.UserServiceImpl.exception";

    @Resource
    private UserMapper mapper;

    /**
     * This method return a user.
     *
     * <p>workflow:</p>
     * <p>1.检索用户名是否存在于用户表中</p>
     * <p>2.检索用户名和密码是否一致</p>
     * <p>3.返回结果</p>
     *
     * @param username 用户名
     * @param password 密码
     * @return result 结果
     */
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        if (mapper.getUser(username, null) == null) {
            result.put(MESSAGE, "查无此人.");
        } else {
            User user = mapper.getUser(username, password);
            if (user != null) {
                result.put(MESSAGE, SUCCESS);
                result.put("user", user);
            } else {
                result.put(MESSAGE, "密码错误.");
            }
        }

        return result;
    }

    /**
     * This method return a list of users.
     *
     * <p>workflow:</p>
     * <p>1.检索参数user和password是否非空</p>
     * <p>2.检索user是否存在于用户表中</p>
     * <p>3.检索user的role字段是否为ADMIN</p>
     *
     * @param loggedUser session中的登录用户
     * @param password 确认管理员本人操作
     * @return result 结果
     */
    @Override
    public Map<String, Object> getUserList(User loggedUser, String password) {
        Map<String, Object> result = new HashMap<>();

        if (loggedUser == null) {
            result.put(MESSAGE, "请登录.");
            return result;
        }

        if (password == null) {
            result.put(MESSAGE, "请输入密码.");
            return result;
        }

        User queryUser = mapper.getUser(loggedUser.getUserName(), password);

        if (queryUser == null) {
            result.put(MESSAGE, "用户名和密码不一致.");
            return result;
        }

        if ( queryUser.getUserRole() != loggedUser.getUserRole() ) {
            result.put(MESSAGE, EXCEPTION);
            return result;
        }

        if (queryUser.getUserRole() == Role.ADMIN) {
            List<User> users = mapper.getAllUsers();

            result.put("num", users.size());
            if (users.size() == 0) {
                result.put(MESSAGE, "用户表为空.");
            } else {
                result.put(MESSAGE, SUCCESS);
                result.put("list", users);
            }
        } else {
            result.put(MESSAGE, "您没有权限.");
        }

        return result;
    }
}
