package org.guanqwq.springbootshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productID;
    private String productName;
    private Double productPrice;
    private Integer productNum;
    private String productColor;
    private String productImgUrl;
    private User merchant;
}
