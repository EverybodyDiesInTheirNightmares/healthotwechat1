package com.xust.healthotwechat.mapper;

import com.xust.healthotwechat.entity.Mood;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by evildoerdb_ on 2018/5/4
 *
 * 心情mapper
 */

@Mapper
public interface MoodMapper {

    /**插入一条数据.*/
    @Insert("insert into mood(email,morning_mood,noon_mood,night_mood,create_time) " +
            "values(#{email},#{morningMood},#{noonMood},#{nightMood},#{createTime})")
    int insert(Mood mood);


    /**查询历史记录*/
    @Select("select email,morning_mood,noon_mood,night_mood,create_time from mood " +
            "where email = #{email} order by create_time desc limit 7")
    @Results({
            @Result(column = "email",property = "email"),
            @Result(column = "morning_mood",property = "morningMood"),
            @Result(column = "noon_mood",property = "noonMood"),
            @Result(column = "night_mood",property = "nightMood"),
            @Result(column = "create_time",property = "createTime"),
    })
    List<Mood> findMoodList(@Param("email")String email);
}
