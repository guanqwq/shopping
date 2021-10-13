package org.guanqwq.springbootshopping.service;

import java.util.Map;

public interface IProductService {
    Map<String, Object> getProducts(String keyword, Integer index, Integer num);
    Map<String, Object> getProduct(Integer id);
}
