package com.service;

import com.dao.OrganizationDao;
import com.dao.implement.OrganizationDaoImpl;
import com.entity.Organization;
import com.entity.Phase;
import com.entity.Scope;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pc8 on 21.04.16.
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationDaoImpl organizationDao;

    @Autowired
    LocationService locationService;

    @Autowired
    MembershipService membershipService;

    @Autowired
    PhaseService phaseService;

    @Autowired
    ScopeService scopeService;

    @Autowired
    SubjectService subjectService;

    static String json = "{\"id\":null,\"fullName\":\"org\",\"shortName\":null,\"fullNameEng\":null,\"form\":null,\"subordination\":null,\"projects\":null,\"code\":null,\"legalAdress\":null,\"factualAdress\":null,\"phoneNumber\":null,\"site\":null,\"email\":null,\"nameOfDirector\":null,\"founder\":null,\"subject\":{\"id\":null,\"name\":\"sub\",\"url\":null,\"organizations\":null,\"memberships\":null},\"location\":null,\"membership\": {\"name\" : \"memberrr\" },\"scopes\":[{\"id\":null,\"name\":\"sco\",\"organizations\":null}],\"phases\":[{\"id\":null,\"name\":\"pha\",\"organizations\":null}]}";

    public String getAllOrganizations(){

            return JsonConverter.toJSON(organizationDao.getAllOrganizations());

    }

    public String getAgreedOrganizations(){

        return JsonConverter.toJSON(organizationDao.getAgreedOrganizations());

    }

    public String getDisagreedOrganizations(){

        return JsonConverter.toJSON(organizationDao.getDisagreedOrganizations());

    }

    public void setOrganization(String organizationJson){
        Organization organization = (Organization) JsonConverter.toJavaObject(organizationJson, new Organization());

        if (organization.getLocation() != null){

             organization.setLocation(locationService.getLocationByName(organization.getLocation().getName()));
        }

        if (organization.getSubject() != null){
            System.out.println(subjectService);
            organization.setSubject(subjectService.getSubjectByName(organization.getSubject().getName()));
        }

        if (organization.getMembership() != null){
           organization.setMembership( membershipService.getMembershipByName(organization.getMembership().getName()));
        }

        if (organization.getScopes() != null){

            Set<Scope> scopeSet = new HashSet<>();

            for (Scope scope : organization.getScopes()){
                scopeSet.add(scopeService.getSopeByName(scope.getName()));
            }

            organization.setScopes(scopeSet);
        }


        if (organization.getPhases() != null){

            Set<Phase> phaseSet = new HashSet<>();

            for (Phase phase : organization.getPhases()){
                phaseSet.add(phaseService.getPhaseByName(phase.getName()));
            }

            organization.setPhases(phaseSet);
        }




        new OrganizationDaoImpl().setOrganization(organization);

        System.out.println(organization.getMembership().getName());
    }

    public static void main(String[] args) {

        new OrganizationService().setOrganization(json);

    }

}
