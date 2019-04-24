package com.xust.healthotwechat.mapper;

import com.xust.healthotwechat.entity.BloodPressure;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by evildoerdb_ on 2018/4/27
 *
 * 血压mapper
 */
@Mapper
public interface BloodPressureMapper {

    /**插入一条数据.*/
    @Insert("insert into blood_pressure(email,high_pressure,low_pressure,meal_condition," +
            "medicine_condition,save_health_record,measure_time) " +
            "values(#{email},#{highPressure},#{lowPressure},#{mealCondition}," +
            "#{medicineCondition},#{saveHealthRecord},#{measureTime})")
    int insert(BloodPressure bloodPressure);


    /**根据手机号码查询最近十条记录*/
    @Select("select email,high_pressure,low_pressure,measure_time from blood_pressure where email = #{email} " +
            "order by measure_time desc limit 7")
    @Results({
            @Result(property = "email", column = "email"),
            @Result(property = "highPressure", column = "high_pressure"),
            @Result(property = "lowPressure", column = "low_pressure"),
            @Result(property = "measureTime", column = "measure_time"),
    })
    List<BloodPressure> findBloodPressureList(@Param("email") String email);
}
