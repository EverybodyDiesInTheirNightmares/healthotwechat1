package com.xust.healthotwechat.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by evildoerdb_ on 2018/5/8
 *
 * 血糖表单
 */
@Data
public class BloodSugarForm implements Serializable {


    private static final long serialVersionUID = 9004620092969037000L;



    private String email;

    @NotEmpty(message = "血糖不能为空")
    private String bloodSugarValue;

    @NotEmpty(message = "吃饭情况不能为空")
    private String mealCondition;

    @NotEmpty(message = "服药情况不能为空")
    private String medicineCondition;

    private String saveHealthRecord="2";
}
