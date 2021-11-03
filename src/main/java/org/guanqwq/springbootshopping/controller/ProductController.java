package org.guanqwq.springbootshopping.controller;

import org.guanqwq.springbootshopping.entity.ShrineProduct;
import org.guanqwq.springbootshopping.mapper.ProductMapper;
import org.guanqwq.springbootshopping.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shopping")
public class ProductController {

    @Resource
    private IProductService service;

    @Resource
    private ProductMapper mapper;

    @RequestMapping("products")
    public Map<String, Object> getProducts(HttpServletResponse response, String keyword, Integer index, Integer num) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        return service.getProducts(keyword, index, num);
    }

    @RequestMapping("product")
    public Map<String, Object> getProduct(Integer id) {

        return service.getProduct(id);
    }

    @RequestMapping("productsjson")
    public List<ShrineProduct> getProductsJson() {

        return mapper.getProductsJson();
    }
}