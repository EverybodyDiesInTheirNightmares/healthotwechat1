package com.xust.healthotwechat.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by evildoerdb_ on 2018/4/27
 *
 * 用户
 */

@Data
public class User implements Serializable {


    private static final long serialVersionUID = -2208332251426321465L;
    /**id*/
    private Integer id;

    /**用户手机号码*/
    private String email;

    /**用户身份证号码*/
    private String sno;

    /**用户头像*/
    private String headimgurl;

    /**用户姓名*/
    private String username;

    /**用户密码*/
    private String password;

    /**用户性别 1位男性 2位女性 0为未知*/
    private String sex;

    /**用户年龄*/
    private String age;

    /**监护人手机号码*/
    private String custodyPhone;
    
    /**与监护人关系*/
    private String custodyRelationship;

}
