package org.guanqwq.springbootshopping.mapper;

import org.apache.ibatis.annotations.*;
import org.guanqwq.springbootshopping.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Results(id = "product_field_mapper",
            value = {
                @Result(column = "pid", property = "productID", id = true),
                @Result(column = "name", property = "productName"),
                @Result(column = "price", property = "productPrice"),
                @Result(column = "num", property = "productNum"),
                @Result(column = "color", property = "productColor"),
                @Result(column = "pic_url", property = "productImgUrl"),
                @Result(column = "merchant_id", property = "merchant",
                        one = @One(select = "org.guanqwq.springbootshopping.mapper.UserMapper.getUserByID"))
    })
    @Select("<script>" +
            "SELECT * FROM product" +
            "<if test=\"keyword!=null and keyword!=''\"> WHERE name like '%${keyword}%' </if>" +
            "LIMIT #{index}, #{num}" +
            "</script>")
    List<Product> getProducts(
            @Param("keyword") String keyword,
            @Param("index") Integer index,
            @Param("num") Integer num
    );

    @Select("<script>" +
            "SELECT COUNT(*) FROM product" +
            "<if test=\"keyword!=null and keyword!=''\"> WHERE name like '%${keyword}%' </if>" +
            "</script>")
    Integer getProductNumber(@Param("keyword") String keyword);
}
