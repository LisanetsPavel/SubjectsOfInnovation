package com.dao;

import com.entity.Location;
import com.entity.Scope;
import com.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface SubjectDao {

    void setSubject(Subject subject);

    Subject getSubjectById(Long subjectId);

    void deleteSubject(Subject subject);

    void updateSubject(Subject subject);

    Subject getSubjectByName(String name);

    List<Subject> getAllSubject();

}
