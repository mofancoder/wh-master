package com.mofan.controller;

import org.springframework.web.bind.annotation.RestController;
import com.mofan.bean.ResponseVO;
import com.mofan.enums.ResponseConstant;
import com.mofan.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@RestController
public class BaseController {


    /**
     *
     * @return
     */
    public ResponseVO returnSuccessResult(){
        return returnSuccessResult(null,null,null);
    }

    /**
     * 请求成功返回结果
     * @param response
     * @param data
     * @param message
     * @return
     */
    public ResponseVO returnSuccessResult(HttpServletResponse response, Object data, String message){
        ResponseVO vo = new ResponseVO();
        if(data!=null){
            vo.setResponseData(data);
        }

        if(StringUtils.isNotBlank(message)){
            vo.setResponseMessage(message);
        }
        return vo;
    }

    /**
     *
     * @return
     */
    public ResponseVO returnFailResult(){

        return returnFailResult(null,null, "");
    }

    /**
     * 请求失败返回结果,采用统一枚举（建议使用）
     * @param response
     * @param data
     * @param responseConstant
     * @return
     */
    public ResponseVO returnFailResult(HttpServletResponse response, Object data, ResponseConstant responseConstant){
        ResponseVO vo = new ResponseVO();
        if(responseConstant==null){
            responseConstant = ResponseConstant.FAIL;
        }
        vo.setResponseCode(responseConstant.getCode());
        vo.setResponseMessage(responseConstant.getDescription());
        vo.setResponseData(data);
        return vo;
    }

    /**
     * 自定义返回结果
     * @param response
     * @param data
     * @param message
     * @return
     */
    public ResponseVO returnFailResult(HttpServletResponse response, Object data, String message){
        ResponseVO vo = new ResponseVO();
        vo.setResponseCode(ResponseConstant.FAIL.getCode());
        if(StringUtils.isNotBlank(message)){
            vo.setResponseMessage(message);
        }else{
            vo.setResponseMessage(ResponseConstant.FAIL.getDescription());
        }
        vo.setResponseData(data);
        return vo;
    }

}
