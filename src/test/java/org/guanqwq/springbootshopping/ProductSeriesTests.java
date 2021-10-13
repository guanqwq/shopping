package org.guanqwq.springbootshopping;

import org.guanqwq.springbootshopping.entity.Product;
import org.guanqwq.springbootshopping.mapper.ProductMapper;
import org.guanqwq.springbootshopping.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ProductSeriesTests {

    @Resource
    private ProductMapper mapper;

    @Resource
    private IProductService service;

    public String convertJson(Map<String, Object> map) {
        StringBuilder builder = new StringBuilder("{\n");

        for (String key : map.keySet()) {
            builder.append( String.format("\t%s: %s\n", key, map.get(key)) );
        }

        return new String(builder.append("}"));
    }

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

    @Test
    void getProductIDTest() {
        Map<String, Object> result = service.getProduct(20210012);

        System.out.println(convertJson(result));
    }
}
