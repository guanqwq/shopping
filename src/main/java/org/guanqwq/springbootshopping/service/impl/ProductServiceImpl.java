package org.guanqwq.springbootshopping.service.impl;

import org.guanqwq.springbootshopping.entity.Product;
import org.guanqwq.springbootshopping.mapper.ProductMapper;
import org.guanqwq.springbootshopping.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "success";

    @Resource
    private ProductMapper mapper;

    @Override
    public Map<String, Object> getProducts(String keyword, Integer index, Integer num) {
        Map<String, Object> result = new HashMap<>();

        Integer productNumber = mapper.getProductNumber(keyword);
        result.put("num", productNumber);

        List<Product> products = mapper.getProducts(keyword, index, num);
        result.put("products", products);

        result.put(MESSAGE, SUCCESS);

        return result;
    }
}
