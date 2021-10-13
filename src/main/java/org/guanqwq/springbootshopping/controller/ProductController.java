package org.guanqwq.springbootshopping.controller;

import org.guanqwq.springbootshopping.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("shopping")
public class ProductController {

    @Resource
    private IProductService service;

    @RequestMapping("products")
    public Map<String, Object> getProducts(String keyword, Integer index, Integer num) {

        return service.getProducts(keyword, index, num);
    }
}
