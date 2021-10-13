package org.guanqwq.springbootshopping.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter(AccessLevel.NONE)
    private Integer userID;

    private String userName;

    private Role userRole;

    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private String userPassword;

    @Getter(AccessLevel.NONE)
    private Double userBalance;
}
