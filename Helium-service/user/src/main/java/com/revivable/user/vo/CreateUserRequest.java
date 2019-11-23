package com.revivable.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

//创建用户请求对象定义
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;
    private String email;

    public boolean validate(){
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
