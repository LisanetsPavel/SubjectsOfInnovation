package com.service;

import com.dao.implement.OrganizationDaoMock;
import com.entity.Organization;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc8 on 21.04.16.
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationDaoMock organizationDaoMock;

    public String getAllOrganizations(){

        String json = "[{\"id\":null,\"fullName\":\"org\",\"shortName\":null,\"fullNameEng\":null,\"form\":null,\"subordination\":null,\"projects\":null,\"code\":null,\"legalAdress\":null,\"factualAdress\":null,\"phoneNumber\":null,\"site\":null,\"email\":null,\"nameOfDirector\":null,\"founder\":null,\"subject\":{\"id\":null,\"name\":\"sub\",\"url\":null,\"organizations\":null,\"memberships\":null},\"location\":null,\"membership\":null,\"scopes\":[{\"id\":null,\"name\":\"sco\",\"organizations\":null}],\"phases\":[{\"id\":null,\"name\":\"pha\",\"organizations\":null}]}]";

            List<Organization> organization = (List<Organization>) JsonConverter.toJavaObject(json, new ArrayList<Organization>());
            System.out.println(organization.toString());
            return JsonConverter.toJSON(organizationDaoMock.getAllOrganizations());

    }

    public void setOrganization(String organizationJson){
        Organization organization = (Organization) JsonConverter.toJavaObject(organizationJson, new Organization());
    }

}
