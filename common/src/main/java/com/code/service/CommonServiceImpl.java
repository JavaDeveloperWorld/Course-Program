package com.code.service;

import com.code.model.Common;
import com.code.model.CommonDetails;
import com.code.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService{
    @Autowired
    CommonRepository commonRepository;
    @Autowired
    CourseTeacherAPI courseTeacherAPI;
    @Autowired
    QueueServiceImpl queueService;

    @Override
    public List<Common> getAllList() {
        return commonRepository.findAll();
    }

    @Override
    public List<CommonDetails> getStudentDetails() {
        List<CommonDetails>getCommonList=new ArrayList<>();
       for(int i=0;i<getAllList().size();i++){
         CommonDetails commonDetails=courseTeacherAPI.getAllDetails(getAllList().get(i));
         getCommonList.add(commonDetails);
       }
        return getCommonList;
    }

    @Override
    public List<CommonDetails> getStudentDetailsByWeb() {
        List<CommonDetails>getCommonList=new ArrayList<>();
        for(int i=0;i<getAllList().size();i++){
            CommonDetails commonDetails=courseTeacherAPI.getDetailsByWebClient(getAllList().get(i));
            getCommonList.add(commonDetails);
        }
        return getCommonList;
    }
    public void getStudentDetailsByRabbit() {
        for(int i=0;i<getAllList().size();i++){
            queueService.getStudentByQueue(getAllList().get(i).getStudent_id());

        }

    }
}
