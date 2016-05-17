package com.dao.implement;

import com.dao.SubjectDao;
import com.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class SubjectDaoImpl extends GenericDao implements SubjectDao {
    @Override
    public void setSubject(Subject subject) {
        set(subject);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return (Subject) get(subjectId,  Subject.class);
    }

    @Override
    public void deleteSubject(Subject subject) {
        delete(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        update(subject);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return (Subject) getByName(name, Subject.class);
    }

    @Override
    public List<Subject> getAllSubject() {
        return getAll(Subject.class);
    }


}
