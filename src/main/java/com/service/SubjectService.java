package com.service;

import com.dao.SubjectDao;
import com.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    public void setSubject(String name, String url){
        Subject subject = new Subject();
        subject.setName(name);
        subject.setUrl(url);

    }

}
