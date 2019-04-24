package com.xust.healthotwechat.controller;

import com.google.gson.Gson;
import com.xust.healthotwechat.VO.AjaxResultVo;
import com.xust.healthotwechat.facade.MedicineFacadeService;
import com.xust.healthotwechat.form.MedicineForm;
import com.xust.healthotwechat.utils.AjaxResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by evildoerdb_ on 2018/5/9
 *
 * 药物controller
 */

@RestController
@Slf4j
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineFacadeService medicineFacadeService;


    /**
     * 录入服药数据
     * @param medicineForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/entry")
    public String entry(@Valid MedicineForm medicineForm,
                        BindingResult bindingResult,
                        HttpServletRequest request){

        Gson gson = new Gson();

        AjaxResultVo resultVo;


        try {


            String email = (String) request.getSession().getAttribute("user");

            /**表单校验异常*/
            if (bindingResult.hasErrors()){
                throw  new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
            }


            medicineForm.setEmail(email);

            medicineFacadeService.entry(medicineForm);
            resultVo = AjaxResultVOUtils.success("录入人成功");


        }catch (Exception e){
            log.error("录入服药数据异常={}",medicineForm.getEmail()+e.getMessage());
            resultVo = AjaxResultVOUtils.error(e.getMessage());
        }

        return gson.toJson(resultVo);
    }





}
