package com.service;

import com.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 19.04.16.
 */
@Service
public class TestService {

    @Autowired
    SubjectDao subjectDao;
      public void service(){
          System.out.println(subjectDao);
          System.out.println("Service!!!");
      }

}
