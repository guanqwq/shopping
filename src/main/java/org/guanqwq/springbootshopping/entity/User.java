package org.guanqwq.springbootshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userID;
    private String userName;
    private Role userRole;
    private String userPassword;
    private Double userBalance;
}
