package com.dao.implement;

import com.entity.Organization;
import com.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pc8 on 20.04.16.
 */
@Repository
public class SubjectDaoMock {

    public List<Subject> getAllSubject(){
        Set<Organization> setOrg = new HashSet<>();
        List<Subject> resultSet = new ArrayList<>();

        Organization organization = new Organization();
        organization.setFullName("One");
        Organization organization1 = new Organization();
        organization1.setFullName("Two");
        Organization organization2 = new Organization();
        organization2.setFullName("Three");


        Subject subject = new Subject();
        subject.setName("I have 0 orgs");

        Subject subject1 = new Subject();
        setOrg.add(organization);
        subject1.setOrganizations(setOrg);
        subject1.setName("I have 1 org");

        Subject subject2 = new Subject();
        setOrg.add(organization1);
        subject2.setOrganizations(setOrg);
        subject2.setName("I have 2 orgss");

        Subject subject3 = new Subject();

        setOrg.add(organization2);
        subject3.setOrganizations(setOrg);
        subject3.setName("I have 3 orgsss");

        resultSet.add(subject);
        resultSet.add(subject1);
        resultSet.add(subject2);
        resultSet.add(subject3);

        return resultSet;
    }

}
