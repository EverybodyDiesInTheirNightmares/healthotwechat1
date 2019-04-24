package com.xust.healthotwechat.mapper;

import com.xust.healthotwechat.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by evildoerdb_ on 2018/4/27
 *
 * 用户mapper
 */
@Mapper
public interface UserMapper {



    /**插入一条记录*/
    @Insert("insert into user(email,sno,headimgurl,username,password," +
            "sex,age,custody_phone,custody_relationship) " +
            "values(#{email},#{sno},#{headimgurl},#{username},#{password}," +
            "#{sex},#{age},#{custodyPhone},#{custodyRelationship})")
    int insert(User user);

    @Select("select email,sno,headimgurl,username,password,sex,age,custody_phone,custody_relationship from user where email = #{email}")
    @Results({
            @Result(column = "email",property = "email"),
            @Result(column = "sno",property = "sno"),
            @Result(column = "headimgurl",property = "headimgurl"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age"),
            @Result(column = "custody_phone",property = "custodyPhone"),
            @Result(column = "custody_relationship",property = "custodyRelationship"),
    })
    User finfUserByEmail(String email);


    /**
     * 修改密码
     * @param user
     * @return
     */
    @Update("UPDATE user SET password = #{password} WHERE email = #{email}")
    int updatePassword(User user);


    /**
     * 查询所有用户的手机号码
     * @return
     */
    @Select("select email from user")
    List<String> findAllEmail();
}

