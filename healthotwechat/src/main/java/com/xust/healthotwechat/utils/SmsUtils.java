package com.xust.healthotwechat.utils;


import com.xust.healthotwechat.entity.User;
import com.xust.healthotwechat.form.BloodPressureForm;
import com.xust.healthotwechat.form.BloodSugarForm;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.*;

/**
 * 使用邮箱发送，相关信息
 */
public class SmsUtils {
    private static Properties properties = new Properties();
    private static final String GS = "text/html;charset=UTF-8";
    private static Map<Integer, String > sex = new HashMap<>();
    private static Map<Integer, String > order = new HashMap<>();


    private static MimeMessage init_Mail() throws MessagingException {
        properties.setProperty("mail.smtp.host", "smtp.qq.com");//发送邮箱服务器
        properties.setProperty("mail.smtp.port", "465");//发送端口
        properties.setProperty("mail.smtp.auth", "true");//是否开启权限控制
        properties.put("mail.debug", "true");//是否打印信息到控制台
        properties.put("mail.transport.proptocol", "smtp");//发送协议是简单邮箱协议
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.user", "13158528636@qq.com");
        properties.put("mail.password", "tobremczalpvdcde");

        //使用授权信息，构建邮箱会话
        Session session = Session.getInstance(properties,
                new Authenticator() {    //构建授权信息
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.get("mail.user").toString(),
                                properties.get("mail.password").toString());
                    }
                });

        return new MimeMessage(session);
    }

    public static void sendMail(String eMail, String code) throws MessagingException {


        MimeMessage mimeMessage = init_Mail();
        //设置发件人
        mimeMessage.setFrom(new InternetAddress(properties.getProperty("mail.user")));
        //设置收件人
        mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(eMail));

        //设置邮箱标题
        mimeMessage.setSubject("验证码");

        //设置正文
        mimeMessage.setContent("健康小助手提示您验证码为："+code+"<br>"+new Date(), GS);

        //发送邮箱
        Transport.send(mimeMessage);

    }

    //发送邮箱，提示血压录入成功
    public static void sendMessage_(String email, User user, BloodPressureForm bloodPressureForm) throws MessagingException {
        sex.put(0, "未知");
        sex.put(1, "男");
        sex.put(2,"女");
        order.put(1, "前");
        order.put(2, "后");
        MimeMessage mimeMessage = init_Mail();
        mimeMessage.setFrom(new InternetAddress(properties.getProperty("mail.user")));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        mimeMessage.setSubject("尊敬的"+email);
        /**
         * 用户名：
         * 性别：
         * 年龄：
         * 血压：低压~高压（单位）
         * 详情：饭前后，药前后
         * */
        mimeMessage.setContent("用户名:"+user.getUsername()+
                "<br>性别:"+sex.get(Integer.valueOf(user.getSex()))+
                "<br>年龄:"+user.getAge()+
                "<br>血压值:"+bloodPressureForm.getLowPressure()+"~"+bloodPressureForm.getHighPressure()+"(单位:mmHg)"+
                "<br>当前血压状态:饭"+order.get(Integer.valueOf(bloodPressureForm.getMealCondition()))+",药"+order.get(Integer.valueOf(bloodPressureForm.getMedicineCondition())), GS);

        Transport.send(mimeMessage);

    }

    //发送邮箱，提示血糖录入成功
    public static void sendMessage_1(String email, User user, BloodSugarForm bloodSugar) throws MessagingException {
        sex.put(0, "未知");
        sex.put(1, "男");
        sex.put(2,"女");
        order.put(1, "前");
        order.put(2, "后");
        MimeMessage mimeMessage = init_Mail();
        mimeMessage.setFrom(new InternetAddress(properties.getProperty("mail.user")));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        mimeMessage.setSubject("尊敬的"+email);
        /**
         * 用户名：
         * 性别：
         * 年龄：
         * 血压：血糖值（单位）
         * 详情：饭前后，药前后
         * */
        mimeMessage.setContent("用户名:"+user.getUsername()+
                "<br>性别:"+sex.get(Integer.valueOf(user.getSex()))+
                "<br>年龄:"+user.getAge()+
                "<br>血糖值:"+bloodSugar.getBloodSugarValue()+"(单位:mmol/L)"+
                "<br>当前血压状态:饭"+order.get(Integer.valueOf(bloodSugar.getMealCondition()))+",药"+order.get(Integer.valueOf(bloodSugar.getMedicineCondition())), GS);

        Transport.send(mimeMessage);

    }


/*
 * 生成六位的短信验证码
 * @return*/

    public static String verificationCode(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 6 ; i++){
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }


}
