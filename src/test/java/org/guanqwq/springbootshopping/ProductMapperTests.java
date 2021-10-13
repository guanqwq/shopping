package org.guanqwq.springbootshopping;

import org.guanqwq.springbootshopping.entity.Product;
import org.guanqwq.springbootshopping.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ProductMapperTests {

    @Resource
    private ProductMapper mapper;

    @Test
    void getProductsTest() {
        List<Product> list = mapper.getProducts("", 0, 9);

        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    void getProductNumberTest() {
        System.out.println(mapper.getProductNumber("京东京造"));
    }
}
