package com.xust.healthotwechat.quartz;

import com.xust.healthotwechat.service.UserService;
import com.xust.healthotwechat.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by evildoerdb_ on 2018/5/14
 *
 * 血糖定时任务
 */
@Slf4j
public class BloodSugarJob implements Job {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取所有用户手机号
        List<String> emailList = userService.findAllEmail();
        for (String email : emailList){
            //如果redis中的数据过去
            if (redisTemplate.opsForValue().get(email+"_three_entry_bloodSugar") == null){
                try {
                    //发送短信
                    //SmsUtils.sendContent(phone,"血糖数据");
                } catch (Exception e) {
                    log.error("【发送提示短信异常】= {}",e.getMessage());
                }
            }
        }
    }
}
