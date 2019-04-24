package com.xust.healthotwechat.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by evildoerdb_ on 2018/5/12
 *
 * 用户登录表单验证
 *
 *
 */
@Data
public class UserLoginForm implements Serializable {


    private static final long serialVersionUID = -6801886990552764852L;

    @NotEmpty(message = "用户电子邮箱不能为空")
    private String email;

    @NotEmpty(message = "用户密码不能为空")
    private String password;
}
