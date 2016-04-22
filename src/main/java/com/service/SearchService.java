package com.service;

import com.dao.implement.OrganizationDaoMock;
import com.dao.implement.SubjectDaoMock;
import com.entity.Organization;
import com.entity.Subject;
import com.util.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by pc8 on 20.04.16.
 */
@Service
public class SearchService {

    @Autowired
    OrganizationDaoMock organizationDaoMock;

    @Autowired
    SubjectDaoMock subjectDaoMock;

    public Set<Organization> getOrganizationBySubjectId(){

      return new TreeSet<>(organizationDaoMock.getOrganizationsBySubject(new Long(1)));
    }

    public List<Subject> getAllSubjects(){
        List<Subject> resultList = subjectDaoMock.getAllSubject();

        resultList.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject subject, Subject t1) {
              if (subject.getOrganizations() == null ) {
                  return -1;
              } else if (t1.getOrganizations() == null){
                  return 1;
              }
                  if (subject.getOrganizations().size() < t1.getOrganizations().size()) {

                      return 1;
                  } else if (subject.getOrganizations().size() > t1.getOrganizations().size()) {
                      return -1;
                  }

                return 0;
            }
        });
        System.out.println(resultList.toString());
        return resultList;
    }

}
