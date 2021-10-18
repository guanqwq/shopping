package org.guanqwq.springbootshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShrineProduct {
    private String title;
    private String url;
    private Double price;

    public String getPrice() {
        return "¥" + price;
    }
}
