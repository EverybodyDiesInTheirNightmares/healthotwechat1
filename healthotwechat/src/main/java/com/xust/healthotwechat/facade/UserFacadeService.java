package com.xust.healthotwechat.facade;

import com.xust.healthotwechat.convert.UserConvertService;
import com.xust.healthotwechat.entity.User;
import com.xust.healthotwechat.exception.HealthOTWechatException;
import com.xust.healthotwechat.form.UserForm;
import com.xust.healthotwechat.service.UserService;
import com.xust.healthotwechat.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by evildoerdb_ on 2018/5/6
 *
 * 用户业务归集
 */

@Service
@Slf4j
public class  UserFacadeService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConvertService userConvertService;




//    public boolean login(String username,String password){
//
//        return true;
//    }


    /**
     * 进行注册
     * @param userForm
     * @return
     */
    @Transactional
    public int register(UserForm userForm){

        try {
            /**数据转换*/
            User user = userConvertService.formToEntity(userForm);

            /**数据库加入数据*/
            return userService.insert(user);

        }catch (Exception e){
            log.error("注册异常={}",e.getMessage());
            throw e;
        }

    }

    /**
     * 根据手机号码查询用户是否存在
     * @param email
     * @return true 用户已经存在 false 用户不存在
     */
    public boolean userIsExist(String email){

        User user = findUserByEmail(email);
        if(user !=null ){
            return true;
        }
        return false;
    }

    /**
     * 根据手机号码查询用户
     * @param email
     * @return
     */
    public User findUserByEmail(String email){

        return userService.finfUserByEmail(email);
    }


    /**
     * 根据手机号码修改密码
     * @param email
     * @param password
     * @return
     */
    @Transactional
    public int updatePassword(String email,String password){
        try{

            User user = new User();
            user.setPassword(password);
            user.setEmail(email);

            return userService.updatePassword(user);

        }catch (Exception e){
            throw e;
        }

    }
}
