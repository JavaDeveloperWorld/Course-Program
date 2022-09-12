package com.code.service;

import com.code.model.Common;
import com.code.model.CommonDetails;

import java.util.List;

public interface CommonService {

    public List<Common>getAllList();

    public List<CommonDetails> getStudentDetails();

    public List<CommonDetails> getStudentDetailsByWeb();

    public void getStudentDetailsByRabbit();
}
