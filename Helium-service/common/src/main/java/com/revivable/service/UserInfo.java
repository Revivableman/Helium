package com.revivable.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private long id;
    private String username;
    private String email;

    public static UserInfo inValid(){
        return new UserInfo(-1L,"","");
    }
}
