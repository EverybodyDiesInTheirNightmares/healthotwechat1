package com.xust.healthotwechat.Test;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


@Configuration
@EnableScheduling
public class QQMeilTest {

    public static void main(String[] args) throws MessagingException {



        scheduler();
        System.out.println("HelloWorld");
        a();
    }
    public static void a(){
        System.out.println("hhhhhh");
    }

    public static void scheduler() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task  run:"+ new Date());
            }
        };
        Timer timer = new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
        timer.schedule(timerTask,10,3000);
    }




}
