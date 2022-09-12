package com.code.controller;

import com.code.model.Common;
import com.code.model.CommonDetails;
import com.code.service.CommonService;
import com.code.service.QueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonRestController {
    @Autowired
    CommonService commonService;


    @GetMapping("/rest")
    public List<CommonDetails>getAllListByRestTemplate(){
        return commonService.getStudentDetails();
    }
    @GetMapping("/all")
    public List<Common>getAllCommonList(){
        return commonService.getAllList();
    }
    @GetMapping("/web")
    public List<CommonDetails>getAllListByWebClient(){
        return commonService.getStudentDetailsByWeb();
    }
    @GetMapping("/rabbit")
    public void getAllListByRabbit(){
         commonService.getStudentDetailsByRabbit();
    }
}
