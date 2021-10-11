package org.guanqwq.springbootshopping;

import org.guanqwq.springbootshopping.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserMapperTests {

    @Resource
    private UserMapper mapper;

    @Test
    void contextLoads() {
        List<String> list = new ArrayList<>();
        list.add("常鑫");
        list.add("张纪龙");
        list.add("胡玉仙");
        list.add("金宇婷");//commit test 10/11
        list.add("李嘉成");
        // test
        list.add("金宇婷");

        for (String item : list) {
            System.out.println(mapper.getUser(item, null));
        }
    }
}
